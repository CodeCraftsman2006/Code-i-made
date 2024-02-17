# Author: Rajvansh Sandhu
# Date: 2022/06/01
# Description: The user starts out with $100. Then, the program will ask "how
# much money would you like to bet?". The program generates three different
# numbers within 0-5. Then, it will display these three numbers on the screen.
# Depending upon the number combination generated, the user can either win the
# prize or lose their bet. If they all 3 are 0's then they get 20 times the
# money bet. if it lands on 3 numbers then 0 then 10 times their bet. if 2
# numbers match they get 5 times their bet. Users can take a loans at diffrent
# rates	If the user takes a loan under 100 offer a 25% interest rate compounded
# every round. If it's over 100 then you get a 20% interest rate compounded
# every round. If loan is over 500 then you get a 15% interest rate of simple
# interest per round. Plus, for every round the user keeps their loan you will
# be the given a reroll of your numbers. the user can use them when they have
# bad luck.

#importing random to genrate numbers and time to make the program wait
import random
import time

    # ask the user if they want to see the rules
rules = input("--------------------------------------------------------" +
              "----------------------------\n\tWould you like to read the" +
              " rules?\n\t(enter yes to see the rules any other input will" +
              " take you straight to the game)\n-------------------------" +
              "-----------------------------------------------------------\n")
#                                                                                loan System, rerolls, exception handleing, file handleing spical event. Pvp if time permits

#setting up a message for the user to see the 3 number genrated, total money,
# money made, loan taken and loan owed.

userInfo = ("\nThe 3 numbers generated are:{:.0f},{:.0f},{:.0f}\n\n---------" +
            "---------------------------------------------------------------" +
            "------------\nYour total money is:${:.2f}\nYour made:${:.2f}\nLo"+
            "an taken: ${:.2f}\nAmount owed: ${:.2f}\nRound {:.0f}\n")

if rules.lower() == "yes":
    
    #the string in file will be a text file opened in pyton
    file = open("rules.txt","rt")
    print(file.read())

    #closeing the file
    file.close()
    
#If the user enters any other input for rules then the program will display
# you must be an experienced player

else:
    print("\nyou must be an experienced player :)\n")

loanMessage = open("loan.txt","rt")
    
#setting values for the total and money round, for while loop

totalMoney = 100
roundCount = 0
repeat = "yes"
loan = 0
loanCount = 0
loanTaken = 0
reRoll = 0

#loop to allow the user to continue gambling until they want to stop
while repeat.lower() != "no" and totalMoney >0:

    bet = 0
    while bet == 0:
        
        #making a try block if the user enter somting other then a float
        try:
            #user enter how much money they want to bet
            bet = float(input("How much money would you like to bet.\n"))
    #tellign pyton what to do if the user enters someting to cause an ValueError
            
        except ValueError:
            print("Please enter a valid input")
            bet = 0
            
#  telling the program what to print if the user enters valid iputs
        if bet < totalMoney and bet > 0:
            print("Hope you have good luck\n")

#if the user does not enter vaild inptu then
        else:
            print("Please enter a vaild input")
                   
    # the amount the user bets is taken out of his total amount
    totalMoney = totalMoney - bet

    #adding spical event randomly genrating a number
    spicalEvent = random.randint(0,100)
    
# if number falls in 0 and 10 then
    for spicalEvent in range(0,10):
        print("\nIts your luckey day and we will enter 20 times your bet" +
              "and see if you win")
        bet = bet * 20

#user needs 100 more doller to reeool if they dont have it then dotn ask
        if totalMoney >= 100:
            
            loop = input("\nFor another 100 dollers you can 20 times your" +
                                  "bet again. Enter y to do this any other input will" +
                                  "continue the game")
            if loop == "y":
                totalMoney = totalMoney - 100
                
            else:
                spicalEvent = -1
                
        else:
            print("You do not have enough money to multiply your bet")
            spicalEvent = -1

    #while loop if the user wants to reroll
    reRollChoice = "yes"
    while reRollChoice.lower() == "yes":
        
    #program randomly generates 3 number and stores it in luck, luckTwo, luckThree
        
        luck = random.randint(0,5)
        print("you rolled " + str(luck) + "\n")
        time.sleep(1)
        
        luckTwo = random.randint(0,5)
        print("you rolled " + str(luckTwo) + "\n")
        time.sleep(1)
        
        luckThree = random.randint(0,5)
        print("you rolled " + str(luckThree) + "\n")
        time.sleep(1)

    # if loan count is  0 then the user cannot rerool
        
        if reRoll > 0:
            
                reRollChoice = input("----------------------------------" +
                                    "----------------------------------" +
                                    "----------------\n\tyou have " +
                                    str(reRoll) + " reroll's, would" +
                                    "you like to use them?\n\t" +
                                    "enter yes to reroll. Enter any other " +
                                    "input if do not want to rerool")
                reRoll = reRoll -1
                    
        else:
            reRollChoice = "no"

        
    #keeping track of the number of rounds the user has played 
    roundCount = roundCount + 1

    #if all 3 numbers generated are 0s then the program will give the user 20 times
    #the money the originally bet
              
    if luck == 0 and luckTwo == 0 and luckThree == 0:
              bet = moneyChoice * 20
              print("\nWow you're lucky,\n you get 20 times your original bet!!\n")
              
              
    # if all 3 numbers match, but they are not a 0 then the user will get 10
    # times the original bet

    elif luck == luckTwo == luckThree:
        bet  = bet * 10
        print("\nyou get 10 times your bet\n")

    #If only 2 numbers match then the user will get 5 times their original bet
        
    elif (luck == luckTwo or luck == luckThree or luckTwo == luckThree):
        bet = bet * 5
        print("\nyou get 5 times your bet\n")

    #If nothing matches the user loses their money

    else:
        bet = bet * 0
        print("\nNothing matched you lost all the money you bet\n")

    #bet is added to the total amount
    totalMoney = totalMoney + bet

    #user see all necessary info
    print(userInfo.format(luck,luckTwo,luckThree,totalMoney,bet,loan,loanTaken,
                          roundCount,"\n----------------------------------" +
                          "----------------------------------------------" +
                          "----\n"))
    time.sleep(4)
#Seting up while loop so the code repeats after the error message
    
    while loan == 0:
        
 # adding a try statment
        try:
            
        #aking the user if they want to take a loan
            loan = float(input(loanMessage.read() + "\nHow much of a loan would you like?"))

            #breaking out of the loop if user has not taken a loan
            if loan == 0:
                print("\nYou have chosen not to take a loan")
                loan = 1

            # adding lona to the users money count
            elif loan > 0:
                print("\nyou have taken a loan")
                totalMoney = totalMoney + loan
                loanTaken = loan
                    
            #making a error message for the user
            else:
                print("\nPlease enter a valid number")
                loan = 0
            
#telling the program what to do in case of an value error
        except ValueError:
            
            print("\nPlease enter a vaild numebr")
            loan = 0
                    
    if loan > 0:
        #calulating how much the user needs to pay back
        if loan > 0 and loan <= 100:
            loanTaken = loanTaken * 1.25
                
        elif loan > 100 and loan <= 500:
            loanTaken = loanTaken * 1.20

        else:
            loanTaken = loanTaken + (loan * 0.15)
            
        #calulating how much  time has passed with the loan money the own
        reRoll = reRoll +1
        loanCount = loanCount + 1

        
        if totalMoney > loanTaken and loanCount >= 2:
        
        # adding while loop for error message
            error = 0
            while error == 0:
        
            #adding try block for the user entering a value error
                
                try:            
                    #asking the user if they want to pay off the loan
                    loanPayed = float(input("\nHow much of your loan do you" +
                                            "want to pay back:\n"))
                    error = 1
                    
#calulating how much more loan tnhey have to pay and how much money the have left
                        
                    if loanPayed > 0 and loanPayed < totalMoney:
                        totalMoney = totalMoney - loanPayed
                        loanTaken = loanTaken - loanPayed

                    elif loanPayed == 0:
                        print("\nYou have chosen not to pay back the loan")

#seting up a error message if an worng input is entered
                    else:
                         print("\nPlease enter a valid input")
                    
                except ValueError:
                    print("\nPlease enter a valid number")
                    
            else:
                print("\nYou dont have enough money to pay back your loan")

          
    else:
        print("Consider taking a loan")
        
    #asking the user if they want to play again
    if totalMoney > 0 and loan > 0:
            print("Do not leave with your loan\n")
        
        
    #asking the user if they want to take a loan if tehy run out of moeny
    elif totalMoney == 0 and loan > 0:
        
        print("You will have to pay your loan on a later date" +
              "Thank you for playing")

    elif totalMonay == 0 and loan == 0:
        
    #for error message
        error = 0
        while error == 0:

    #adding try block for the user entering a value error
            try:
                loan = float(input(loanMeassage.read() + "How much of a loan " +
                                 "would you like? or would you like to lose" +
                                 " the chance of wining more money"))

                repeat = input("Would you like to play again\nEnter no to cash"+
                               " out. Any other input will allow you to play" +
                               " again\n")
                error = 1

    #telling the program what to in case of a ValueError      
            except ValueError:
                print("Please enter a valid input")

#closeing the loanmessage
loanMessage.close()
                
print("Thank you for choosing Rajvansh gambling services")


