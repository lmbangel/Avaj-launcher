#!/bin/bash
find . -name '*.java' > scenario.txt
javac @scenario.txt
javac -sourcepath @scenario.txt
java weather/Simulator scenario.txt
