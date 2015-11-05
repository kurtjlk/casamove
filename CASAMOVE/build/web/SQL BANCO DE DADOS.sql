-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Abr-2015 às 21:48
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `casanovousado`
--
CREATE DATABASE IF NOT EXISTS `casanovousado` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `casanovousado`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_nome` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_fantasia` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_nickname` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_email` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_cnpj` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_endereco` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_cidade` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_estado` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usuario_senha` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `usuario_codigo` (`usuario_codigo`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=64 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuario_codigo`, `usuario_nome`, `usuario_fantasia`, `usuario_nickname`, `usuario_email`, `usuario_cnpj`, `usuario_endereco`, `usuario_cidade`, `usuario_estado`, `usuario_senha`) VALUES
(60, 'FÁBRICA DE MOVEIS FLORENSE LTDA', 'Móveis FLORENSE', 'florense', 'contato@moveisflorense.ind.br', '17.854.951/0001-89', 'AV. 25 DE JULHO, 4090', 'Araquari', 'SC', 'teste'),
(61, 'Fábrica de Móveis Bogo LTDA', 'Móveis Bogo', 'bogo', 'contato@moveisbogo.com', '67.869.789/6879-68', 'R. Cel. Feddersen, 691 - Centro', 'Taió', 'SC', 'bogo');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
