-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 03, 2019 at 11:28 AM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QpLNBmWat5`
--

-- --------------------------------------------------------

--
-- Table structure for table `kirjat`
--

CREATE TABLE `kirjat` (
  `ID` int(11) NOT NULL,
  `teoksenNimi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tekijanNimi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `julkaisuVuosi` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `kirjat`
--

INSERT INTO `kirjat` (`ID`, `teoksenNimi`, `tekijanNimi`, `julkaisuVuosi`) VALUES
(2, 'esittelykirja', 'Lari Vesterinen', 2019),
(3, 'LOTR', 'Meikä', 1200),
(5, 'jeppis', 'harri paloauto', 2000),
(15, 'joku', 'petteri', 1800);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kirjat`
--
ALTER TABLE `kirjat`
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `teoksenNimi` (`teoksenNimi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
