#Author: Rajvansh Sandhu
#Date: 5/13/2022
#Description:
# This is a program that tells you the weather a computer business made a profit
# or loss based on the number of laptops and pc's the program sold.

#setting up while loop for error messages
x = 0
while x == 0:
    
    costumerPc = int(input("How many Pc's did you sell?\n"))
    costumerLaptops = int(input("How many Laptops did you sell?\n"))

#error message if the user enters a negative value for the number of laptops
# they want to buy.
    if costumerPc < 0 or costumerLaptops < 0:
        print("you cannot enter negative values. Please enter positive values or"
              + " 0 if you don't want to buy a pc or laptop")
        continue
#applies discountes if needed  
    else:
        if costumerPc >= 10 and costumerLaptops >= 10:
            expense = costumerPc * 0.9 * 650 + costumerLaptops * 0.9 * 900 + 4000 
        elif costumerLaptops >= 10:
            expense = costumerPc * 650 + costumerLaptops * 0.9 * 900 + 4000
        elif costumerPc >= 10:
            expense = costumerPc * 0.9 * 650 + costumerLaptops * 900 + 4000
#processing to calculate the is the business made a profit or loss  
        else:
            expense = costumerPc * 650 + costumerLaptops * 900 + 4000
        profit = costumerLaptops * 999.99 + costumerPc * 799.99
        revenue = profit - expense
    
#privacy for the business owner so only they can see the profit and loss
#The password is playstation
    y = 0
    while y == 0:
        
        password = input("For more business details please enter your password\n")
        if password == "playstation":
            profitOutputMessage = ("your total profit is\n{:.2f}\nYour total expense is\n{:.2f}")
            print(profitOutputMessage.format(profit,expense))
            
# the program will print you made a loss if your expense is greater than your profit
            # the program will print you made a loss if your expense is greater than your profit
            if revenue < 0:
                revenue = revenue * -1
                lossOutputMessage = ("You you made a loss of:\n${:.2f}")
                print(lossOutputMessage.format(revenue))
                    
# the program will print you made a profit if you expense is less than your profit
            elif revenue > 0:
                profitOutputMessage = ("You made a revenue of:\n${:.2f}")
                print(profitOutputMessage.format(revenue))

#If you made no money the program will print "you made: $0", as it is not a profit
#or a loss.
            else:
                noProfitOutputMessage = ("You made:$\n${:.2f}\n(Living check to check is not a good idea)")
                print(noProfitOutputMessage.format(revenue))
                
#breaking while-loop
            y = 1
#asking the user if they want to use the program again
        else:
            print("incorrect password please try again")
            continue
            
    repeat = input("Would you like to run this program again? Enter yes to repeat this" +
                      "program again and any other input will make this program stop\n")
    if repeat == "yes":
        continue
    else:
        x = 1
        print("Thank you for using this program")
