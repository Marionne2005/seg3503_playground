# seg3503_playground
# SEG3503 Lab 1

| Outline   | Value         |
|-----------|---------------|
| Course    | SEG 3503      |
| Date      | Summer 2026   |
| Professor |               |
| TA        |               |

## Instructions pour exécuter le code

### Java
```powershell
cd newmath_java/newmath_java
javac -encoding UTF-8 -d dist src/*.java
java -cp dist Main
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```

### Elixir
```powershell
cd newmath_ex/newmath_ex
mix test
iex.bat -S mix
```
# Lab 02 - Classes d'équivalence

## Exercice 1 — Tests manuels (user-registration-app)

> L'application a été lancée avec la commande :
> `java --add-opens java.base/java.lang=ALL-UNNAMED -jar user-registration-app-0.1.0.jar`
> puis visitée à http://localhost:8080/

| Cas de Test | Résultats Escomptés | Résultats Actuels | Verdict |
|-------------|--------------------|--------------------|---------|
| TC1 — Données valides (john123, John, Doe, john@gmail.com, 25, A1B2C3) | Accepté — "Congratulations" | Accepté — "Congratulations" | Succès |
| TC2 — Username trop court (jo) | Rejeté — "Size of UserName must be between 6 and 12" | Rejeté — message d'erreur affiché | Succès |
| TC3 — Email invalide (johngmail) | Rejeté — "Wrong Email format" | Rejeté — message d'erreur affiché | Succès |
| TC4 — Age vide | Rejeté — "Age is mandatory" | Rejeté — message d'erreur affiché | Succès |
| TC5 — Code postal invalide (12345) | Rejeté — "Wrong Postal Code format" | Rejeté — message d'erreur affiché | Succès |

Screenshots :

![TC1 - Formulaire valide](assets/formulaire_valide.png)
![TC1 - Résultat](assets/formulaire_valide.png)
![TC2 - Username invalide](assets/username_invalid.png)
![TC3 - Email invalide](assets/email_invalide.png)
![TC4 - Age vide](assets/age_invalid.png)
![TC5 - Code postal invalide](assets/codepostal_invalid.jpeg)

---

## JUnit Parameterized Runner

Tests compilés et exécutés avec :
```
javac -encoding UTF-8 --source-path src -d dist src\*.java
javac -encoding UTF-8 --source-path test -d dist -cp "dist;lib\junit-platform-console-standalone-1.7.1.jar" test\*.java
java -jar lib\junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```

![Résultats JUnit](assets/tests_successful.png)

---

## Exercice 2 — Tests JUnit pour `nextDate`

### Fichiers créés

- `DateTest.java` — 20 tests JUnit 5 explicites (TC1 à TC20)
- `DateNextDateOkTest.java` — tests paramétrés JUnit 4 pour les cas sans exception (TC1 à TC15)
- `DateNextDateExceptionTest.java` — tests paramétrés JUnit 4 pour les cas avec exception (TC16 à TC20)

### Résultats

**58 tests trouvés — 58 tests réussis — 0 échecs**

| Suite | Tests | Résultat |
|-------|-------|----------|
| DateTest (JUnit 5) | 20 | ✅ Tous réussis |
| DateNextDateOkTest (JUnit 4 Parameterized) | 15 | ✅ Tous réussis |
| DateNextDateExceptionTest (JUnit 4 Parameterized) | 5 | ✅ Tous réussis |
| BitTest (JUnit 5) | 14 | ✅ Tous réussis |
| BitAndTest (JUnit 4 Parameterized) | 4 | ✅ Tous réussis |

![Test run - 58/58](assets/tests_successful.png)