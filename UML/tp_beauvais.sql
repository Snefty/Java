-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 26 oct. 2023 à 13:28
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
-- Base de données : `tp_beauvais`
--

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
CREATE TABLE IF NOT EXISTS `auteur` (
  `numAut` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numAut`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`numAut`, `nom`, `prenom`) VALUES
(1, 'Himes', 'Chester'),
(2, 'Bazin', 'Hervé'),
(3, 'Cohen', 'Albert'),
(4, 'Himes', 'Chester'),
(5, 'Bazin', 'Hervé'),
(6, 'Cohen', 'Albert'),
(7, 'Himes', 'Chester'),
(8, 'Bazin', 'Hervé'),
(9, 'Cohen', 'Albert');

-- --------------------------------------------------------

--
-- Structure de la table `ecrit`
--

DROP TABLE IF EXISTS `ecrit`;
CREATE TABLE IF NOT EXISTS `ecrit` (
  `numL` int DEFAULT NULL,
  `numAut` int DEFAULT NULL,
  KEY `numL` (`numL`),
  KEY `numAut` (`numAut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ecrit`
--

INSERT INTO `ecrit` (`numL`, `numAut`) VALUES
(1, 1),
(2, 3),
(3, 3),
(4, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `edite`
--

DROP TABLE IF EXISTS `edite`;
CREATE TABLE IF NOT EXISTS `edite` (
  `numL` int DEFAULT NULL,
  `numE` int DEFAULT NULL,
  KEY `numL` (`numL`),
  KEY `numE` (`numE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `edite`
--

INSERT INTO `edite` (`numL`, `numE`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `editeur`
--

DROP TABLE IF EXISTS `editeur`;
CREATE TABLE IF NOT EXISTS `editeur` (
  `numE` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `editeur`
--

INSERT INTO `editeur` (`numE`, `nom`, `ville`) VALUES
(1, 'Gallimard', 'Paris'),
(2, 'Seuil', 'Lille');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `numLivre` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) DEFAULT NULL,
  `nbrPage` int DEFAULT NULL,
  `annéeImpression` year DEFAULT NULL,
  PRIMARY KEY (`numLivre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`numLivre`, `titre`, `nbrPage`, `annéeImpression`) VALUES
(1, 'La reine des pommes', 282, 2003),
(2, 'Mangeclous', 498, 2004),
(3, 'Belle du seigneur', 1110, 2002),
(4, 'Couché dans le pain', 248, 2002),
(5, 'Le Matrimoine', 286, 1976);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ecrit`
--
ALTER TABLE `ecrit`
  ADD CONSTRAINT `ecrit_ibfk_1` FOREIGN KEY (`numL`) REFERENCES `livre` (`numLivre`),
  ADD CONSTRAINT `ecrit_ibfk_2` FOREIGN KEY (`numAut`) REFERENCES `auteur` (`numAut`);

--
-- Contraintes pour la table `edite`
--
ALTER TABLE `edite`
  ADD CONSTRAINT `edite_ibfk_1` FOREIGN KEY (`numL`) REFERENCES `livre` (`numLivre`),
  ADD CONSTRAINT `edite_ibfk_2` FOREIGN KEY (`numE`) REFERENCES `editeur` (`numE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
