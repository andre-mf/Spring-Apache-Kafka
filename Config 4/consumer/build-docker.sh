#!/bin/bash

#Geração do pacote JAR
./mvnw package -Dmaven.test.skip=true

# Build da imagem Docker
docker build -t andremf/consumer:latest -f src/main/resources/Docker/Dockerfile target/

# Push da imagem
docker push andremf/consumer:latest

# Remoção do diretório target
rm -rf target/