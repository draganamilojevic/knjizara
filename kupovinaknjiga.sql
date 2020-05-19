-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: May 19, 2020 at 10:22 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kupovinaknjiga`
--

-- --------------------------------------------------------

--
-- Table structure for table `knjiga`
--

CREATE TABLE `knjiga` (
  `knjigaID` int(11) NOT NULL,
  `nazivKnjige` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `autor` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cena` double NOT NULL,
  `stanjeNaZalihama` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `knjiga`
--

INSERT INTO `knjiga` (`knjigaID`, `nazivKnjige`, `autor`, `cena`, `stanjeNaZalihama`) VALUES
(1, 'Ana Karenjina', 'Lav Tolstoj', 900, 95),
(2, 'Rat i mir', 'Lav Tolstoj', 1000, 77),
(3, 'Na Drini ?uprija', 'Ivo Andri?', 850, 89),
(4, 'Derviš i smrt', 'Meša Selimovic', 600, 118),
(5, 'Necista krv', 'Borisav Stankovic', 550, 67),
(6, 'Seobe', 'Milos Crnjaski', 420, 126),
(7, 'Zona Zamfirova', 'Stevan Sremac', 470, 66),
(8, 'Tvrdica', 'Jovan Sterija Popovic', 450, 70),
(9, 'Pokondirena tikva', 'Jovan Sterija Popovic', 500, 97);

-- --------------------------------------------------------

--
-- Table structure for table `kupac`
--

CREATE TABLE `kupac` (
  `kupacID` int(11) NOT NULL,
  `imePrezime` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `maticniBroj` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ziroRacun` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postanskiBroj` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kupac`
--

INSERT INTO `kupac` (`kupacID`, `imePrezime`, `email`, `maticniBroj`, `ziroRacun`, `adresa`, `postanskiBroj`) VALUES
(1, 'Aleksandra Milic', 'aleksandra@gmail.com', '1209993720220', '13-345667889-11', 'Beogradska 17', 21000),
(2, 'Stefan Djokic', 'stefan@gmail.com', '2105996720220', '4567678982-877', 'Vidikovacki venac 45', 11000),
(3, 'Katarina Jovicic', 'katarina@gmail.com', '1511996720220', '15-787988906-11', 'Kralja Petra 70', 11000),
(4, 'Jovana Ivkovic', 'jovana@gmail.com', '334356787890', '6678900-8877-66', 'Kataniceva 18', 11000),
(5, 'Sofija Matovicqqqqqqqqqq', 'sofija@gmail.com', '2704995220772', '23-87487898-56', 'Ulica lipa 13', 11000);

-- --------------------------------------------------------

--
-- Table structure for table `kupovina`
--

CREATE TABLE `kupovina` (
  `kupovinaID` int(11) NOT NULL,
  `datum` date NOT NULL,
  `napomena` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ukupno` double NOT NULL,
  `kupacID` int(11) NOT NULL,
  `obradjena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kupovina`
--

INSERT INTO `kupovina` (`kupovinaID`, `datum`, `napomena`, `ukupno`, `kupacID`, `obradjena`) VALUES
(1, '2019-09-22', 'zelim dostavu', 1450, 1, 1),
(2, '2019-10-23', 'ne zelim dostavu', 1420, 2, 1),
(5, '2019-10-13', 'pozovite dan ranije', 970, 5, 0),
(6, '2019-09-12', 'nista', 920, 5, 0),
(7, '2019-09-25', 'nista1', 2450, 5, 0),
(8, '2019-08-23', 'placanje pouzecem', 1500, 3, 0),
(9, '2019-12-12', 'kupujem kao poklon', 1500, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `mesto`
--

CREATE TABLE `mesto` (
  `postanskiBroj` int(11) NOT NULL,
  `naziv` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `mesto`
--

INSERT INTO `mesto` (`postanskiBroj`, `naziv`) VALUES
(11000, 'Beograd'),
(21000, 'Novi Sad'),
(32000, 'Čačak');

-- --------------------------------------------------------

--
-- Table structure for table `stavkakupovine`
--

CREATE TABLE `stavkakupovine` (
  `stavkaKupovineID` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `vrednostStavke` double NOT NULL,
  `kupovinaID` int(11) NOT NULL,
  `knjigaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `stavkakupovine`
--

INSERT INTO `stavkakupovine` (`stavkaKupovineID`, `kolicina`, `vrednostStavke`, `kupovinaID`, `knjigaID`) VALUES
(1, 1, 420, 5, 6),
(2, 1, 550, 5, 5),
(3, 1, 1000, 7, 2),
(4, 1, 420, 6, 6),
(5, 1, 500, 6, 9),
(6, 2, 900, 7, 1),
(7, 1, 550, 7, 5),
(8, 1, 600, 8, 4),
(9, 1, 900, 8, 1),
(10, 1, 500, 9, 9),
(11, 1, 1000, 9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleniID` int(11) NOT NULL,
  `ime` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `korisnickoIme` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lozinka` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefon` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`zaposleniID`, `ime`, `prezime`, `korisnickoIme`, `lozinka`, `telefon`) VALUES
(1, 'Dragana', 'Milojević', 'dragana', 'dragana', '0692345677'),
(2, 'Milena', 'Stojanović', 'milena', 'milena', '0634556788');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `knjiga`
--
ALTER TABLE `knjiga`
  ADD PRIMARY KEY (`knjigaID`);

--
-- Indexes for table `kupac`
--
ALTER TABLE `kupac`
  ADD PRIMARY KEY (`kupacID`),
  ADD KEY `postanskiBroj` (`postanskiBroj`);

--
-- Indexes for table `kupovina`
--
ALTER TABLE `kupovina`
  ADD PRIMARY KEY (`kupovinaID`),
  ADD KEY `kupovinafk1` (`kupacID`);

--
-- Indexes for table `mesto`
--
ALTER TABLE `mesto`
  ADD PRIMARY KEY (`postanskiBroj`);

--
-- Indexes for table `stavkakupovine`
--
ALTER TABLE `stavkakupovine`
  ADD PRIMARY KEY (`stavkaKupovineID`,`kupovinaID`),
  ADD KEY `kupovinaID` (`kupovinaID`),
  ADD KEY `stavkakupovine_ibfk_4` (`knjigaID`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleniID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mesto`
--
ALTER TABLE `mesto`
  MODIFY `postanskiBroj` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32001;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleniID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kupac`
--
ALTER TABLE `kupac`
  ADD CONSTRAINT `kupac_ibfk_1` FOREIGN KEY (`postanskiBroj`) REFERENCES `mesto` (`postanskiBroj`);

--
-- Constraints for table `kupovina`
--
ALTER TABLE `kupovina`
  ADD CONSTRAINT `kupovinafk1` FOREIGN KEY (`kupacID`) REFERENCES `kupac` (`kupacID`);

--
-- Constraints for table `stavkakupovine`
--
ALTER TABLE `stavkakupovine`
  ADD CONSTRAINT `stavkakupovine_ibfk_3` FOREIGN KEY (`kupovinaID`) REFERENCES `kupovina` (`kupovinaID`),
  ADD CONSTRAINT `stavkakupovine_ibfk_4` FOREIGN KEY (`knjigaID`) REFERENCES `knjiga` (`knjigaID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
