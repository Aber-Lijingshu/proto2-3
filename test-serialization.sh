#!/usr/bin/env bash

set -e -o pipefail

mvn clean install

function writeProto() {
    local version=$1
    java -classpath "${version}/target/lib/*" ProtoWriter ${version}
}

function readProto() {
    local generated_version=$1
    local runtime_version=$2
    java -classpath "${runtime_version}/target/lib/*" ProtoReader ${generated_version}
}

writeProto proto2
writeProto proto3

readProto proto2 proto3
readProto proto3 proto2
