### Introduction

- This is a template project for building keycloak SPIs.
- This project is targeting Keycloak's version of `26.3.1`, if you need to change the version, please change it both for Maven dependency (`<keycloak.version>`) and the base image version (`FROM quay.io/keycloak/keycloak:26.3.1`) in Dockerfile

### Local Setup

- Make sure you installed:
    - Java 17+
    - Docker
- Run `./start-keycloak.sh`, then open http://localhost:8080 to login to Keycloak with `admin:admin`
- Keycloak is started with debug mode at debug port 5005
- You can then start remote JVM debug in the IDE
- For using MyCustomAuthenticator, try add it into an authentication flow as a step

### More Info

- The `./start-keycloak.sh` will do the following steps:
    - First try to kill any existing docker container for this project
    - Build the SPI project using Maven
    - Build Dockerfile into docker image with the SPI jar (keycloak-custom-spi-template-1.0.0.jar) copied into
      Keycloak's `/opt/keycloak/providers` folder
    - Run the container (keycloak-custom-spi-template:1.0.0)
