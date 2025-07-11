#!/bin/bash -e

docker rm -f keycloak-custom-spi-template

./mvnw clean package

docker build -t keycloak-custom-spi-template:1.0.0 .

docker run --rm \
--name keycloak-custom-spi-template \
-p 8080:8080 -p 5005:5005 \
-e KC_BOOTSTRAP_ADMIN_USERNAME=admin \
-e KC_BOOTSTRAP_ADMIN_PASSWORD=admin \
-e JAVA_OPTS_APPEND="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" \
keycloak-custom-spi-template:1.0.0 \
start-dev