#!/bin/bash

echo "Creating a Docker Network"
docker network create metods

echo "Building build cache. This might take a while ..."
docker build --target="builder" -t yfudeutschland/method-service-build-cache .