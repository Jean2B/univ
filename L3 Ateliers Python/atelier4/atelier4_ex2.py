# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 15/09/2021
Version : 1
Description : Exercice 2 de l'atelier 4
"""

import re

def mots_nlettres(lst_mot: [str], n: int)-> [str]:
    """
    Retourne la liste des mots contenant exactement n lettres

    inputs:
        lst_mot: [str] : Liste de mots
        n: int : Nombre de lettres des mots à retourner

    outputs:
        [str]: Mots contenant exactement n lettres
    """
    lst_mots_n = []
    for mot in lst_mot:
        if len(mot) == n:
            lst_mots_n.append(mot)
    return lst_mots_n

def commence_par(mot: str, prefixe: str)-> bool:
    """
    Vérifie si un mot commence par un préfixe

    inputs:
        mot: str : Mot à vérifier
        prefixe: str : Préfixe du mot

    outputs:
        bool: True si le mot commence par le préfixe
              False sinon
    """
    expression = r"^{}".format(prefixe)
    return not re.search(expression, mot) is None

def finit_par(mot: str, suffixe: str)-> bool:
    """
    Vérifie si un mot finit par un suffixe

    inputs:
        mot: str : Mot à vérifier
        suffixe: str : Suffixe du mot

    outputs:
        bool: True si le mot finit par le suffixe
              False sinon
    """
    expression = r"{}$".format(suffixe)
    return not re.search(expression, mot) is None


def finissent_par(lst_mot: [str], suffixe: str)-> [str]:
    """
    Retourne les mots finissant par un suffixe

    inputs:
        lst_mot: [str] : Mots à vérifier
        suffixe: str : Suffixe du mot

    outputs:
        [str]: Liste des mots finissant par le suffixe
    """
    lst_mots_suffixe = []
    for mot in lst_mot:
        if finit_par(mot, suffixe):
            lst_mots_suffixe.append(mot)
    return lst_mots_suffixe

def commencent_par(lst_mot: [str], prefixe: str)-> [str]:
    """
    Retourne les mots commençant par un prefixe

    inputs:
        lst_mot: [str] : Mots à vérifier
        prefixe: str : Préfixe du mot

    outputs:
        [str]: Liste des mots commençant par le préfixe
    """
    lst_mots_prefixe = []
    for mot in lst_mot:
        if commence_par(mot, prefixe):
            lst_mots_prefixe.append(mot)
    return lst_mots_prefixe

def liste_mots(lst_mot: [str], prefixe: str, suffixe: str, n: int)-> [str]:
    """
    Retourne les mots qui commencent par un préfixe, qui se terminent par un
    suffixe, et qui contiennent exactement n lettres

    inputs:
        lst_mot: [str] : Mots à vérifier
        prefixe: str : Préfixe du mot
        suffixe: str : Suffixe du mot
        n: int : Nombre de lettres du mot

    outputs:
        [str] : Liste des mots commençant par le préfixe, finissant par le
                suffixe et contiennent n lettres
    """
    lst_res = lst_mot
    lst_res = commencent_par(lst_res, prefixe)
    lst_res = finissent_par(lst_res, suffixe)
    lst_res = mots_nlettres(lst_res, n)
    return lst_res

def dictionnaire(fichier: str)-> [str]:
    """
    Retourne la liste des mots présents dans un fichier texte

    inputs:
        fichier: str : Nom du fichier

    outputs:
        [str]: Liste des mots présents dans le fichier
    """
    fichier = open(fichier, "r", encoding="utf-8") #Ouverture du fichier
    lst_mot = fichier.read().split('\n')
    return lst_mot
