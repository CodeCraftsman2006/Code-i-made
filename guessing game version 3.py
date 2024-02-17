# Author: Rajvansh Sandhu
# Date: 5/25/2022
# Description: this program will ask the user to guess the number the program
# generates between 1-10. If the user guesses correctly the program prints "You
# have guessed correctly. If the user guess's lower than the programs number the
# program print's "you guess was too low". If the user's guess is to high the
# program will print "you guessed too high".

# import random
from random import randint

# seting the numebr of lives
lives =  5
#seting a a value for answer so the while loop runs
#
answer = "yes"
while answer.lower()== "yes" and lives > 0:

    #computer randomly genrates a numebr
    compNumber = randint(1,10)

    #user guesses number
    userNumber = int(input("Guess number from 1-10\n"))

    #prgram prints you guessed correctly if the user guessed correctly
    # and it ades 1 more life to your total life count
    if userNumber == compNumber:
        print("You guessed correctly")
        lives = lives + 1
        
    # if the user guess's incorrectly then the program will print you guessed
    # too high or too low accordingly. then take away 1 life from your total
    #lufe count
    elif userNumber < compNumber:
        print("You guessed to low")
        lives = lives - 1
        
    else:
        print("You guessed to high")
        lives = lives - 1

    # the program print the numbe rthe user selected and the numebr the computer
    # selcete, as well as your total life count
    print("\nThe number you selected: " + str(userNumber))
    print("The number the computer selected: " + str(compNumber))
    print("The number of lives you have left are: " + str(lives))

    #lastly to end the program the program will check if your lives have ran out or not
    # and ask the user i fthey would liek you play again
    if lives > 0:
        answer = input("Would you like to play again? Enter yes to play" +
                       " again:\n")
    
    else:
        print("Thank you for playing this game")
