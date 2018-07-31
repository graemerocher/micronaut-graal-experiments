# Micronaut Java / Graal Experiments

Run 

mvn install:install-file -Dfile=${JAVA_HOME}/jre/lib/svm/builder/svm.jar -DgroupId=com.oracle.substratevm -DartifactId=svm -Dversion=GraalVM-1.0.0-rc4 -Dpackaging=jar

Run `./gradlew assemble` 

Then `./gradlew generateReflectJson`

Then `./build-native-image.sh`
