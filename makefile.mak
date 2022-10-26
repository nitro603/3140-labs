all: build run

build:
	javac compareDates.java

run:
	java compareDates

question3:
	awk -f question3.awk shooting.csv

question4:
	awk -f question3.awk shooting.csv