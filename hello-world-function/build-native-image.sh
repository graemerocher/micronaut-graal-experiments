native-image --class-path build/libs/hello-world-function-0.1-all.jar -H:ReflectionConfigurationFiles=reflect.json -H:EnableURLProtocols=http -H:IncludeResources="application.yml|META-INF/services/*.*" -H:Name=hw -H:Class=io.micronaut.function.executor.FunctionApplication -H:+ReportUnsupportedElementsAtRuntime -H:+AllowVMInspection