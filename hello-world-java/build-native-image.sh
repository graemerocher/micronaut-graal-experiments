native-image --class-path build/libs/hello-world-java-0.1-all.jar \
			 -H:ReflectionConfigurationFiles=build/reflect.json \
			 -H:EnableURLProtocols=http \
			 -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
			 -H:Name=hw \
			 -H:Class=hello.world.java.Application \
			 -H:+ReportUnsupportedElementsAtRuntime \
			 -H:+AllowVMInspection \
			 --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder