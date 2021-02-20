-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2021 a las 20:11:17
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
--
-- Base de datos: `prueba_sw`
--

drop table if exists task;
drop table if exists state;
drop table if exists panel;
drop table if exists `user`;

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  phone varchar(12) DEFAULT NULL,
  password varchar(255) NOT NULL,
  deleted BOOLEAN default false
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `panel`
--

CREATE TABLE panel (
  id int(11) NOT NULL PRIMARY KEY,
  name varchar(255) NOT NULL,
  user_id int(11) NOT NULL,
  deleted BOOLEAN default false,
  FOREIGN KEY(user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `state`
--

CREATE TABLE state (
  id int(11) NOT NULL PRIMARY KEY,
  name varchar(255) NOT NULL,
  place int(11) NOT NULL,
  panel_id int(11) NOT NULL,
  deleted BOOLEAN default false,
  FOREIGN KEY(panel_id) REFERENCES panel(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `task`
--

CREATE TABLE task (
  id int(11) NOT NULL PRIMARY KEY,
  title varchar(255) NOT NULL,
  location int(11) DEFAULT NULL,
  expirationDate datetime DEFAULT NULL,
  description varchar(512) DEFAULT NULL,
  state_id int(11) NOT NULL,
  deleted BOOLEAN default false,
  FOREIGN KEY(state_id) REFERENCES state(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Jwt`
--

CREATE TABLE jwt (
  id int(11) NOT NULL PRIMARY KEY,
  value varchar (512) NOT NULL,
  expiration dateTime NOT NULL,
  user_id int(11) NOT null,
  FOREIGN KEY(user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- --------------------------------------------------------


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
