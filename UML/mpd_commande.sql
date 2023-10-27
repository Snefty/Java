-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 27 oct. 2023 à 08:41
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mpd_commande`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `cocli` varchar(50) NOT NULL,
  `nomCli` varchar(50) DEFAULT NULL,
  `rueCli` varchar(50) DEFAULT NULL,
  `villecli` varchar(50) DEFAULT NULL,
  `nomAgence` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cocli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `nobC` int NOT NULL AUTO_INCREMENT,
  `dateC` date DEFAULT NULL,
  `cocli` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nobC`),
  KEY `cocli` (`cocli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `composer`
--

DROP TABLE IF EXISTS `composer`;
CREATE TABLE IF NOT EXISTS `composer` (
  `nobL` int NOT NULL,
  `refProduit` int NOT NULL,
  `qteLiv` int DEFAULT NULL,
  PRIMARY KEY (`nobL`,`refProduit`),
  KEY `refProduit` (`refProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `concerner`
--

DROP TABLE IF EXISTS `concerner`;
CREATE TABLE IF NOT EXISTS `concerner` (
  `nobC` int NOT NULL,
  `refProduit` int NOT NULL,
  `qteCom` int DEFAULT NULL,
  `pUnit` int DEFAULT NULL,
  PRIMARY KEY (`nobC`,`refProduit`),
  KEY `refProduit` (`refProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `noFac` int NOT NULL AUTO_INCREMENT,
  `dateFac` date DEFAULT NULL,
  PRIMARY KEY (`noFac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `nobL` int NOT NULL AUTO_INCREMENT,
  `dateL` date DEFAULT NULL,
  `noFac` int DEFAULT NULL,
  `nobC` int DEFAULT NULL,
  PRIMARY KEY (`nobL`),
  KEY `noFac` (`noFac`),
  KEY `nobC` (`nobC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `refProduit` int NOT NULL AUTO_INCREMENT,
  `desProd` varchar(99) DEFAULT NULL,
  `codeTva` int DEFAULT NULL,
  PRIMARY KEY (`refProduit`),
  KEY `codeTva` (`codeTva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

DROP TABLE IF EXISTS `tva`;
CREATE TABLE IF NOT EXISTS `tva` (
  `codeTva` int NOT NULL AUTO_INCREMENT,
  `tauxTva` double DEFAULT NULL,
  PRIMARY KEY (`codeTva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`cocli`) REFERENCES `client` (`cocli`);

--
-- Contraintes pour la table `composer`
--
ALTER TABLE `composer`
  ADD CONSTRAINT `composer_ibfk_1` FOREIGN KEY (`nobL`) REFERENCES `livraison` (`nobL`),
  ADD CONSTRAINT `composer_ibfk_2` FOREIGN KEY (`refProduit`) REFERENCES `produit` (`refProduit`);

--
-- Contraintes pour la table `concerner`
--
ALTER TABLE `concerner`
  ADD CONSTRAINT `concerner_ibfk_1` FOREIGN KEY (`nobC`) REFERENCES `commande` (`nobC`),
  ADD CONSTRAINT `concerner_ibfk_2` FOREIGN KEY (`refProduit`) REFERENCES `produit` (`refProduit`);

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `livraison_ibfk_1` FOREIGN KEY (`noFac`) REFERENCES `facture` (`noFac`),
  ADD CONSTRAINT `livraison_ibfk_2` FOREIGN KEY (`nobC`) REFERENCES `commande` (`nobC`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`codeTva`) REFERENCES `tva` (`codeTva`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
