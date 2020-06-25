-- phpMyAdmin SQL Dump
-- version 2.11.9.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 25, 2020 at 02:13 PM
-- Server version: 5.0.67
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pembelian`
--

-- --------------------------------------------------------

--
-- Table structure for table `databarang`
--

CREATE TABLE IF NOT EXISTS `databarang` (
  `nobarang` varchar(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(20) NOT NULL,
  `qty` int(20) NOT NULL,
  `total` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `databarang`
--

INSERT INTO `databarang` (`nobarang`, `nama`, `harga`, `qty`, `total`) VALUES
('BRG03', 'Kemeja Channel', 1500000, 5, 7500000),
('BRG02', 'Celana', 350000, 6, 2100000),
('BRG01', 'Baju', 120000, 4, 960000);
