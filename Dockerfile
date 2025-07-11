# A example build step that downloads a JAR file from a URL and adds it to the providers directory
FROM quay.io/keycloak/keycloak:26.3.1

# Add the provider JAR file to the providers directory
ADD --chown=keycloak:keycloak --chmod=644 target/keycloak-custom-spi-template-1.0.0.jar /opt/keycloak/providers/myprovider.jar

# Context: RUN the build command
RUN /opt/keycloak/bin/kc.sh build