#!/bin/bash

# To make sure you can use the display of the host on windows:
# https://dev.to/darksmile92/run-gui-app-in-linux-docker-container-on-windows-host-4kde

docker build -t myapp .

# Use your local IP address
set-variable -name DISPLAY -value 192.168.0.15:0.0

docker run -ti --rm -e DISPLAY=$DISPLAY myapp