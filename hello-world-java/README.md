# Micronaut Java Graal Native Image Example


## Steps

### Install Graal

```
$ sdk install java 1.0.0-rc6-graal       
$ sdk use java 1.0.0-rc6-graal       
``` 

### Publish SVM to Local Maven Cache

```
$ mvn install:install-file -Dfile=${JAVA_HOME}/jre/lib/svm/builder/svm.jar -DgroupId=com.oracle.substratevm -DartifactId=svm -Dversion=GraalVM-1.0.0-rc6 -Dpackaging=jar
```

### Build the Application

Run `./gradlew assemble` 

### Run the Application

Run 

```bash
$ java -jar build/libs/hello-world-java-0.1-all.jar
```

This will generate a `build/reflect.json` file after performing classloading analysis.

### Build the Native Image

Run.

```bash
native-image --class-path build/libs/hello-world-java-0.1-all.jar \
			 -H:ReflectionConfigurationFiles=build/reflect.json \
			 -H:EnableURLProtocols=http \
			 -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
			 -H:Name=hw \
			 -H:Class=hello.world.java.Application \
			 -H:+ReportUnsupportedElementsAtRuntime \
			 -H:+AllowVMInspection \
			 --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder
```

### Run the Application

Run:

```bash
./hw
```

### Test the Application

Run:

```bash
$ curl -i http://localhost:8080/hello/John

HTTP/1.1 200 OK
Date: Wed, 5 Sep 2018 09:28:17 GMT
content-type: application/json
content-length: 24
connection: close

{"message":"Hello John"}
```
