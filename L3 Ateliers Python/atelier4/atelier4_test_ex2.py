# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 15/09/2021
Version : 1
Description : Test de l'exercice 2 de l'atelier 4
"""

from atelier4_ex2 import (liste_mots, dictionnaire)

def test_exercice2()-> bool:
    """
    Test des fonctions de l'exercice 2

    outputs:
        bool: True si le test est réussi
              False en cas d'échec
    """
    print("TEST Exercice 2\n")
    lst_mot_test = [[], ["bonjour"],
                    ["jouer", "bonjour", "punir", "jour", "aurevoir",
                     "revoir", "pouvoir", "cour", "abajour", "finir", "aimer"],
                    dictionnaire("littre.txt")] #Listes de mots pour le test
    #Tuples de paramètres à tester
    lst_param_test = [(lst_mot_test[0], "", "", 0), (lst_mot_test[1], "", "", 0),
                      (lst_mot_test[1], "", "", 7), (lst_mot_test[2], "a", "r", 15),
                      (lst_mot_test[2], "a", "r", 7), (lst_mot_test[2], "au", "re", 8),
                      (lst_mot_test[2], "re", "voir", 8), (lst_mot_test[2], "", "ir", 5),
                      (lst_mot_test[3], "in", "ment", 23)]
    #Retours attendus
    lst_mot_attendu = [[], [], ["bonjour"], [], ["abajour"], [], [],
                       ["punir", "finir"], ['inconstitutionnellement']]
    succes = True #Résultat global du test
    nb_tests = len(lst_param_test) #Nombre de tests
    for i in range(nb_tests):
        mots_test, pre_test, suf_test, n_test = lst_param_test[i]
        mots_attendus = lst_mot_attendu[i]
        mots_obtenus = liste_mots(mots_test, pre_test, suf_test, n_test)
        if mots_test == []:
            print("Test avec une liste vide")
        else:
            print("Test avec la liste commençant par", mots_test[0])
        print("Préfixe, suffixe, nb lettres :",
                  pre_test, ",", suf_test, ",", n_test)
        print("Attendu :", mots_attendus)
        print("Obtenu :", mots_obtenus)
        if mots_attendus == mots_obtenus:
            print("SUCCES\n")
        else:
            print("ECHEC\n")
            succes = False
    if succes:
        print("Test réussi")
    else:
        print("Test échoué")
    return succes

test_exercice2()
