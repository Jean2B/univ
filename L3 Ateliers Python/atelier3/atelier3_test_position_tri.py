# -*- coding: utf-8 -*-
"""
Auteur : Félicien BERTRAND, Jean BERTRAND
Date : 13/09/2021
Version : 1
Description : Test de la fonction position_tri
"""

from atelier3 import position_tri

def test_position_tri():
    """Test de la fonction position_tri"""
    print("TEST POSITION TRI")
    #Test liste vide
    print("Test liste vide")
    test = position_tri([], 0)
    if test == -1: #Résultat attendu : -1
        print("SUCCES : ", end='')
    else:
        print("ECHEC : ", end='')
    print("Attendu : -1 / Obtenu :", test)
    #Tests valeurs introuvable, au début, au milieu, à la fin
    lst = [-2, -1, 0, 3, 4, 6, 8]
    lst = sorted(lst) #Liste supposée triée
    e = [5, -2, 3, 8] #Liste des valeurs e
    resultats = [-1, 0, 3, 6] #Résultats attendus
    tests = ["introuvable", "au début", "au milieu", "à la fin"]
    for i in range(len(e)): #Boucle de tests
        print("Test valeur", tests[i])
        test = position_tri(lst, e[i])
        if test == resultats[i]:
            print("SUCCES : ", end='')
        else:
            print("ECHEC : ", end='')
        print("Attendu :", resultats[i], "/ Obtenu :", test)

test_position_tri()
