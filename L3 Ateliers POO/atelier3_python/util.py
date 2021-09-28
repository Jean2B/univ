# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 28/09/2021
Version : 1
Description : Atelier 3 POO
"""

class FormeGeometrique:
    nb_formes = 0
    
    def __init__(self, nom: str):
        """
        Constructeur de forme géométrique
        
        inputs:
            nom: str : Nom de la forme
        """
        FormeGeometrique.nb_formes += 1
        id_forme = "{}_{}".format(nom, FormeGeometrique.nb_formes)
