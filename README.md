# Micronaut Graal Experiments

## Introduction

GraalVM's native image tool has some limitations around dynamic classloading which Micronaut relies on. These are however are in the process of being resolved. https://github.com/oracle/graal/issues/470

This repository contains not yet functional experiments of running Micronaut on GraalVM using the native image tool


## Building a Native Image

The command to build a native image is:

```
native-image --class-path hello-world-kotlin-0.1-all.jar -H:ReflectionConfigurationFiles=../../reflect.json -H:EnableURLProtocols=http -H:IncludeResources=META-INF/services/*.* -H:Name=hw -H:Class=example.Application -H:+ReportUnsupportedElementsAtRuntime
```
