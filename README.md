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
