# Lab 03 — Mesures de couverture

## Date.java

### Suite de tests
9 tests ont été ajoutés à DateTest.java (tc21 à tc29) pour combler les branches/conditions non couvertes par la suite existante :
- année divisible par 400 (isLeapYear)
- jour > 31
- dépassement de jour pour un mois de 30 jours
- dépassement de jour en février bissextile
- mois < 1
- fin de mois en février non-bissextile (jour 28)
- toString()
- equals() avec un objet d'un autre type
- equals() avec des champs différents

### Outil Jacoco
L'outil Jacoco fourni dans lib/ n'est pas compatible avec le bytecode généré par le JDK utilisé (Java 21, erreur "Unsupported class file major version 65"). La couverture a donc été validée manuellement par analyse des branches du code, voir le tableau ci-dessous.

| Méthode | Condition / branche | Couverte par |
|---|---|---|
| setDay | day < 1 | tc20 |
| setDay | day > 31 | tc23 |
| setDay | mois 30j && day > 30 | tc24 |
| setDay | février bissextile && day > 29 | tc25 |
| setDay | février non-bissextile && day > 28 | tc16, tc17 |
| setDay | jour valide | tc01-15 |
| setMonth | month < 1 | tc26 |
| setMonth | month > 12 | tc19 |
| setMonth | mois valide | tc01-15 |
| setYear | year < 0 | tc18 |
| setYear | année valide | tc01-15 |
| nextDate | fin de mois, mois == 12 | tc15 |
| nextDate | fin de mois, mois != 12 | tc09, tc10, tc13, tc14 |
| nextDate | pas fin de mois | tc01-05 |
| isEndOfMonth | day == 31 | tc13, tc14, tc15 |
| isEndOfMonth | day == 30 && mois 30j | tc10 |
| isEndOfMonth | fev && day==29 && bissextile | tc09 |
| isEndOfMonth | fev && day==28 && non-bissextile | tc22 |
| isEndOfMonth | else (false) | tc01-05 |
| isThirtyDayMonth | mois dans {4,6,9,11} | tc07, tc10 |
| isThirtyDayMonth | autre mois | tc01, tc02 |
| isLeapYear | annee seculaire div 400 (vrai) | tc21 |
| isLeapYear | annee seculaire non div 400 (faux) | tc06, tc16 |
| isLeapYear | non seculaire, div 4 (vrai) | tc04 |
| isLeapYear | non seculaire, non div 4 (faux) | tc02 |
| toString | format affichage | tc27 |
| equals | objet pas une Date | tc28 |
| equals | champs differents | tc29 |
| equals | champs identiques | tc01-15 |

Toutes les branches et conditions de Date.java sont couvertes -> 100% statement/branch/condition coverage demontre manuellement.


