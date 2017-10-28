-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-10-2017 a las 16:50:31
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cajero`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_saldo`(IN `numero` INT(10))
    NO SQL
SELECT saldoCu FROM cuentas WHERE numeroCu = numero$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_tran`(IN `numero` INT(4), IN `tipo` VARCHAR(25))
    NO SQL
SELECT * FROM transaccion WHERE numeroCu = numero
AND tipoTran = tipo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `depositar_dinero`(IN `cantidad` DOUBLE(5,2), IN `idcu` INT(10))
    NO SQL
UPDATE cuentas SET  saldoCu = saldoCu + cantidad WHERE cuentas.numeroCu = idcu$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cliente`(IN `nombre` VARCHAR(25), IN `apellido` VARCHAR(25), IN `DUI` INT(9), IN `correo` VARCHAR(25), IN `telefono` INT(8))
    NO SQL
INSERT INTO clientes(nombreCli, apellidoCli, DUICli, correoCli
, telefonoCli, IDCli) VALUES (nombre, apellido, DUI, correo, telefono, null)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cuenta`(IN `tipo` VARCHAR(10), IN `saldo` DOUBLE(5,2), IN `ID` INT(10), IN `nombre` VARCHAR(25), IN `apellido` VARCHAR(25))
    NO SQL
INSERT INTO cuentas(numeroCu, tipoCu, saldoCU, IDCli, nombreCli, apellidoCli)
VALUES(null, tipo, saldo, ID, nombre, apellido)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_tarjeta`(IN `numerotar` VARCHAR(16), IN `numerocu` INT(10), IN `pin` INT(4), IN `expira` VARCHAR(5), IN `ID` INT(10), IN `nombre` VARCHAR(25), IN `apellido` VARCHAR(25))
    NO SQL
INSERT INTO tajeta(numeroTar, numeroCu, PINTar, expiraTar,
IDCli, nombreCli, apellidoCli) VALUES(numerotar, numerocu,
pin, expira, ID, nombre, apellido)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_tran`(IN `tipo` VARCHAR(25), IN `monto` VARCHAR(5), IN `fecha` VARCHAR(35), IN `cuenta` VARCHAR(10), IN `nombre` VARCHAR(25), IN `apellido` VARCHAR(25))
    NO SQL
INSERT INTO transaccion(tipoTran, montoTran, fechaTran, numeroCu,
numeroTran, nombreCli, apellidoCli) VALUES(tipo, monto, fecha, cuenta,
null, nombre, apellido)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `retirar_dinero`(IN `cantidad` INT(5), IN `idcu` INT(10))
    NO SQL
UPDATE cuentas SET  saldoCu = saldoCu - cantidad WHERE cuentas.numeroCu = idcu$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `nombreCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `DUICli` int(9) NOT NULL,
  `correoCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `telefonoCli` int(8) NOT NULL,
  `IDCli` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`IDCli`),
  UNIQUE KEY `nombreCli` (`nombreCli`),
  UNIQUE KEY `apellidoCli` (`apellidoCli`),
  KEY `nombreCli_2` (`nombreCli`),
  KEY `apellidoCli_2` (`apellidoCli`),
  KEY `IDCli` (`IDCli`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nombreCli`, `apellidoCli`, `DUICli`, `correoCli`, `telefonoCli`, `IDCli`) VALUES
('Roberto Herberth', 'Maltez Guardado', 123456789, 'maltez7177@gmail.com', 71779593, 1),
('Ronald Remberto', 'Rivas Rodriguez', 123456987, 'ronaldrem@gmail.com', 77985664, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE IF NOT EXISTS `cuentas` (
  `numeroCu` int(10) NOT NULL AUTO_INCREMENT,
  `tipoCu` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `saldoCu` double(5,2) NOT NULL,
  `IDCli` int(10) NOT NULL,
  `nombreCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`numeroCu`),
  KEY `numeroCu` (`numeroCu`),
  KEY `nombreCli` (`nombreCli`),
  KEY `apellidoCli` (`apellidoCli`),
  KEY `IDCli` (`IDCli`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`numeroCu`, `tipoCu`, `saldoCu`, `IDCli`, `nombreCli`, `apellidoCli`) VALUES
(1, 'ahorros', 170.00, 1, 'Roberto Herberth', 'Maltez Guardado'),
(2, 'ahorros', 452.00, 2, 'Ronald Remberto', 'Rivas Rodriguez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tajeta`
--

CREATE TABLE IF NOT EXISTS `tajeta` (
  `numeroTar` varchar(16) COLLATE utf8_spanish_ci NOT NULL,
  `numeroCU` int(10) NOT NULL,
  `PINTar` int(4) NOT NULL,
  `expiraTar` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `IDCli` int(10) NOT NULL,
  `nombreCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`numeroTar`),
  KEY `apellidoCli` (`apellidoCli`),
  KEY `nombreCli` (`nombreCli`),
  KEY `IDCli` (`IDCli`),
  KEY `numeroCU` (`numeroCU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tajeta`
--

INSERT INTO `tajeta` (`numeroTar`, `numeroCU`, `PINTar`, `expiraTar`, `IDCli`, `nombreCli`, `apellidoCli`) VALUES
('1234000045670000', 2, 1240, '12/23', 2, 'Ronald Remberto', 'Rivas Rodriguez'),
('1234432156788765', 1, 1234, '10/22', 1, 'Roberto Herberth', 'Maltez Guardado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE IF NOT EXISTS `transaccion` (
  `tipoTran` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `montoTran` double(5,2) NOT NULL,
  `fechaTran` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `numeroCu` int(10) NOT NULL,
  `numeroTran` int(10) NOT NULL AUTO_INCREMENT,
  `nombreCli` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoCLi` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`numeroTran`),
  KEY `apellidoCLi` (`apellidoCLi`),
  KEY `numeroCu` (`numeroCu`),
  KEY `nombreCli` (`nombreCli`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=29 ;

--
-- Volcado de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`tipoTran`, `montoTran`, `fechaTran`, `numeroCu`, `numeroTran`, `nombreCli`, `apellidoCLi`) VALUES
('RETIRO DE EFECTIVO', 10.00, '19:12 P.M. del 26 de Octubre 2017', 1, 3, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '21:26 P.M. del 26 de Octubre 2017', 1, 4, 'Roberto Herberth', 'Maltez Guardado'),
('DEPOSITO DE EFECTIVO', 20.00, '21:27 P.M. del 26 de Octubre 2017', 1, 5, 'Roberto Herberth', 'Maltez Guardado'),
('DEPOSITO DE EFECTIVO', 10.00, '21:27 P.M. del 26 de Octubre 2017', 1, 6, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 20.00, '21:27 P.M. del 26 de Octubre 2017', 1, 7, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '21:30 P.M. del 26 de Octubre 2017', 2, 8, 'Ronald Remberto', 'Rivas Rodriguez'),
('DEPOSITO DE EFECTIVO', 5.00, '21:30 P.M. del 26 de Octubre 2017', 2, 9, 'Ronald Remberto', 'Rivas Rodriguez'),
('RETIRO DE EFECTIVO', 20.00, '21:30 P.M. del 26 de Octubre 2017', 2, 10, 'Ronald Remberto', 'Rivas Rodriguez'),
('DEPOSITO DE EFECTIVO', 20.00, '21:35 P.M. del 26 de Octubre 2017', 1, 11, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '22:31 P.M. del 26 de Octubre 2017', 1, 12, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '23:13 P.M. del 26 de Octubre 2017', 1, 13, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '23:35 P.M. del 26 de Octubre 2017', 1, 14, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '8:36 P.M. del 27 de Octubre 2017', 1, 16, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '8:45 A.M. del 27 de Octubre 2017', 1, 17, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '8:57 A.M. del 27 de Octubre 2017', 1, 18, 'Roberto Herberth', 'Maltez Guardado'),
('DEPOSITO DE EFECTIVO', 10.00, '8:57 A.M. del 27 de Octubre 2017', 1, 19, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '9:6 A.M. del 27 de Octubre 2017', 2, 20, 'Ronald Remberto', 'Rivas Rodriguez'),
('RETIRO DE EFECTIVO', 10.00, '9:11 A.M. del 27 de Octubre 2017', 2, 21, 'Ronald Remberto', 'Rivas Rodriguez'),
('RETIRO DE EFECTIVO', 5.00, '9:40 A.M. del 27 de Octubre 2017', 1, 22, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '9:51 A.M. del 27 de Octubre 2017', 1, 23, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 125.00, '10:5 A.M. del 27 de Octubre 2017', 2, 24, 'Ronald Remberto', 'Rivas Rodriguez'),
('RETIRO DE EFECTIVO', 20.00, '10:40 A.M. del 27 de Octubre 2017', 1, 25, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 5.00, '10:48 A.M. del 27 de Octubre 2017', 1, 26, 'Roberto Herberth', 'Maltez Guardado'),
('RETIRO DE EFECTIVO', 10.00, '10:49 A.M. del 27 de Octubre 2017', 2, 27, 'Ronald Remberto', 'Rivas Rodriguez'),
('DEPOSITO DE EFECTIVO', 5.00, '10:49 A.M. del 27 de Octubre 2017', 2, 28, 'Ronald Remberto', 'Rivas Rodriguez');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`IDCli`) REFERENCES `clientes` (`IDCli`),
  ADD CONSTRAINT `cuentas_ibfk_2` FOREIGN KEY (`nombreCli`) REFERENCES `clientes` (`nombreCli`),
  ADD CONSTRAINT `cuentas_ibfk_3` FOREIGN KEY (`apellidoCli`) REFERENCES `clientes` (`apellidoCli`);

--
-- Filtros para la tabla `tajeta`
--
ALTER TABLE `tajeta`
  ADD CONSTRAINT `tajeta_ibfk_1` FOREIGN KEY (`numeroCU`) REFERENCES `cuentas` (`numeroCu`),
  ADD CONSTRAINT `tajeta_ibfk_2` FOREIGN KEY (`IDCli`) REFERENCES `clientes` (`IDCli`),
  ADD CONSTRAINT `tajeta_ibfk_3` FOREIGN KEY (`nombreCli`) REFERENCES `clientes` (`nombreCli`),
  ADD CONSTRAINT `tajeta_ibfk_4` FOREIGN KEY (`apellidoCli`) REFERENCES `clientes` (`apellidoCli`);

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `transaccion_ibfk_1` FOREIGN KEY (`numeroCu`) REFERENCES `cuentas` (`numeroCu`),
  ADD CONSTRAINT `transaccion_ibfk_2` FOREIGN KEY (`nombreCli`) REFERENCES `clientes` (`nombreCli`),
  ADD CONSTRAINT `transaccion_ibfk_3` FOREIGN KEY (`apellidoCLi`) REFERENCES `clientes` (`apellidoCli`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
