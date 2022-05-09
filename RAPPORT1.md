# UCE Génie Logiciel Avancé : Techniques de tests
# Rapport 1 - OPIGEZ Jérémie

## Introduction

Dans cet UE, le projet consiste à mettre en place un outil d’analyse statistique pour le jeu Pokémon GO.  
Pour cela nous devons mettre en place l'ensemble des tests depuis les interfaces avant d'effectuer toutes implementations.
Ce projet permet aussi d'assimiler de bons reflexes dans la gestion du code.

![diagram](./TPs/images/diagramme_de_classes.png)

## 1ere partie: Fork them all !

La premiere étape de ce projet est de réaliser un fork du projet.
Apres quoi la configuration du projet avec l'outil de production de projet Maven rentre en jeu via le fichier <code>pom.xml</code> .
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	 <modelVersion>4.0.0</modelVersion>
	 <groupId>fr.univ-avignon.tt</groupId>
	 <artifactId>java-project</artifactId>
	 <version>1.0-SNAPSHOT</version>
	<packaging>jar</packaging>
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<maven.compiler.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
	</properties>
	<name>java-project</name>
	<url>http://univ-avignon.fr</url>
	<build>
		<defaultGoal>
			clean test
		</defaultGoal>
		 <plugins>
			 <plugin>
				 <artifactId>maven-surefire-plugin</artifactId>
				 <version>2.22.0</version>
				 <configuration>
					 <testFailureIgnore>true</testFailureIgnore>
				 </configuration>
			 </plugin>
         </plugins>
	</build>
	<dependencies>
		 <dependency>
			 <groupId>org.junit.jupiter</groupId>
			 <artifactId>junit-jupiter-api</artifactId>
			 <version>5.8.2</version>
			 <scope>test</scope>
		 </dependency>
		 <dependency>
			 <groupId>org.mockito</groupId>
			 <artifactId>mockito-core</artifactId>
			 <version>4.5.1</version>
		 </dependency>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<version>5.8.2</version>
		</dependency>
	</dependencies>
</project>
```
Dans ce fichier nous ajoutons les dépendances pour les librairies de test que nous utiliserons à savoir JUnit et Mockito.
Une fois ces étapes effectuées, un petit commit / push nous permettra de mettre le tout sur le github.

## 2eme partie: (Dés)intégration continue
La deuxième partie concerne la mise en place d'intégration continue permettant d'effectuer une série d'action (test et build dans notre cas) à chaque fois qu'un push sur le repository sera effectué.
Pour ce faire nous utilisons la plateforme CircleCI, cette plateforme passe par la configuration d'un fichiert <code>config.yml</code>
```xml
version: 2.1

jobs:
  build-and-test:
    docker:
      - image: cimg/openjdk:17.0.2
    steps:
      - checkout
      - codecov/upload
      - run:
          name: Build
          command: mvn -B -DskipTests clean package
      - run:
          name: Test
          command: mvn clean test

workflows:
  sample:
    jobs:
      - build-and-test:
          filters:
            branches:
              only:
                - master
```

## 3eme partie: Pokéunit

Nous rentrons dans le coeur de l'UE avec l'implémentation des tests unitaires du projet.
Etant donnée que les interfaces ne sont pas encores implémentés, nous savons qu'aucun des tests ne peux réussir (cas à part de certaines methodes get qui ne font que retourner des valeurs d'objets).

L'utilisation de mocks est utilisé lorsque des classes utilises d'autre classes et que nous ne voulons pas que ces dernieres ne puissent influencer nos tests,
nous mockons donc les méthodes de ces classes.
```java
pokemonFactory = mock(IPokemonFactory.class);
when(pokemonFactory.createPokemon(0,613,64,4000,4))
        .thenReturn(new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56));
```

```java
@Test
void createPokemon() {
    Pokemon result = pokedex.createPokemon(0,613,64,4000,4);
    assertEquals(pokemon0.getIndex(),result.getIndex());
}
```
Le but est de couvrir un maximum de cas possible pour les différentes méthodes des interfaces à tester.
Une fois ces tests mis en place, la prochaine étapes sera d'implémenter les interfaces et 
pouvoir passer les tests grâce à cette implémentation.

## Conclusion

Cette premiere moitié d'UE nous a permis de prendre en main une plateforme nous permettant la mise en place de l'integration continue
et l'implementation de tests unitaire en faisant appel à des mocks. 