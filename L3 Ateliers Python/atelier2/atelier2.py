# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 08/09/2021
Version : 1
Description : Exercices de l'atelier 2
"""

from datetime import date

#Exercice 1
def message_imc(imc: float)-> str:
    """Renvoie un message interprétant un IMC donné"""
    if imc < 16.5:
        msg = "dénutrition ou famine"
    elif imc < 18.5:
        msg = "maigreur"
    elif imc < 25:
        msg = "corpulence normale"
    elif imc < 30:
        msg = "surpoids"
    elif imc < 35:
        msg = "obésité modérée"
    elif imc < 40:
        msg = "obésité sévère"
    else:
        msg = "obésité morbide"
    return msg

def test_imc():
    """Affiche les messages correspondant aux IMC"""
    print("IMC de 16 :", message_imc(16))
    print("IMC de 29 :", message_imc(29))
    print("IMC de 37 :", message_imc(37))

test_imc()


#Exercice 2
def est_bissextile(annee: int)-> bool:
    """
    Renvoie si une année est bissextile ou non
    inputs:
        annee: int représente l'année qu'on veut tester
    outputs:
        boolean: True si l'année est bissextile,
                 False sinon
    """
    return (annee % 4 == 0 and annee % 100 != 0) or annee % 400 == 0

def test_bissextile():
    """Affiche si les années données sont bissextiles."""
    liste = [2021, 2024, 2100, 2000]
    #2021, 2100 ne sont pas bissextiles
    #2000, 2024 sont bissextiles
    for i in liste:
        print(i, ":", est_bissextile(i))

test_bissextile()


#Exercice 3
def discriminant(a: float, b: float, c: float)-> float:
    """Calcule et renvoie le discriminant"""
    delta = b ** 2 - 4 * a * c
    return delta

def racine_unique(a: float, b: float)-> float:
    """Calcule et renvoie la racine unique"""
    x = -b / (2 * a)
    return x

def racine_double(a: float, b: float, delta: float, num: int)-> float:
    """Calcule et renvoie la racine double"""
    if num == 1:
        x = (-b + delta**(1/2)) / (2 * a)
    if num == 2:
        x = (-b - delta**(1/2)) / (2 * a)
    return x

def str_equation(a: float, b: float, c: float)-> str:
    """Renvoie l'affichage de l'équation"""
    msg = "{}x² + {}x + {} = 0".format(a, b, c)
    return msg

def solution_equation(a: float, b: float, c: float)-> str:
    """Renvoie le message correspondant au nombre de racines"""
    delta = discriminant(a, b, c)
    msg = "Solution de l'équation {}\n".format(str_equation(a, b, c))
    if delta < 0:
        msg += "Pas de racine réelle"
    elif delta == 0:
        msg += "Racine unique : x = "
        msg += str(racine_unique(a, b))
    else:
        msg += "Deux racines :\nx1 = "
        msg += str(racine_double(a, b, delta, 1))
        msg += "\nx2 = "
        msg += str(racine_double(a, b, delta, 2))
    return msg

def equation(a: int, b: int, c: int):
    """Affiche la solution de l'équation"""
    print(solution_equation(a, b, c))

def test_equation():
    """Test de résolution d'équations du second degré"""
    equation(1, 6, 2) #2 racines
    equation(5, -3, 2) #Pas de racine
    equation(1, -2, 1) #1 racine

test_equation()


#Exercice 4
def date_est_valide(jour: int, mois: int, annee: int)-> bool:
    """
    Vérifie si la date donnée est valide

    inputs:
        jour: int : Jour
        mois: int : Mois
        annee: int : Année

    outputs:
        bool: True si la date est valide
              False sinon
    """
    ANNEE_MIN = 1900
    aujourdhui = date.today()
    if (annee < ANNEE_MIN or annee > aujourdhui.year): #Vérification de l'année
        return False
    if (mois <= 0 or mois > 12): #Vérification du mois
        return False
    if (jour <= 0 or jour > 31): #Vérification du jour
        return False
    if annee == aujourdhui.year:    #Cas de l'année actuelle
        if mois > aujourdhui.month:
            return False
        if (mois == aujourdhui.month and jour > aujourdhui.day):
            return False
    if mois == 2: #Vérification du mois de février
        if (jour > 29 or (not est_bissextile(annee) and jour == 29)):
            return False
    if (jour == 31                          #Vérification du jour 31
            and mois not in [1, 3, 5, 7, 8, 10, 12]):
        return False
    return True

def saisie_date_naissance()-> date:
    """
    Saisie de la date de naissance

    outputs:
        date: Date de naissance
    """
    valide = False
    while not valide:
        print("Entrez la date de naissance")
        annee = int(input("Année : "))
        mois = int(input("Mois : "))
        jour = int(input("Jour : "))
        valide = date_est_valide(jour, mois, annee)
        if not valide:
            print("Date invalide")
    return date(annee, mois, jour)

def age(date_naissance: date)-> int:
    """
    Calcul de l'âge avec la date de naissance

    inputs:
        date_naissance: date : Date de naissance

    outputs:
        int: Âge
    """
    aujourdhui = date.today()
    age_p = aujourdhui.year - date_naissance.year
    if (date_naissance.month > aujourdhui.month
            or
            date_naissance.month == aujourdhui.month
            and date_naissance.day > aujourdhui.day):
        age_p -= 1
    return age_p

def est_majeur(date_naissance: date)-> bool:
    """
    Vérifie si l'individu est majeur

    inputs:
        date_naissance: date : Date de naissance

    outputs:
        bool: True si l'individu est majeur
              False sinon
    """
    MAJORITE = 18
    return age(date_naissance) >= MAJORITE

def test_acces():
    """Test d'accès aux personnes majeures"""
    date_naissance = saisie_date_naissance() #
    age_i = age(date_naissance)
    majeur = est_majeur(date_naissance)
    if majeur:
        print("Bonjour, vous avez", age_i, "ans, Accès autorisé")
    else:
        print("Désolé, vous avez", age_i, "ans, Accès interdit")

test_acces()
