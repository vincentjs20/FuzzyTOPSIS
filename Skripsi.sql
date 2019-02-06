-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2019 at 09:40 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skripsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `bobotkriteria`
--

CREATE TABLE `bobotkriteria` (
  `id_bobot` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `bobot` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bobotkriteria`
--

INSERT INTO `bobotkriteria` (`id_bobot`, `id_kriteria`, `bobot`) VALUES
(1, 1, 'normal'),
(2, 2, 'kurang penting'),
(3, 3, 'penting'),
(4, 4, 'normal'),
(5, 5, 'sangat penting'),
(6, 6, 'normal'),
(7, 7, 'kurang penting'),
(8, 8, 'penting'),
(9, 9, 'sangat tidak penting'),
(10, 10, 'normal');

-- --------------------------------------------------------

--
-- Table structure for table `kriteria`
--

CREATE TABLE `kriteria` (
  `id_kriteria` int(11) NOT NULL,
  `nama_kriteria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kriteria`
--

INSERT INTO `kriteria` (`id_kriteria`, `nama_kriteria`) VALUES
(1, 'Efisiensi pencarian'),
(2, 'Praktis saat membayar'),
(3, 'Kemudahan pemakaian aplikasi'),
(4, 'Keyakinan pelanggan'),
(5, 'Keamanan transaksi'),
(6, 'Kepercayaan pelanggan'),
(7, 'Layanan customer service'),
(8, 'User experience'),
(9, 'Kelengkapan produk'),
(10, 'Promo yang ditawarkan');

-- --------------------------------------------------------

--
-- Table structure for table `nilaikriteria`
--

CREATE TABLE `nilaikriteria` (
  `id_nilai_kriteria` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `id_toko` int(11) NOT NULL,
  `nilai` varchar(50) NOT NULL,
  `id_pengguna` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nilaikriteria`
--

INSERT INTO `nilaikriteria` (`id_nilai_kriteria`, `id_kriteria`, `id_toko`, `nilai`, `id_pengguna`) VALUES
(1, 1, 1, 'baik', 1),
(2, 2, 1, 'baik', 1),
(3, 3, 1, 'sangat baik', 1),
(4, 4, 1, 'normal', 1),
(5, 5, 1, 'buruk', 1),
(6, 6, 1, 'baik', 1),
(7, 7, 1, 'sangat buruk', 1),
(8, 8, 1, 'baik', 1),
(9, 9, 1, 'normal', 1),
(10, 10, 1, 'sangat baik', 1),
(11, 1, 2, 'normal', 1),
(12, 2, 2, 'baik', 1),
(13, 3, 2, 'normal', 1),
(14, 4, 2, 'normal', 1),
(15, 5, 2, 'sangat baik', 1),
(16, 6, 2, 'buruk', 1),
(17, 7, 2, 'normal', 1),
(18, 8, 2, 'normal', 1),
(19, 9, 2, 'baik', 1),
(20, 10, 2, 'baik', 1),
(21, 1, 3, 'normal', 1),
(22, 2, 3, 'buruk', 1),
(23, 3, 3, 'buruk', 1),
(24, 4, 3, 'sangat baik', 1),
(25, 5, 3, 'sangat baik', 1),
(26, 6, 3, 'baik', 1),
(27, 7, 3, 'buruk', 1),
(28, 8, 3, 'buruk', 1),
(29, 9, 3, 'buruk', 1),
(30, 10, 3, 'normal', 1),
(31, 1, 4, 'buruk', 1),
(32, 2, 4, 'normal', 1),
(33, 3, 4, 'sangat baik', 1),
(34, 4, 4, 'sangat buruk', 1),
(35, 5, 4, 'sangat baik', 1),
(36, 6, 4, 'normal', 1),
(37, 7, 4, 'baik', 1),
(38, 8, 4, 'baik', 1),
(39, 9, 4, 'sangat baik', 1),
(40, 10, 4, 'buruk', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama`) VALUES
(1, 'original');

-- --------------------------------------------------------

--
-- Table structure for table `toko_online`
--

CREATE TABLE `toko_online` (
  `id_toko` int(11) NOT NULL,
  `nama_toko` varchar(50) NOT NULL,
  `rank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `toko_online`
--

INSERT INTO `toko_online` (`id_toko`, `nama_toko`, `rank`) VALUES
(1, 'Tokopedia', 1),
(2, 'Bukalapak', 2),
(3, 'Shopee', 3),
(4, 'Lazada', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bobotkriteria`
--
ALTER TABLE `bobotkriteria`
  ADD PRIMARY KEY (`id_bobot`),
  ADD KEY `id_kriteria` (`id_kriteria`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`id_kriteria`);

--
-- Indexes for table `nilaikriteria`
--
ALTER TABLE `nilaikriteria`
  ADD PRIMARY KEY (`id_nilai_kriteria`),
  ADD KEY `id_kriteria` (`id_kriteria`),
  ADD KEY `id_toko` (`id_toko`),
  ADD KEY `id_pengguna` (`id_pengguna`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `toko_online`
--
ALTER TABLE `toko_online`
  ADD PRIMARY KEY (`id_toko`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bobotkriteria`
--
ALTER TABLE `bobotkriteria`
  MODIFY `id_bobot` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `kriteria`
--
ALTER TABLE `kriteria`
  MODIFY `id_kriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `nilaikriteria`
--
ALTER TABLE `nilaikriteria`
  MODIFY `id_nilai_kriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `toko_online`
--
ALTER TABLE `toko_online`
  MODIFY `id_toko` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bobotkriteria`
--
ALTER TABLE `bobotkriteria`
  ADD CONSTRAINT `bobotkriteria_ibfk_1` FOREIGN KEY (`id_kriteria`) REFERENCES `kriteria` (`id_kriteria`);

--
-- Constraints for table `nilaikriteria`
--
ALTER TABLE `nilaikriteria`
  ADD CONSTRAINT `NilaiKriteria_ibfk_1` FOREIGN KEY (`id_kriteria`) REFERENCES `kriteria` (`id_kriteria`),
  ADD CONSTRAINT `NilaiKriteria_ibfk_2` FOREIGN KEY (`id_toko`) REFERENCES `toko_online` (`id_toko`),
  ADD CONSTRAINT `NilaiKriteria_ibfk_3` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
