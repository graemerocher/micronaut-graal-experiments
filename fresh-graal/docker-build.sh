./gradlew assemble
docker build . -t fresh-graal
docker run --network host fresh-graal
