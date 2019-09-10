#!/bin/bash
find . -name '*.java' > scenario.txt
javac @sources.txt
javac -sourcepath @scenario.txt
java weather/Simulator scenario.txt