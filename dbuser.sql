-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 30 avr. 2025 à 14:47
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

-- --------------------------------------------------------
-- Base de données : `dbuser`
-- --------------------------------------------------------

CREATE DATABASE IF NOT EXISTS `dbuser` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbuser`;

-- --------------------------------------------------------
-- Structure de la table `article`
-- --------------------------------------------------------

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  `quantite` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Déchargement des données de la table `article`
INSERT INTO `article` (`id`, `description`, `quantite`, `price`) VALUES
(1, 'Disque SSD 1To', 2016, 1290.9),
(3, 'Casque Bluetooth', 40, 5900.99),
(4, 'Clavier mécanique', 30, 890.99),
(5, 'Ordinateur portable', 58, 15000),
(6, 'Ordinateur portable HP', 45, 8000.4),
(8, 'Ordinateur portable II', 80, 8004),
(12, 'Ordinateur portable III', 10, 201000);

-- --------------------------------------------------------
-- Structure de la table `user`
-- --------------------------------------------------------

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Déchargement des données de la table `user`
INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'user1', 'pass1'),
(3, 'user2', 'pass2');

-- --------------------------------------------------------
-- Index pour les tables
-- --------------------------------------------------------

-- Index pour la table `article`
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

-- Index pour la table `user`
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

-- --------------------------------------------------------
-- AUTO_INCREMENT pour les tables
-- --------------------------------------------------------

-- AUTO_INCREMENT pour la table `article`
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

-- AUTO_INCREMENT pour la table `user`
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

COMMIT;
