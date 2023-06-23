#!/bin/bash


chmod +x concurrent.sh
mvn exec:java -Dexec.mainClass="main.lab1.AppConcurrent"
