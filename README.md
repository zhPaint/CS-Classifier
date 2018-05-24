# CS-Classifier

CS-Classifier was developed by 4 undergraduate students for the CS350: Intro to Software Engineering course at Old Dominion University.

CS-Classifier was developed for the purpose of classifying documents to categories in the 1998 ACM Classification System.
Supported file extensions: .html, .pdf, .xml, .txt

## Authors:
* **Rufor Chen** - *Developer* - [zhPaint](https://github.com/zhPaint)
* **Robert Marchand** - *Developer*
* **Christopher Harrison** - *Developer*
* **M. Walker** - *Developer*


## Usage:
This project uses the Gradle for build automation, and implements the Gradle Wrapper.

For a list of gradle tasks, use:
```
gradlew --help
```

#### Windows:
```
gradlew --help
```
#### *nix:
```
./gradlew --help
```

#### To run:
Use following command from the project root:
```
java -jar build/libs/Blue4.jar
```
**IMPORTANT**: you must be in the same directory as build.gradle to execute the .jar
so that it can detect the specified manifest/mainClass for the .jar

## Key tasks for development:

-v: returns the version of gradle

build: attempts to compile

clean build: attempts to compile from a clean slate

run: attempts to run the mainClassName specified in build.gradle

test: attempts to run the unit tests in src/test/java, will only 
    show successful build if no tests fail.


