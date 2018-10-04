./gradlew assemble
java -cp build/libs/hello-world-java-0.1-all.jar io.micronaut.graal.reflect.GraalClassLoadingAnalyzer 
native-image --class-path build/libs/hello-world-java-0.1-all.jar \
			 -H:ReflectionConfigurationFiles=build/reflect.json \
			 -H:EnableURLProtocols=http \
			 -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
			 -H:Name=hello-world-java \
			 -H:Class=hello.world.java.Application \
			 -H:+ReportUnsupportedElementsAtRuntime \
			 -H:+AllowVMInspection \
			 --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.codec.http.HttpObjectDecoder
