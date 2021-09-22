# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 16/09/2021
Version : 1
Description : Exercice 3 de l'atelier 4
"""

import random as rd

def places_lettre(ch: str, mot: str)-> [int]:
    """
    Retourne les positions d'une lettre dans un mot

    inputs:
        ch: str : Lettre
        mot: str : Mot

    outputs:
        [int]: Positions de la lettre dans le mot (vide si lettre absente)
    """
    lpos = []
    len_mot = len(mot)
    for i in range(len_mot):
        if mot[i] == ch:
            lpos.append(i)
    return lpos

def output_str(mot: str, lpos: [int])-> str:
    """
    Retourne le mot avec des lettres cachées (remplacées par des tirets)

    inputs:
        mot: str : Mot
        lpos: [int] : Positions des lettres à afficher

    outputs:
        [str]: Mot avec lettres cachées
    """
    caracteres = ""
    len_mot = len(mot)
    for i in range(len_mot):
        if i in lpos:
            caracteres += mot[i]
        else:
            caracteres += "_"
        caracteres += " "
    return caracteres

def build_list(file_name: str)-> [str]:
    """
    Retourne la liste des mots présents dans un fichier texte

    inputs:
        file_name: str : Nom du fichier

    outputs:
        [str]: Liste des mots présents dans le fichier
    """
    fichier = open(file_name, "r", encoding="utf-8") #Ouverture du fichier
    lst_mot = fichier.read().lower().split('\n')
    return lst_mot

def build_dict(lst: list)-> dict:
    """
    Construit un dictionnaire à partir d'une liste de mots
    selon la taille des mots

    inputs:
        lst: list : Liste de mots

    outputs:
        dict: Dictionnaire avec la taille des mots comme clé,
              et les mots comme valeur
    """
    dict_mots = {}
    for elt in lst:
        taille = len(elt) #Taille du mot
        if dict_mots.get(taille) is None:
            dict_mots[taille] = [elt] #Création de la clé si elle n'existe pas
        #(elle n'existe pas tant qu'aucun des mots ajoutés n'a cette taille)
        else:
            dict_mots[taille].append(elt)
    return dict_mots

def select_word(sorted_words: dict, word_len: int)-> str:
    """
    Retourne un mot au hasard parmi les mots d'un dictionnaire
    avec une taille choisie

    inputs:
        sorted_words: dict : Dictionnaire
        word_len: int : Taille du mot à retourner

    outputs:
        str: Mot de taille word_len, pris au hasard dans le
             dictionnaire sorted_words
    """
    lst_mots = sorted_words.get(word_len)
    if lst_mots is None:
        mot = ""
    else:
        longueur_lst = len(lst_mots)
        indice_mot = rd.randint(0, longueur_lst-1) #Indice du mot sélectionné
        mot = lst_mots[indice_mot]
    return mot

def run_game():
    """
    Lance le jeu du pendu
    """
    C5 = ""
    C4 = "|---]"
    C3 = "| O "
    C2 = "| T "
    C1 = "|/ \ "
    C0 = "|______"
    PENDU = [C5, C4, C3, C2, C1, C0] #Affichage du pendu

    TAILLE_EASY = [1, 6]
    TAILLE_NORMAL = [7, 8]
    #Les mots ni dans Easy, ni dans Normal, sont dans Hard

    lignes = len(PENDU)
    coups = 5
    dict_mot = build_dict(build_list("capitales.txt"))

    cles_dict_mot = list(dict_mot.keys())
    #On prend les tailles des mots existantes dans la liste,
    #séparées par difficulté
    cles_easy = []
    cles_normal = []
    cles_hard = []
    for cle in cles_dict_mot:
        if cle >= TAILLE_EASY[0] and cle <= TAILLE_EASY[1]:
            cles_easy.append(cle)
        elif cle >= TAILLE_NORMAL[0] and cle <= TAILLE_NORMAL[1]:
            cles_normal.append(cle)
        else: #Mots difficiles
            cles_hard.append(cle)

    print("Choix de la difficulté (easy, normal ou hard)")
    difficulte = ""
    while difficulte not in ["E", "N", "H"]:
        difficulte = input("Entrer une lettre (E/N/H) : ")[0].upper()
    if difficulte == "E":
        lst_cles = cles_easy
    elif difficulte == "N":
        lst_cles = cles_normal
    else:
        lst_cles = cles_hard
    taille_mot = rd.choice(lst_cles)

    mot = select_word(dict_mot, taille_mot) #Tirage au sort du mot à trouver
    lpos_trouve = [] #Pos des lettres trouvées
    trouve = False
    while not trouve and coups > 0:
        print(output_str(mot, lpos_trouve))
        lettre = ""
        while lettre == "":
            lettre = input("Proposez une lettre : ")
        lettre = lettre[0] #Une seule lettre
        lpos_prop = places_lettre(lettre, mot) #Pos de la lettre proposée
        if lpos_prop == []:
            coups -= 1
        elif lpos_prop[0] in lpos_trouve:
            print("Lettre déjà trouvée")
        else:
            lpos_trouve += lpos_prop
        #Affichage du pendu en fonction des coups restants
        for i in range(lignes-coups):
            print(PENDU[i])
        print("Coups restants :", coups)
        trouve = (len(lpos_trouve) == len(mot))
    if trouve:
        print(mot, "a été trouvé")
    else:
        print(mot, "n'a pas été trouvé")

run_game()
