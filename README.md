# Protobuf 2 and 3 Compatibility Test

A simple project that tests serialization / deserialization compatibility between protobuf versions.

## Module Overview

**proto2**

Forces the use of 2.5.0 version of protobuf-java at runtime.

* protobuf-java (runtime): 2.5.0
* proto-common: LATEST

**proto3**

Forces the use of 3.3.0 version of protobuf-java at runtime.

* protobuf-java (runtime); 3.3.0
* proto-common: LATEST

**proto-common**

Generated code and main classes ProtoReader / ProtoWriter.

* protobuf-java: 2.5.0
* protoc: 2.5.0
