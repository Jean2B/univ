# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 14/09/2021
Version : 1
Description : Exercice 1 de l'atelier 4
"""

import re

def full_name(str_arg: str)-> str:
    """
    Retourne une chaîne de caractère de type "NOM Prénom"
    avec des majuscules sur le nom et la première lettre du prénom

    inputs:
        str_arg: str : Chaîne de caractère de type "nom prénom"

    outputs:
        str: Chaîne de caractère de type "NOM Prénom"
    """
    str_split = re.split(" ", str_arg)
    str_split[0] = str_split[0].upper()
    str_split[1] = str_split[1].capitalize()
    str_res = str_split[0] + " " + str_split[1]
    return str_res

def is_mail(str_arg: str)-> (int, int):
    """
    Retourne un tuple vérifiant la validité d'une adresse mail

    inputs:
        str_arg: str : Adresse mail

    outputs:
        (int, int): (validité, code d'erreur)
                    (1, x) Si l'adresse mail est valide
                    (0, 2) S'il n'y a pas de "@"
                    (0, 1) S'il n'y a rien avant le "@"
                    (0, 3) S'il n'y a pas de nom de domaine à la suite du "@"
                    (0, 4) S'il n'y a pas de "." à la suite du nom de domaine
    """
    validite = (1, 0)
    lst_expressions = [r"@",    #Liste des regex pour vérifier l'adresse mail
                       r".@",
                       r"@[a-zA-Z0-9-]+",
                       r"@[a-zA-Z0-9-]+\.[a-zA-Z-.]+$"]
    lst_codes_err = [2, 1, 3, 4] #"Liste des codes d'erreur correspondantes
    i = 0
    while validite[0] == 1 and i < len(lst_expressions):
        if re.search(lst_expressions[i], str_arg) is None:
            validite = (0, lst_codes_err[i])
        else:
            i += 1
    return validite

def saisie_mail()-> str:
    """
    Saisie d'une adresse mail, et retourne un message correspondant au type
    d'erreur

    outputs:
        str: Type d'erreur
    """
    mail = input("Entrez une adresse mail : ")
    code = is_mail(mail)
    lst_msg = ["le corps n'est pas valide",
               "il manque l'@",
               "le nom de domaine n'est pas valide",
               "il manque le ."] #Codes d'erreur 1,2,3,4
    if code[0] == 1:
        msg = "Le mail est valide"
    else:
        msg = "Le mail n'est pas valide, " + lst_msg[code[1]-1]
    return msg

print(saisie_mail())
