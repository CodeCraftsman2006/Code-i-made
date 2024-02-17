# Author: Rajvansh Sandhu

# Created on 4-27-2022

# Description: The user enters a whole number and if it is positive program
# displays "it is positive". If it is negative program displays "it is
# negative". If it is zero program displays "It is zero"

#enter value
number = int(input("Value: "))

#based on value program gives the output of negative, positive or zero
if number < 0:
    print("Negative")
elif number > 0:
    print("Positive")
else:
    print("Zero")
