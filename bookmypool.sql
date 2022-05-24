-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2022 a las 15:56:40
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bookmypool`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brand`
--

CREATE TABLE `brand` (
  `id` int(10) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `brand`
--

INSERT INTO `brand` (`id`, `name`) VALUES
(1, 'Acer'),
(2, 'Alcatel'),
(3, 'Apple'),
(4, 'Asus'),
(5, 'BlackBerry'),
(6, 'BlackView'),
(7, 'BQ'),
(8, 'DOOGEE'),
(9, 'Fairphone'),
(10, 'Google'),
(11, 'Honor'),
(12, 'HP'),
(13, 'HTC'),
(14, 'Huawei'),
(15, 'Lenovo'),
(16, 'Leotec'),
(17, 'LG'),
(18, 'Meizu'),
(19, 'Microsoft'),
(20, 'Motorola'),
(21, 'Nokia'),
(22, 'OnePlus'),
(23, 'Oppo'),
(24, 'Panasonic'),
(25, 'POCO'),
(26, 'Realme'),
(27, 'Samsung'),
(28, 'Sony'),
(29, 'Sony-Ericsson'),
(30, 'TCL'),
(31, 'THL'),
(32, 'Xiaomi'),
(33, 'Zopo'),
(34, 'ZTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `device`
--

CREATE TABLE `device` (
  `id` int(10) NOT NULL,
  `isBooked` int(1) DEFAULT 0,
  `serial_number` varchar(95) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `operative_system` varchar(45) DEFAULT NULL,
  `version` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `device`
--

INSERT INTO `device` (`id`, `isBooked`, `serial_number`, `brand`, `model`, `operative_system`, `version`) VALUES
(1, 0, 'DB168091200530', 'Samsung', 'Galaxy M23', 'Android', '12'),
(2, 0, 'FS428091430520', 'Samsung', 'Galaxy A22', 'Android', '11'),
(4, 0, 'QB148091200143', 'Apple', 'iPhone 11', 'iOS', '13'),
(7, 0, 'TR428091435520', 'Samsung', 'Galaxy A21', 'Android', '10'),
(8, 0, 'RC411091765510', 'Samsung', 'Galaxy A5', 'Android', '8'),
(10, 0, 'LR421091330553', 'Huawei', 'P30', 'Android', '9'),
(11, 0, 'HY421091330736', 'OnePlus', '7', 'Android', '9');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `id` int(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(95) NOT NULL,
  `telephone` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`, `telephone`) VALUES
(5, 'María', 'Muñoz', 'm.munoz@mail.com', '693258741'),
(6, 'José', 'Castro', 'j.castro@mail.com', '654789654');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lend`
--

CREATE TABLE `lend` (
  `id` int(10) NOT NULL,
  `lending_date` date NOT NULL,
  `returning_date` date DEFAULT NULL,
  `device_id` int(10) NOT NULL,
  `employee_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lend`
--

INSERT INTO `lend` (`id`, `lending_date`, `returning_date`, `device_id`, `employee_id`) VALUES
(1, '2022-05-24', NULL, 2, 6),
(2, '2022-05-24', NULL, 11, 5),
(3, '2022-05-23', NULL, 4, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lend`
--
ALTER TABLE `lend`
  ADD PRIMARY KEY (`id`),
  ADD KEY `device_id` (`device_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `device`
--
ALTER TABLE `device`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `lend`
--
ALTER TABLE `lend`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lend`
--
ALTER TABLE `lend`
  ADD CONSTRAINT `lend_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `lend_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
