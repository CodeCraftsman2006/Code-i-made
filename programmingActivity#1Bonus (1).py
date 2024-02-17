
# Author: Rajvansh Sandhu

# Created on 4-27-2022

# Description:
# The user enters the number of copies he wants program calculates the price
# for the first 100 charging 5 cents and after charging 3 cents. Then, when
# over 100 charges 3 cents

#Setting up while-loop
x = 0
while x == 0:
    
#User inputs number of copies
    numberOfCopies = int(input("Input number of copies: "))
    
#Error statment when user enter values less then or equal to 0
    if numberOfCopies <= 0:
        print("Error you cannot enter 0 or negative values.")
        continue
    
#Program prosses the value the user inputed for numebrOfCopies
    if numberOfCopies > 100:
        numberOfCopies3Cents = numberOfCopies - 100
        totalPrice = numberOfCopies3Cents * 0.03 + 100 * 0.05
        x = 1
    else:
        totalPrice = numberOfCopies * 0.05
        
#breaking while-loop
        x = 1
    
#Program prints out the totalPrice charing 5 cents for the frist 100 and
#3 cents for the rest
print("total price is:$", totalPrice)
