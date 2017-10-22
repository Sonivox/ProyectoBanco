-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 21-10-2017 a las 22:12:30
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tajeta`
--

CREATE TABLE IF NOT EXISTS `tajeta` (
  `numeroTar` int(16) NOT NULL,
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE IF NOT EXISTS `transaccion` (
  `tipoTran` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `montoTran` double(5,2) NOT NULL,
  `fechaTran` int(25) NOT NULL,
  `numeroCu` int(10) NOT NULL,
  `numeroTran` int(10) NOT NULL AUTO_INCREMENT,
  `nombreCli` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoCLi` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`numeroTran`),
  KEY `apellidoCLi` (`apellidoCLi`),
  KEY `numeroCu` (`numeroCu`),
  KEY `nombreCli` (`nombreCli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `cuentas_ibfk_3` FOREIGN KEY (`apellidoCli`) REFERENCES `clientes` (`apellidoCli`),
  ADD CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`IDCli`) REFERENCES `clientes` (`IDCli`),
  ADD CONSTRAINT `cuentas_ibfk_2` FOREIGN KEY (`nombreCli`) REFERENCES `clientes` (`nombreCli`);

--
-- Filtros para la tabla `tajeta`
--
ALTER TABLE `tajeta`
  ADD CONSTRAINT `tajeta_ibfk_4` FOREIGN KEY (`apellidoCli`) REFERENCES `clientes` (`apellidoCli`),
  ADD CONSTRAINT `tajeta_ibfk_1` FOREIGN KEY (`numeroCU`) REFERENCES `cuentas` (`numeroCu`),
  ADD CONSTRAINT `tajeta_ibfk_2` FOREIGN KEY (`IDCli`) REFERENCES `clientes` (`IDCli`),
  ADD CONSTRAINT `tajeta_ibfk_3` FOREIGN KEY (`nombreCli`) REFERENCES `clientes` (`nombreCli`);

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `transaccion_ibfk_3` FOREIGN KEY (`apellidoCLi`) REFERENCES `clientes` (`apellidoCli`),
  ADD CONSTRAINT `transaccion_ibfk_1` FOREIGN KEY (`numeroCu`) REFERENCES `cuentas` (`numeroCu`),
  ADD CONSTRAINT `transaccion_ibfk_2` FOREIGN KEY (`nombreCli`) REFERENCES `clientes` (`nombreCli`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
