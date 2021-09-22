# -*- coding: utf-8 -*-
#Auteurs : Félicien BERTRAND, Jean BERTRAND
#Date : 08/09/2021
#Version : 1
#Description : Exercices de l'atelier 1

#Exercice 1
def calcul_salaire():
    """Calcul du salaire mensuel d'un employé payé à l'heure"""
    HSUP1 = 160 ; MAJ1 = 0.25 #+25% au-dessus de 160 heures
    HSUP2 = 200 ; MAJ2 = 0.5 #+50% au-dessus de 200 heures
    s_horaire = -1; heures = -1
    while s_horaire < 0 or heures < 0: #Vérification nombres positifs
        s_horaire = float(input("Salaire horaire : "))
        heures = int(input("Nombre d'heures : "))
    salaire = s_horaire * heures #Calcul salaire sans taux majoré
    if heures > HSUP1 and heures <= HSUP2:
        salaire += s_horaire * MAJ1 * (heures - HSUP1) #+25% entre 160 et 200h
    elif heures > HSUP2:
        salaire += s_horaire * MAJ1 * (HSUP2 - HSUP1) #+25% entre 160 et 200h
        salaire += s_horaire * MAJ2 * (heures - HSUP2) #+50% au-dessus de 200h
    print("Salaire mensuel =", salaire)
        

#s_horaire = 10
#heures = 220
calcul_salaire()


#Exercice 2
def type_caractere():
    """Affiche le type de caractère envoyé"""
    caractere = input("Entrer un caractère : ")[0]
    if caractere >= "0" and caractere <= "9":
        print(caractere, "est un chiffre")
    elif caractere >= "A" and caractere <= "Z":
        print(caractere, "est une majuscule")
    elif caractere >= "a" and caractere <= "z":
        print(caractere, "est une minuscule")
    else:
        print(caractere, "est un caractère spécial")

#caractere = "K"
#caractere = "*"
type_caractere()


#Exercice 3
def imposable():
    """Affiche si l'habitant est imposable ou non"""
    sexe = "" ; age = -1
    while sexe not in ["H","F"] or age < 0: #Vérification H/F et âge positif
        sexe = input("Saisir le sexe (H/F) : ").upper()
        age = int(input("Saisir l'âge : "))
    if (sexe == "H" and age > 20) or (sexe == "F" and age >= 18 and age <= 35):
        print("Habitant imposable")
    else:
        print("Habitant non imposable")

#genre = "H"
#age = 20
imposable()


#Exercice 4
def prix_reprographie():
    """Calcul du prix total des photographies"""
    PRIX1 = 0.10 ; MAX_COPIES1 = 10 #0.10 € par photocopie pour les 10 premières
    PRIX2 = 0.09 ; MAX_COPIES2 = 20 #0.09 € par photocopie pour les 20 suivantes
    PRIX3 = 0.08 #0.08 € par photocopie pour les suivantes
    copies = -1
    while copies < 0: #Vérification nombre positif
        copies = int(input("Nombre de photocopies : "))
    if copies <= MAX_COPIES1:
        prix = copies * PRIX1
    elif copies <= MAX_COPIES1 + MAX_COPIES2:
        prix = MAX_COPIES1 * PRIX1 + (copies - MAX_COPIES1) * PRIX2
    else:
        prix = MAX_COPIES1 * PRIX1 + MAX_COPIES2 * PRIX2
        prix += (copies - MAX_COPIES1 - MAX_COPIES2) * PRIX3
    prix = round(prix, 2)
    print("Prix =", prix, "€")

#copies = 55
prix_reprographie()


#Exercice 5
def calcul_frais():
    """Calcul des frais protuaires d'un voilier"""
    CATEGORIES = [1,2,3] #Les catégories et leurs taxes correspondantes sont dans le même ordre
    TAXES = [100,150,250]
    COUT_M1 = 100 ; LONG1 = 5 #Coût mensuel de 100 € pour moins de 5 m
    COUT_M2 = 200 ; LONG2 = 10 #Coût mensuel de 200 € pour 5 à 10 m
    COUT_M3 = 400 ; LONG3 = 12 #Coût mensuel de 400 € pour 10 à 12 m
    COUT_M4 = 600 #Coût mensuel de 600 € pour plus de 12 m
    longueur = 0; categorie = 0
    nom = input("Nom du voilier : ")
    while longueur <= 0: #Vérification longueur positive
        longueur = int(input("Longueur du voilier (m) : "))
    while categorie not in CATEGORIES: #Vérification catégorie existante
        categorie = int(input("Catégorie du voilier (1 à 3) : "))
    if longueur < LONG1:
        cout_mensuel = COUT_M1
    elif longueur >= LONG1 and longueur <= LONG2:
        cout_mensuel = COUT_M2
    elif longueur > LONG2 and longueur <= LONG3:
        cout_mensuel = COUT_M3
    else:
        cout_mensuel = COUT_M4
    cout_annuel = cout_mensuel * 12 + TAXES[categorie-1]
    print("Le coût annuel d'une place au port pour le voilier", nom, "est de", cout_annuel, "euros.")

#nom = "Saxo"
#longueur = 6
#categorie = 1
calcul_frais()


#Exercice 6
def frais_voiture():
    """Calcul des frais mensuels des voitures du concessionnaire"""
    CARBURANTS = ["D","E"]
    SURCOUT_D = 0.70 #Surcoût de 70% aux véhicules diesel
    SURCOUT_E = 0.50 #Surcoût de 50% aux véhicules essence
    CONSO1 = 100/10 #Consommation de 10 litres aux 100 km
    CONSO2 = 100/8 #Consommation de 8 litres aux 100 km
    km = int(input("Nombre de kilomètres parcourus en une année : "))
    carburant = ""
    while carburant not in CARBURANTS:
        print("Type de carburant (diesel/essence)")
        carburant = input("Entrez D ou E : ").upper()
    cylindree = int(input("Cylindrée de la voiture (cm3) : "))
    prix = float(input("Prix du carburant (€/l) : "))
    frais = km / CONSO2 #Conso de 8l / 100km par défaut
    if carburant == "E":
        surcout = SURCOUT_E
        if cylindree >= 2000:
            frais = km / CONSO1
    else:
        surcout = SURCOUT_D
    frais = frais * prix / 12
    frais += frais * surcout
    frais = round(frais, 2)
    print("Les frais mensuels s'élèvent à", frais, "€.")

#km = 10000
#carburant = E
#cylindree = 2100
#prix = 1.70
frais_voiture()


#Exercice 7
def elections():
    """Affiche le statut d'un candidat aux élections"""
    ELU = 50 #Candidat élu au 1er tour à paritr de 50%
    TOUR = 12.5 #Candidat au potentiel 2nd tour à partir de 12.5%
    candidat1 = float(input("Score du candidat 1 (en %) : "))
    candidat2 = float(input("Score du candidat 2 (en %) : "))
    candidat3 = float(input("Score du candidat 3 (en %) : "))
    candidat4 = float(input("Score du candidat 4 (en %) : "))
    if candidat1 + candidat2 + candidat3 + candidat4 > 100:
        print("Scores invalides")
    else:
        if candidat1 > ELU:
            print("Le candidat 1 est élu !")
        elif (candidat1 < TOUR
              or candidat2 > ELU
              or candidat3 > ELU
              or candidat4 > ELU):
            print("Le candidat 1 est éliminé.")
        else:
            if (candidat1 > candidat2
                and candidat1 > candidat3
                and candidat1 > candidat4):
                print("Le candidat 1 est en ballotage favorable.")
            else:
                print("Le candidat 1 est en ballotage défavorable.")

#candidat1 = 40
#candidat2 = 5.5
#candidat3 = 28
#candidat4 = 26.5
elections()


#Exercice 8
def assurance():
    """Affiche le contrat de l'assurance correspondant à la situation du conducteur"""
    AGE_MIN = 18 #Âge minimum pour le permis
    AGE_PALIER = 25 #Différence de situation à partir de 25 ans
    PERMIS_PALIER = 2 #Différence de situation à partir de 2 ans de permis
    FID_BONUS = 1 #Avantage de fidélité à partir d'un an avec l'assurance
    age = int(input("Âge du conducteur : "))
    permis = int(input("Années de permis : "))
    accidents = int(input("Nombre d'accidents : "))
    fidelite = int(input("Années d'assurance avec la compagnie : "))
    if (age < AGE_MIN or permis < 0 or permis > age - AGE_MIN
        or accidents < 0 or fidelite < 0 or fidelite > permis):
        print("Données incorrectes")
    else:
        tarif = 2 #Tarif "normal" : tarif vert
        if age < AGE_PALIER: #Un tarif plus cher pour les moins de 25 ans
            tarif += 1
        if permis < PERMIS_PALIER: #Un tarif plus cher pour les permis récents
            tarif += 1
        tarif += accidents #Chaque accident fait monter d'un tarif
        if tarif <= 4 and fidelite >= FID_BONUS:
            tarif -= 1 #Tarif moins cher avec la fidélité (sauf si déjà refusé)
        if tarif == 1:
            print("Tarif bleu")
        elif tarif == 2:
            print("Tarif vert")
        elif tarif == 3:
            print("Tarif orange")
        elif tarif == 4:
            print("Tarif rouge")
        else:
            print("Refusé")

#age = 26
#permis = 4
#accidents = 1
#fidelite = 2
assurance()
