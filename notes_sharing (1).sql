-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2017 at 09:18 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notes_sharing`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_id` int(11) NOT NULL,
  `Email_id` varchar(30) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_id`, `Email_id`, `Username`, `Password`) VALUES
(1, 'karam@gmail.com', 'karam', 12345);

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `Notes_id` int(11) NOT NULL,
  `Subject` varchar(50) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `posted_by` varchar(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`Notes_id`, `Subject`, `Title`, `Description`, `posted_by`, `Date`) VALUES
(1, 'Maths', 'matrix notes', 'matix vale notes mere kolo lealo', 'karam', '2017-04-30'),
(2, 'English', 'vocabulary notes', 'english vale notes v mere kolo lelo', 'karam', '2017-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `User_id` int(11) NOT NULL,
  `Email_id` varchar(30) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Mobile_no` bigint(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_id`, `Email_id`, `Username`, `Mobile_no`, `Password`) VALUES
(1, 'charan@gmail.com', 'charan', 7837313134, '1234567'),
(2, 'char@gmail.com', 'charan', 7837313134, '1234567'),
(3, 'karam@gmail.com', 'charan', 7837313134, '12345678'),
(4, 'demoo@', 'deno', 1354569780, '1234'),
(5, 'demo@gmail.com', 'dem', 7837313134, '12345678'),
(6, 'krm@gmail.com', 'krn', 9870465312, '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_id`),
  ADD UNIQUE KEY `Email_id` (`Email_id`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`Notes_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `Notes_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
