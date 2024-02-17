# Author: Rajvansh Sandhu
# Date: 5/27/2022
# descripction:
# This program simulates a traffic light. This program will ramdomely genrates
# numbers 1-3 and based off of the numebr the prints stop, slow and go.


#import random and time
import random
import time

# making program give only 50 outputs
count = 0

while count < 50:
    
    count = count + 1

    # program radomely genrates a number
    trafficLight =  random.randint(1,3)

    #if the RNG lands on 1 then the program will print stop
    if trafficLight == 1:
        print("stop")

    #if the RNG lands on 2 then the program will print go
    elif trafficLight == 2:
        print("go")

    #if the RNG lands on 3 then it will print slow
    else:
        print("slow")
    # adding gaps beteween each output
    print("\n")
    # making the program wait between outputs 
    time.sleep(0.5)
