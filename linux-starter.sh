#!/bin/bash

# Color variables
red='\033[0;31m'
green='\033[0;32m'
yellow='\033[0;33m'
blue='\033[0;34m'
magenta='\033[0;35m'
cyan='\033[0;36m'
# Clear the color after that
clear='\033[0m'

echo -e "${red}Starting all required servers${clear}"
mvn -f "pom.xml" spring-boot:run &
SERVER_PID=$!
echo -e "${red}!!! - Press Enter stop all servers safely${clear}"
echo -e "${red}!!! - Press Enter stop all servers safely${clear}"
echo -e "${red}!!! - Press Enter stop all servers safely${clear}"
echo -e "${red}!!! - Press Enter stop all servers safely${clear}"
echo -e "${red}!!! - Press Enter stop all servers safely${clear}"
read
kill $SERVER_PID
clear
exit
