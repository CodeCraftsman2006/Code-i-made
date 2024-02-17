
# Author: Rajvansh Sandhu

# Created on 4-25-2022

# Description:
# The user enter’s radius of the rink and the radius of the circus tent.
# Program calculates space in between and shows how much space is left
# for benches.


import math
# setting up y-loop
x = 0

while x == 0:
 #Enter data
    radiusOfInsideRink = float(input("radius of rink: "))
    radiusOfCircusTent = float(input("radius of circus tent: "))

#Error when radius of rink is less than radius of tent
    if radiusOfInsideRink > radiusOfCircusTent:
        print("Error! The tent cannot be smaller than the rink")
        continue
    if radiusOfInsideRink == radiusOfCircusTent:
        print("Error! The tent cannot be the same value as the rink")
        continue
    else:
# Calculating area
        areaOfInsideRink = math.pi * radiusOfInsideRink**2
        areaOfCircusTent = math.pi * radiusOfCircusTent**2
    
#Calculating space for benches
        spaceForBenches = 0
        spaceForBenches = areaOfCircusTent - areaOfInsideRink
    
#Rounding value
        roundedSpaceForBenches = round(spaceForBenches, 2)
        print(roundedSpaceForBenches)
        x = 1
