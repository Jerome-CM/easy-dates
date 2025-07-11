Bienvenue sur le projet Easy Dates

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