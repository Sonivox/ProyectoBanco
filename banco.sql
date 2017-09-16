-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-09-2017 a las 06:50:38
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `banco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `nombre_cliente` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido_cliente` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DUI_cli` int(10) NOT NULL,
  `correo_cliente` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `telefono_cliente` int(8) NOT NULL,
  PRIMARY KEY (`DUI_cli`),
  UNIQUE KEY `correo_cliente` (`correo_cliente`),
  UNIQUE KEY `telefono_cliente` (`telefono_cliente`),
  KEY `nombre_cliente` (`nombre_cliente`),
  KEY `apellido_cliente` (`apellido_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE IF NOT EXISTS `cuentas` (
  `num_cuenta` int(10) NOT NULL AUTO_INCREMENT,
  `tipo_cuenta` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `saldo_cuenta` double(5,2) NOT NULL,
  `nombre_cliente` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido_cliente` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`num_cuenta`),
  KEY `nombre_cliente` (`nombre_cliente`),
  KEY `apellido_cliente` (`apellido_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE IF NOT EXISTS `tarjeta` (
  `num_tarjeta` int(16) NOT NULL AUTO_INCREMENT,
  `num_cuenta` int(10) NOT NULL,
  `PIN_tarjeta` int(4) NOT NULL,
  `experia_tarjeta` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre_cliente` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido_cliente` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`num_tarjeta`,`PIN_tarjeta`),
  KEY `nombre_cliente` (`nombre_cliente`),
  KEY `apellido_cliente` (`apellido_cliente`),
  KEY `num_cuenta` (`num_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE IF NOT EXISTS `transaccion` (
  `tipo_tran` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `monto_tran` double(5,2) NOT NULL,
  `fecha_tran` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `num_tran` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`num_tran`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `cuentas_ibfk_2` FOREIGN KEY (`apellido_cliente`) REFERENCES `clientes` (`apellido_cliente`),
  ADD CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`nombre_cliente`) REFERENCES `clientes` (`nombre_cliente`);

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`nombre_cliente`) REFERENCES `clientes` (`nombre_cliente`),
  ADD CONSTRAINT `tarjeta_ibfk_2` FOREIGN KEY (`apellido_cliente`) REFERENCES `clientes` (`apellido_cliente`),
  ADD CONSTRAINT `tarjeta_ibfk_3` FOREIGN KEY (`num_cuenta`) REFERENCES `cuentas` (`num_cuenta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
