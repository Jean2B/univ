# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 16/09/2021
Version : 1
Description : Test de l'exercice 3 de l'atelier 4
"""

from atelier4_ex3 import places_lettre, output_str

def test_places_lettre():
    """
    Test de la fonction places_lettre
    """
    lettre = input("Entrez une lettre : ")
    mot = input("Entrez un mot : ")
    indices = places_lettre(lettre, mot)
    print("'{}' se trouve à {} dans le mot '{}'".format(lettre, indices, mot))

def test_output_str():
    """
    Test de la fonction output_str
    """
    mot = "bonjour"
    print(output_str(mot, []))
    print(output_str(mot, [0]))
    print(output_str(mot, [6]))
    print(output_str(mot, [0, 3, 6]))
    print(output_str(mot, [0, 5, 2, 4, 6, 3, 1]))
    print(output_str(mot, [-1, 1, 2, 4, 5, 6, 8]))

test_output_str()
