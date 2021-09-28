# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 28/09/2021
Version : 1
Description : Atelier 3 POO - Formes 3D
"""

from util import FormeGeometrique

class Forme3D(FormeGeometrique):
    def __init__(self, nom: str):
        """
        Constructeur de formes 3D

        inputs:
            nom: str : Nom de la forme
        """
        super().__init__(nom)

class Sphere(Forme3D):
    def __init__(self, rayon: float):
        """
        Constructeur de sphère

        inputs:
            rayon: float : Rayon de la sphère
        """
        super().__init__("sphere")
        self.rayon = rayon

class Cylindre(Forme3D):
    def __init__(self, rayon: float, hauteur: float):
        """
        Constructeur de cylindre

        inputs:
            rayon: float : Rayon du cylindre
            hauteur: float : Hauteur du cylindre
        """
        super().__init__("cylindre")
        self.rayon = rayon
        self.hauteur = hauteur
