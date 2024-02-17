# Author: Rajvansh
# Date: 2022/05/11
#
# Description:  This program asks the user for the age of the customer. Depending
#               on the customers age, the program will determine the price for the 
#               movie ticket. If they want to stop the program they type in 'done'.    



outputMessage = "\nThe Price of the movie ticket is ${:.2f} \nThe price with tax is ${:.2f}"
x = 0
while x == 0:
    # user enter's age
    customerAge = int(input("Please enter the age of the customer below.\n"))

    if customerAge > 12:   

        priceOfTicket = 15.00   #If age of customer is greater than 12, price of ticket is $15.00.
            
    elif customerAge <= 12 and customerAge > 0: 

         priceOfTicket = 10.00  #Else if age of customer is less than or equal to 12 and greater than 0, the price of ticket is $10.00.
            
    else:
        print('\nERROR! Enter a true value') #Else, the program displays an ERROR message and asks to enter a true value.
        continue

    priceWithTax = priceOfTicket * 1.13 #Calculates the price with tax.

    print(outputMessage.format(priceOfTicket, priceWithTax)) #Displays the price of the movie ticket and price with the tax to user.
    x = 1
