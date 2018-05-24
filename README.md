This project uses the Gradle build manager to package dependencies.


The Gradle wrapper has been implemented so that developers do not need to have 
it installed, this allows for the use of all gradle commands by replacing 
"gradle <command>" with "gradlew <command>"




A list of gradle commands can be retrieved with the "--help" command:

#### Windows:

"gradlew --help"

#### *nix:

"./gradlew --help"


## Key commands for development:

-v: returns the version of gradle

build: attempts to compile

clean build: attempts to compile from a clean slate

run: attempts to run the mainClassName specified in build.gradle

test: attempts to run the unit tests in src/test/java, will only 
    show successful build if no tests fail.

#### To run the .jar executable, use following command from the project root:

java -jar build/libs/Blue4.jar

**IMPORTANT**: you must be in the same directory as build.gradle to execute the .jar
so that it can detect the specified manifest/mainClass for the .jar