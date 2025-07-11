# Bienvenue sur le projet Easy Dates

<div display="inline-block">
    <img src="https://img.shields.io/badge/Java-17-orange" alt="java badge"/>
    <img src="https://img.shields.io/badge/Release-1.0.2-brightgreen" alt="release badge"/>
</div>

Le projet à pour but de faciliter la conversion des dates en Java.

En entrée un objet :
- Date
- LocalDate
- LocalDateTime

En sortie : 
- Un pattern (dd/MM/yyyy par exemple)
- Date
- LocalDate
- LocalDateTime

Pour utiliser la dépendance, ajouter à votre pom ceci :

````
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
    <dependency>
      <groupId>com.github.Jerome-CM</groupId>
      <artifactId>easy-dates</artifactId>
      <version>1.0.0</version>
    </dependency>
<dependencies>
````

### Vous voulez contribuer au projet ? 

- Faites un fork
- Créer une nouvelle branche
- Ajouter votre code
- Faites une pull request