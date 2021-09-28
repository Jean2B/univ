# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 28/09/2021
Version : 1
Description : Atelier 3 POO - Formes 2D
"""

from util import FormeGeometrique

class Forme2D(FormeGeometrique):
    def __init__(self, nom: str):
        """
        Constructeur de formes 2D

        inputs:
            nom: str : Nom de la forme
        """
        super().__init__(nom)

class Ellipse(Forme2D):
    def __init__(self, rayon1: float, rayon2: float):
        """
        Constructeur d'ellipse

        inputs:
            rayon1: float : Rayon 1 de l'ellipse
            rayon2: float : Rayon 2 de l'ellipse
        """
        super().__init__("ellipse")
        self.rayon1 = rayon1
        self.rayon2 = rayon2

class Cercle(Forme2D):
    def __init__(self, rayon: float):
        """
        Constructeur de cercle

        inputs:
            rayon: float : Rayon du cercle
        """
        super().__init__("cercle")
        self.rayon = rayon

class Rectangle(Forme2D):
    def __init__(self, longueur: float, largeur: float):
        """
        Constructeur de rectangle

        inputs:
            longueur: float : Longueur du rectangle
            largeur: float : Largeur du rectangle
        """
        super().__init__("rectangle")
        self.longueur = longueur
        self.largeur = largeur
