# Author: Rajvansh Sandhu
# Date: 5/27/2022
# Description:
# This is rock paper scissors game where the user will enter rock, paper or
# scissors. and the program will randomly genrate rock paper or scissors.
# then the program will print you won, you lose or draw accordingly.

#import random

score = 0
from random import randint

repeat = "yes"

x = 0

while x == 0:
    
    try:
        lives = int(input("how many lives do you want?\n"))
        if lives >= 1:
                
            while repeat.lower() == "yes" and lives >= 1:

                #make program randomly genrate number from 1-3
                computerHand = randint(1,3)

                #if computerHand = 1 then computer gets rock
                if computerHand == 1:
                    computerHand = "rock"

                #if computerHand is 2 then computer guessed paper
                elif computerHand == 2:
                    computerHand = "paper"

                else:
                    computerHand = "scissors"

                    #user inputs Rock, paper or scisors

                userHand = input("This is a rock paper scissors game\nchose one of the" +
                                     " following\nRock\nPaper\nScissors\n\n")
                    
                if (userHand.lower() == "rock" or userHand.lower() == "paper" or
                            userHand.lower() == "scissors"):
                            
                        #program finds out who wins
                    if computerHand == userHand.lower():
                            print("You and the computer tied\n")

                    elif (computerHand == "rock" and userHand.lower() == "scissors" or
                          computerHand == "paper" and userHand.lower() == "rock" or
                          computerHand == "scissors" and userHand.lower() == "paper"):
                        lives = lives - 1
                        print("You lost!\n")

                    else:
                        print("You won!!\n")
                        lives = lives + 1
                        score = score + 1

                            #program prints what you inputed and what the computer chose
                    print("You chose: "  + userHand + "\n" + "Computer chose: " +
                          str(computerHand) + "\nYou have " + str(lives) + " lives\n" +
                          "\nYour score is " + str(score))

                            #program asks use if they wan tot play again
                    repeat = input("Would you like to play again\n(enter yes to " +
                                       "play again): \n")
                        

                    #if the user entered anyting other than rock paper or scissors the it will
                    #    rerun code
                else:
                    print("please enter a valid input")
            else:
                print("thank you for using my program")
                break
            
    except ValueError:
            print("please enter vaild input")
            
    except KeyboardInterrupt:
            print("Figured it out Harjap")
        
    except OverflowError:
            print("please enter less values:")

    except SystemExit:
            print("you lose Harjap")


print("Thank you for playing")
    
    
    
