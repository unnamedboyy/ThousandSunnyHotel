-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2024 at 02:50 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `D_7_Hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id_booking` varchar(5) NOT NULL,
  `id_customer` varchar(5) NOT NULL,
  `checkInDate` date NOT NULL,
  `checkOutDate` date NOT NULL,
  `id_kamar` varchar(5) NOT NULL,
  `metode_pembayaran` varchar(255) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id_booking`, `id_customer`, `checkInDate`, `checkOutDate`, `id_kamar`, `metode_pembayaran`, `total_harga`) VALUES
('B1', 'C1', '2024-06-18', '2024-06-18', 'K1', 'Mandiri', 100000),
('B2', 'C2', '2024-06-18', '2024-06-18', 'K2', 'BRI', 300000),
('B3', 'C3', '2024-06-20', '2024-06-21', 'K3', 'Tunai', 500000),
('B4', 'C5', '2024-12-03', '2024-12-05', 'K5', 'Mandiri', 300000),
('B5', 'C6', '2024-12-01', '2024-12-02', 'K5', 'Mandiri', 150000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_customer` varchar(5) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_telp` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_customer`, `nama`, `email`, `no_telp`, `jenis_kelamin`) VALUES
('C1', 'Eulogius Kurdeo', 'eulogius@gmail.com', '08551110000', 'Laki-laki'),
('C2', 'Lana Marcel', 'lanaMarcel@gmail.com', '+6285726510', 'Laki-laki'),
('C3', 'Angelina Derrel', 'derrel@gmail.com', '08116254209', 'Perempuan'),
('C4', 'Russel', 'russel@gmail.com', '0852190452', 'Laki-laki'),
('C5', 'Gabriela Puspita', 'puspita@gmail.com', '08557265290', 'Perempuan'),
('C6', 'Kaisar Simatupang', 'kaisar@gmail.com', '08521289425', 'Laki-laki');

-- --------------------------------------------------------

--
-- Table structure for table `kamar`
--

CREATE TABLE `kamar` (
  `id_kamar` varchar(5) NOT NULL,
  `tipe` varchar(255) NOT NULL,
  `fasilitas` varchar(255) NOT NULL,
  `harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kamar`
--

INSERT INTO `kamar` (`id_kamar`, `tipe`, `fasilitas`, `harga`) VALUES
('K1', 'Single', 'AC dan Heater', 100000),
('K2', 'Double', 'Fasilitas Lengkap', 300000),
('K3', 'Suite', 'Fasilitas Lengkap', 500000),
('K4', 'Double', 'Televisi dan Heater', 400000),
('K5', 'Single', 'AC dan Heater', 150000);

-- --------------------------------------------------------

--
-- Table structure for table `penyediajasa`
--

CREATE TABLE `penyediajasa` (
  `id_layanan` varchar(5) NOT NULL,
  `id_booking` varchar(5) NOT NULL,
  `id_petugas` varchar(5) NOT NULL,
  `jenis_jasa` varchar(255) NOT NULL,
  `total_harga_jasa` float NOT NULL,
  `tanggal_layanan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penyediajasa`
--

INSERT INTO `penyediajasa` (`id_layanan`, `id_booking`, `id_petugas`, `jenis_jasa`, `total_harga_jasa`, `tanggal_layanan`) VALUES
('J4', 'B6', 'P5', 'Semua Jasa', 75000, '2024-06-25'),
('J5', 'B6', 'P2', 'Pijat', 50000, '2024-06-24'),
('J6', 'B1', 'P5', 'Semua Jasa', 75000, '2024-06-18'),
('J7', 'B2', 'P2', 'Pijat', 50000, '2024-06-18'),
('J8', 'B3', 'P4', 'Morning call', 10000, '2024-06-21'),
('J9', 'B3', 'P1', 'Pijat dan Morning call', 60000, '2024-06-20'),
('J10', 'B5', 'P2', 'Morning call dan Antar barang', 25000, '2024-12-02');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` varchar(5) NOT NULL,
  `nama_petugas` varchar(255) NOT NULL,
  `no_telp` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `tahun_bekerja` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `no_telp`, `jenis_kelamin`, `tahun_bekerja`) VALUES
('P1', 'Fiko', '08552726512', 'Laki-laki', 15),
('P2', 'Olive', '+62524472981', 'Perempuan', 7),
('P3', 'Ardha', '08557266219', 'Laki-laki', 9),
('P4', 'Jonny', '08556252519', 'Laki-laki', 25),
('P5', 'Anggie', '0855242419', 'Perempuan', 19);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
