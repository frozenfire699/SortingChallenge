# Range-Optimizer
Tool to optimize a given set of zip code ranges in the input and produces the minimum number of ranges required to represent the same
restrictions as the input.

![screen shot 2018-03-15 at 9 24 03 pm](https://user-images.githubusercontent.com/25812226/37502411-2e59d8ae-2898-11e8-9eec-902916a0ce97.png)
![screen shot 2018-03-16 at 6 42 40 am](https://user-images.githubusercontent.com/25812226/37521159-4d8d79fe-28e5-11e8-97f3-4537b75c4987.png)


# Motivation
This algorithm was written as a part of coding challenge assignment for William Sonoma

# What does it do?

1. It accepts a collection of zip code ranges (each range having upper and lower end bounds) and prints it on the console
1. It validates the given input ranges, sort them based on lower bounds, and then optimizes the input to produce minimum number of ranges
1. It will not process the input if there even a single invalid zip code range. It will gracefully exit by throwing an error message on the console
1. It prints the final optimized range on the console
1. It logs all the processing details in a log file


# Sample Input and Output
Input: [49679, 52015], [49800, 50000], [51500, 53479], [45012, 46937], [54012, 59607], [45500, 45590], [45999, 47900], [44000, 45000], [43012, 45950] </br>
Output: [43012, 47900], [49679, 53479], [54012, 59607]

# How to run it?
##Locally

1. Download the project
1. Set it up as a Java project in eclipse ( JDK 1.8 )
1. Open RangeUtils.java and enter the input zip code ranges inside getInputRange method
1. Add each range as a seperate entry using input.add("<entry>"), where entry is [xxxxx,yyyyy] along with square brackets
1. Execute the ZipOptimizeClient.java to start the program

# Program Notes

1. Zip code with leading zero is considered valid
1. Ranges with same upper and lower bound zip code values is considered valid
1. Ranges where upper bound of one is same as lower bound of other will be considered for optimizing

# Important Test cases

1. Validates for invalid inputs related to invalid characters, spaces
1. Validates for non 5 digit zip codes
1. Validates for invalid upper and lower bounds
