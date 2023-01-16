FROM ubuntu:latest

RUN apt-get update && \
    apt-get install -y openjdk-11-jdk

COPY out/production/homeproject /usr/src/myapp
COPY images /usr/src/myapp/images
COPY sounds /usr/src/myapp/sounds

WORKDIR /usr/src/myapp

ENTRYPOINT ["java","hu/flowacademy/kappa/Main"]
