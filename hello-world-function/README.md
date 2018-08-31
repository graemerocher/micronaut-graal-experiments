# Micronaut Functions with Graal

Demonstrates buiding a Micronaut function into a Graal native image

# Steps Required

## Install Graal

Easiest way is via SDKman:

```
sdk install java 1.0.0-rc5-graal
sdk use java 1.0.0-rc5-graal
```

Then use Maven to install the SVM JAR file:

```
mvn install:install-file -Dfile=${JAVA_HOME}/jre/lib/svm/builder/svm.jar -DgroupId=com.oracle.substratevm -DartifactId=svm -Dversion=GraalVM-1.0.0-rc5 -Dpackaging=jar
```

## Prepare the Function

Run the function via Gradle:

```
$ ./gradlew run
```

This will generate a `reflect.json` file in the root of the project.

## Build the Function

Build the function JAR file with:

```
./gradlew test assemble
```

## Build the Native Image

To build the native image run the `./build-native-image.sh` script:

```
./build-native-image.sh
```

## Run your function

The function is now executable:

```
$ echo 'John' | ./hw 
Hello John
```