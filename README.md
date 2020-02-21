##  Galamsey Monitoring

This application was built to help keep records of galamsey activities and observatories.


## Quick Start

##### Build the framework

Please have the database connector driver for java installed.

Please Have the JavaFX library installed.

Please run the galamsey.sql in your local sql server.


```bash
-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2020 at 04:01 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `galamsey`
--

-- --------------------------------------------------------

--
-- Table structure for table `galamsey_tbl`
--


CREATE DATABASE galamsey;

CREATE TABLE `galamsey_tbl` (
  `Vegcolor` varchar(20) DEFAULT NULL,
  `colorVal` enum('1','2','3') DEFAULT NULL,
  `position` varchar(200) NOT NULL,
  `yearOfEvent` varchar(4) DEFAULT NULL,
  `ObsName` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `galamsey_tbl`
--

INSERT INTO `galamsey_tbl` (`Vegcolor`, `colorVal`, `position`, `yearOfEvent`, `ObsName`) VALUES
('Green', '1', '(123, 123)', '2020', 'Tema'),
('Yellow', '2', '(13, 3113)', '2019', 'Tema'),
('Green', '1', '(131, 1313)', '2019', 'Tema'),
('Green', '1', '(213, 12312)', '2020', 'Tema'),
('Green', '1', '(23, 424)', '2020', 'Tema'),
('Brown', '3', '(231, 13231)', '2019', 'Tema'),
('Yellow', '2', '(232.23, 232.23)', '2020', 'Tema'),
('green', '1', '(234567.45678, 12345.34567)', '2020', 'Tema');

-- --------------------------------------------------------

--
-- Table structure for table `observatory`
--

CREATE TABLE `observatory` (
  `name` varchar(20) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `area` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `observatory`
--

INSERT INTO `observatory` (`name`, `country`, `year`, `area`) VALUES
('Tema', 'Ghana', 2019, 2131.2),
('isjofi', 'Ghana', 2019, 152.3),
('sfsfsd', 'Ghana', 2016, 22.3),
('uadhao', 'Ghana', 2019, 2112.35);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `galamsey_tbl`
--
ALTER TABLE `galamsey_tbl`
  ADD PRIMARY KEY (`position`),
  ADD KEY `ObsName` (`ObsName`);

--
-- Indexes for table `observatory`
--
ALTER TABLE `observatory`
  ADD PRIMARY KEY (`name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `galamsey_tbl`
--
ALTER TABLE `galamsey_tbl`
  ADD CONSTRAINT `galamsey_tbl_ibfk_1` FOREIGN KEY (`ObsName`) REFERENCES `observatory` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```


##### Run the sample application
To run the sample application create a configuration of Home controller for GUI version.
to run sample application of console application create configuration for MonitoringIO.


## Authors

- Kweku-Abeiku Attah Anyen  ::  kwekuanyen@gmail.com
- Gloria Agbenyo
- Collins Ofosu-Appiah


## License

Apache License, Version 2.0 (current)
http://www.apache.org/licenses/LICENSE-2.0
