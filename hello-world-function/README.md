# Native Micronaut Functions with Graal

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

Don't worry about the output, this is purely to generate an initial `reflect.json` file in the root of the project that can be used as a base for building the native image.

Micronaut does not use reflection for DI but does do dynamic classloading, so any classes that are dynamically loaded have to be declared ahead of time in `reflect.json`.

Also any POJOs exposed via Jackson have to be declared, otherwise Jackson will not be able to serialize to JSON correctly.

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

Or explicitly:

```
native-image --class-path build/libs/hello-world-function-0.1-all.jar \
             -H:ReflectionConfigurationFiles=reflect.json \
             -H:EnableURLProtocols=http \
             -H:IncludeResources="application.yml|META-INF/services/*.*" \
             -H:Name=hw \
             -H:Class=io.micronaut.function.executor.FunctionApplication \
             -H:+ReportUnsupportedElementsAtRuntime \
             -H:+AllowVMInspection
```

The `-H:Name` flag defines the name of the function to be built. In this case `hw`.

## Run your function

The function is now executable:

```
$ echo 'John' | ./hw 
Hello John
```