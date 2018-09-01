-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:8889
-- Généré le :  Mer 30 Mai 2018 à 19:27
-- Version du serveur :  5.6.28
-- Version de PHP :  7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `seatingplan`
--
CREATE DATABASE IF NOT EXISTS `seatingplan` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `seatingplan`;

-- --------------------------------------------------------

--
-- Structure de la table `plan`
--

DROP TABLE IF EXISTS `plan`;
CREATE TABLE IF NOT EXISTS `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `image` varchar(255) NOT NULL,
  `image_longueur` int(11) NOT NULL,
  `image_largeur` int(11) NOT NULL,
  `echelle_pixel` int(11) NOT NULL,
  `echelle_cm` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom_UNIQUE` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `plan`
--

INSERT INTO `plan` (`id`, `nom`, `image`, `image_longueur`, `image_largeur`, `echelle_pixel`, `echelle_cm`) VALUES
(1, 'Plan', 'plan.png', 819, 460, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `emplacement`
--

DROP TABLE IF EXISTS `emplacement`;
CREATE TABLE IF NOT EXISTS `emplacement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pos_x` int(11) NOT NULL,
  `pos_y` int(11) NOT NULL,
  `orientation` enum('horizontal','vertical') NOT NULL,
  `id_entite` int(11) NOT NULL,
  `id_plan` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_emplacement_entite1_idx` (`id_entite`),
  KEY `fk_emplacement_plan1_idx` (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `emplacement`
--

INSERT INTO `emplacement` (`id`, `pos_x`, `pos_y`, `orientation`, `id_entite`, `id_plan`) VALUES
(1, 257, 110, 'horizontal', 1, 1),
(2, 417, 148, 'horizontal', 1, 1),
(3, 656, 121, 'horizontal', 1, 1),
(4, 530, 150, 'vertical', 1, 1),
(5, 574, 306, 'vertical', 1, 1),
(6, 110, 257, 'horizontal', 1, 2),
(7, 148, 417, 'horizontal', 1, 2),
(8, 121, 656, 'horizontal', 1, 2),
(9, 150, 530, 'vertical', 1, 2),
(10, 306, 574, 'vertical', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `entite`
--

DROP TABLE IF EXISTS `entite`;
CREATE TABLE IF NOT EXISTS `entite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `largeur` double NOT NULL COMMENT 'En centimètres',
  `longueur` double NOT NULL COMMENT 'En centimètres',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom_UNIQUE` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `entite`
--

INSERT INTO `entite` (`id`, `nom`, `largeur`, `longueur`) VALUES
(1, 'Bureau', 110, 80);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` int(10) DEFAULT NULL,
  `date_arrivee` date DEFAULT NULL,
  `date_sortie` date DEFAULT NULL,
  `poste_interne` int(10) DEFAULT NULL,
  `id_emplacement` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personne_emplacement1_idx` (`id_emplacement`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `email`, `telephone`, `date_arrivee`, `date_sortie`, `poste_interne`, `id_emplacement`) VALUES
(1, 'Doe', 'John', 'doe.john@hotmail.fr', 125632566, '2010-03-01', '2020-10-25', 10, 1),
(2, 'Doe', 'Jane', 'doe.jane@hotmail.fr', 123542145, '2015-03-22', '2019-06-23', 13, 3),
(5, 'Dupont', 'Jared', 'dupond.jared@@hotmail.fr', 125632148, '2015-05-10', '2019-09-20', 16, 9),
(6, 'Dupond', 'Joe', 'dupond.joe@@hotmail.fr', 186352135, '2018-05-27', '2019-05-20', 14, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(100) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `identifiant`, `mdp`) VALUES
(1, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `emplacement`
--
ALTER TABLE `emplacement`
  ADD CONSTRAINT `fk_emplacement_entite1` FOREIGN KEY (`id_entite`) REFERENCES `entite` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_emplacement_plan1` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `fk_personne_emplacement1` FOREIGN KEY (`id_emplacement`) REFERENCES `emplacement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
