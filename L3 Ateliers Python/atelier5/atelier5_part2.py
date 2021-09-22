# -*- coding: utf-8 -*-
"""
Auteurs : Félicien BERTRAND, Jean BERTRAND
Date : 20/09/2021
Version : 1
Description : Partie 2 de l'atelier 5
"""

import random as rd
import time
import matplotlib.pyplot as plt
import numpy as np
from atelier5_part1 import mix_list

#Exercice 5

#Pour mesurer le temps d'exécution nous avons à notre disposition
#la fonction perf_counter()
n = 10000000
#Récupération du temps système et démarrage du chronomètre
start_pc = time.perf_counter()
for i in range(n):
 #on ne fait rien…
 None
end_pc = time.perf_counter()
elapsed_time_pc = end_pc-start_pc
print("Temps écoulé entre les deux mesures : ",elapsed_time_pc)
print("Temps estimé pour une instruction",elapsed_time_pc/n)
# Exécutez ce code et vérifiez par vous-même la variabilité des mesures.

#Ici on décrit les abscisses
#Entre 0 et 5 en 10 points
x_axis_list = np.arange(0,5.5,0.5)
fig, ax = plt.subplots()
#Dessin des courbes, le premier paramètre
#correspond aux point d'abscisse le
#deuxième correspond aux points d'ordonnées
#le troisième paramètre, optionnel permet de
#choisir éventuellement la couleur et le marqueur
ax.plot(x_axis_list,x_axis_list,'bo-',label='Identité')
ax.plot(x_axis_list,x_axis_list**2, 'r*-', label='Carré')
ax.plot(x_axis_list,x_axis_list**3,'g*-', label='Cube')
ax.set(xlabel='Abscisse x', ylabel='Ordonnée y',
 title='Fonctions identité, cube et carré')
ax.legend(loc='upper center', shadow=True, fontsize='x-large')
#fig.savefig("test.png")
plt.show()

def perf_mix(f_mix, f_shuffle: callable, lst_tailles: [int],
             executions: int)-> ([float], [float]):
    """
    Calcule le temps d'exécution moyen de deux fonctions de mélange
    pour une même liste

    inputs:
        f_mix, f_shuffle: callable : Fonctions de mélange
        lst_tailles: [int] : Liste des différentes tailles de liste
                             utilisées pour la comparaison
        executions: int : Nombre d'excéutions moyen
    
    outputs:
        ([float], [float]): Temps d'exécution moyen des deux fonctions
                            de mélange, pour chaque taille de liste
    """
    lst_f = [f_mix, f_shuffle] #Liste contenant les deux fonctions à appeler
    nb_f = len(lst_f) #Nombre de fonctions (2)
    temps_moyen = ([], [])
    for taille in lst_tailles: #Pour chaque taille, appel des deux fonctions
        lst_sorted = [i for i in range(taille)]
        for i in range(nb_f):
            somme_temps_exec = 0
            #Appel de la fonction tout en mesurant le temps
            for _ in range(executions):
                start_pc = time.perf_counter()
                lst_f[i](lst_sorted) #Appel de la fonction de mélange
                end_pc = time.perf_counter()
                elapsed_time_pc = end_pc - start_pc
                somme_temps_exec += elapsed_time_pc
            #Calcul du temps moyen
            temps_moyen_exec = somme_temps_exec / executions
            temps_moyen[i].append(temps_moyen_exec)
    return temps_moyen

#perf_mix(mix_list, rd.shuffle, [10, 500, 5000, 50000, 100000], 10)
