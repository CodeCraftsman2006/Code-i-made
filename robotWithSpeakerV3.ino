/*
 * Name: Rajvansh Sandhu
 * Date: 6/1/2023
 * Description: This program will allow a robot to follow a line
 */
 //initialize variables for push button, right mototr, left motor, left ir sensor, right ir sensor
 int pushButton = 12; 
 int leftEnablePin = 5;
 int rightEnablePin = 6;
 int irSensorLeft = 13;
 int irSensorRight = 2; 
 int blueLed = 8;
 int redLed = 4;
 int rightMotorSpeed = 250;
 int leftMotorSpeed = 255;
 int rightMotorTurningSpeed= 250;
 int leftMotorTurningSpeed= 255;
 int logicPinRight1 = 7;
 int logicPinRight2= 9;
 int logicPinLeft1 = 11;
 int logicPinLeft2 = 3;
 int ledState = HIGH;
 unsigned long currentMillis = millis();
 int prvMillis = 0;
 int speakerPin =A0;
 int potentiometer = A1;
 int tempo=200;
 int pushButton2= A2;
 int playMusic = 1;

int currentNote = 0;
 #define NOTE_B0  31
#define NOTE_C1  33
#define NOTE_CS1 35
#define NOTE_D1  37
#define NOTE_DS1 39
#define NOTE_E1  41
#define NOTE_F1  44
#define NOTE_FS1 46
#define NOTE_G1  49
#define NOTE_GS1 52
#define NOTE_A1  55
#define NOTE_AS1 58
#define NOTE_B1  62
#define NOTE_C2  65
#define NOTE_CS2 69
#define NOTE_D2  73
#define NOTE_DS2 78
#define NOTE_E2  82
#define NOTE_F2  87
#define NOTE_FS2 93
#define NOTE_G2  98
#define NOTE_GS2 104
#define NOTE_A2  110
#define NOTE_AS2 117
#define NOTE_B2  123
#define NOTE_C3  131
#define NOTE_CS3 139
#define NOTE_D3  147
#define NOTE_DS3 156
#define NOTE_E3  165
#define NOTE_F3  175
#define NOTE_FS3 185
#define NOTE_G3  196
#define NOTE_GS3 208
#define NOTE_A3  220
#define NOTE_AS3 233
#define NOTE_B3  247
#define NOTE_C4  262
#define NOTE_CS4 277
#define NOTE_D4  294
#define NOTE_DS4 311
#define NOTE_E4  330
#define NOTE_F4  349
#define NOTE_FS4 370
#define NOTE_G4  392
#define NOTE_GS4 415
#define NOTE_A4  440
#define NOTE_AS4 466
#define NOTE_B4  494
#define NOTE_C5  523
#define NOTE_CS5 554
#define NOTE_D5  587
#define NOTE_DS5 622
#define NOTE_E5  659
#define NOTE_F5  698
#define NOTE_FS5 740
#define NOTE_G5  784
#define NOTE_GS5 831
#define NOTE_A5  880
#define NOTE_AS5 932
#define NOTE_B5  988
#define NOTE_C6  1047
#define NOTE_CS6 1109
#define NOTE_D6  1175
#define NOTE_DS6 1245
#define NOTE_E6  1319
#define NOTE_F6  1397
#define NOTE_FS6 1480
#define NOTE_G6  1568
#define NOTE_GS6 1661
#define NOTE_A6  1760
#define NOTE_AS6 1865
#define NOTE_B6  1976
#define NOTE_C7  2093
#define NOTE_CS7 2217
#define NOTE_D7  2349
#define NOTE_DS7 2489
#define NOTE_E7  2637
#define NOTE_F7  2794
#define NOTE_FS7 2960
#define NOTE_G7  3136
#define NOTE_GS7 3322
#define NOTE_A7  3520
#define NOTE_AS7 3729
#define NOTE_B7  3951
#define NOTE_C8  4186
#define NOTE_CS8 4435
#define NOTE_D8  4699
#define NOTE_DS8 4978
#define REST      0
int melody[] = {

 // Super Mario Bros theme
  // Score available at https://musescore.com/user/2123/scores/2145
  // codee inspired by https://github.com/robsoncouto/arduino-songs/blob/master/supermariobros/supermariobros.ino
  // Theme by Koji Kondo
  
  
  NOTE_E5,8, NOTE_E5,8, REST,8, NOTE_E5,8, REST,8, NOTE_C5,8, NOTE_E5,8, //1
  NOTE_G5,4, REST,4, NOTE_G4,8, REST,4, 
  NOTE_C5,-4, NOTE_G4,8, REST,4, NOTE_E4,-4, // 3
  NOTE_A4,4, NOTE_B4,4, NOTE_AS4,8, NOTE_A4,4,
  NOTE_G4,-8, NOTE_E5,-8, NOTE_G5,-8, NOTE_A5,4, NOTE_F5,8, NOTE_G5,8,
  REST,8, NOTE_E5,4,NOTE_C5,8, NOTE_D5,8, NOTE_B4,-4,
  NOTE_C5,-4, NOTE_G4,8, REST,4, NOTE_E4,-4, // repeats from 3
  NOTE_A4,4, NOTE_B4,4, NOTE_AS4,8, NOTE_A4,4,
  NOTE_G4,-8, NOTE_E5,-8, NOTE_G5,-8, NOTE_A5,4, NOTE_F5,8, NOTE_G5,8,
  REST,8, NOTE_E5,4,NOTE_C5,8, NOTE_D5,8, NOTE_B4,-4,

  
  REST,4, NOTE_G5,8, NOTE_FS5,8, NOTE_F5,8, NOTE_DS5,4, NOTE_E5,8,//7
  REST,8, NOTE_GS4,8, NOTE_A4,8, NOTE_C4,8, REST,8, NOTE_A4,8, NOTE_C5,8, NOTE_D5,8,
  REST,4, NOTE_DS5,4, REST,8, NOTE_D5,-4,
  NOTE_C5,2, REST,2,

  REST,4, NOTE_G5,8, NOTE_FS5,8, NOTE_F5,8, NOTE_DS5,4, NOTE_E5,8,//repeats from 7
  REST,8, NOTE_GS4,8, NOTE_A4,8, NOTE_C4,8, REST,8, NOTE_A4,8, NOTE_C5,8, NOTE_D5,8,
  REST,4, NOTE_DS5,4, REST,8, NOTE_D5,-4,
  NOTE_C5,2, REST,2,

  NOTE_C5,8, NOTE_C5,4, NOTE_C5,8, REST,8, NOTE_C5,8, NOTE_D5,4,//11
  NOTE_E5,8, NOTE_C5,4, NOTE_A4,8, NOTE_G4,2,

  NOTE_C5,8, NOTE_C5,4, NOTE_C5,8, REST,8, NOTE_C5,8, NOTE_D5,8, NOTE_E5,8,//13
  REST,1, 
  NOTE_C5,8, NOTE_C5,4, NOTE_C5,8, REST,8, NOTE_C5,8, NOTE_D5,4,
  NOTE_E5,8, NOTE_C5,4, NOTE_A4,8, NOTE_G4,2,
  NOTE_E5,8, NOTE_E5,8, REST,8, NOTE_E5,8, REST,8, NOTE_C5,8, NOTE_E5,4,
  NOTE_G5,4, REST,4, NOTE_G4,4, REST,4, 
  NOTE_C5,-4, NOTE_G4,8, REST,4, NOTE_E4,-4, // 19
  
  NOTE_A4,4, NOTE_B4,4, NOTE_AS4,8, NOTE_A4,4,
  NOTE_G4,-8, NOTE_E5,-8, NOTE_G5,-8, NOTE_A5,4, NOTE_F5,8, NOTE_G5,8,
  REST,8, NOTE_E5,4, NOTE_C5,8, NOTE_D5,8, NOTE_B4,-4,

  NOTE_C5,-4, NOTE_G4,8, REST,4, NOTE_E4,-4, // repeats from 19
  NOTE_A4,4, NOTE_B4,4, NOTE_AS4,8, NOTE_A4,4,
  NOTE_G4,-8, NOTE_E5,-8, NOTE_G5,-8, NOTE_A5,4, NOTE_F5,8, NOTE_G5,8,
  REST,8, NOTE_E5,4, NOTE_C5,8, NOTE_D5,8, NOTE_B4,-4,

  NOTE_E5,8, NOTE_C5,4, NOTE_G4,8, REST,4, NOTE_GS4,4,//23
  NOTE_A4,8, NOTE_F5,4, NOTE_F5,8, NOTE_A4,2,
  NOTE_D5,-8, NOTE_A5,-8, NOTE_A5,-8, NOTE_A5,-8, NOTE_G5,-8, NOTE_F5,-8,
  
  NOTE_E5,8, NOTE_C5,4, NOTE_A4,8, NOTE_G4,2, //26
  NOTE_E5,8, NOTE_C5,4, NOTE_G4,8, REST,4, NOTE_GS4,4,
  NOTE_A4,8, NOTE_F5,4, NOTE_F5,8, NOTE_A4,2,
  NOTE_B4,8, NOTE_F5,4, NOTE_F5,8, NOTE_F5,-8, NOTE_E5,-8, NOTE_D5,-8,
  NOTE_C5,8, NOTE_E4,4, NOTE_E4,8, NOTE_C4,2,

  NOTE_E5,8, NOTE_C5,4, NOTE_G4,8, REST,4, NOTE_GS4,4,//repeats from 23
  NOTE_A4,8, NOTE_F5,4, NOTE_F5,8, NOTE_A4,2,
  NOTE_D5,-8, NOTE_A5,-8, NOTE_A5,-8, NOTE_A5,-8, NOTE_G5,-8, NOTE_F5,-8,
  
  NOTE_E5,8, NOTE_C5,4, NOTE_A4,8, NOTE_G4,2, //26
  NOTE_E5,8, NOTE_C5,4, NOTE_G4,8, REST,4, NOTE_GS4,4,
  NOTE_A4,8, NOTE_F5,4, NOTE_F5,8, NOTE_A4,2,
  NOTE_B4,8, NOTE_F5,4, NOTE_F5,8, NOTE_F5,-8, NOTE_E5,-8, NOTE_D5,-8,
  NOTE_C5,8, NOTE_E4,4, NOTE_E4,8, NOTE_C4,2,
  NOTE_C5,8, NOTE_C5,4, NOTE_C5,8, REST,8, NOTE_C5,8, NOTE_D5,8, NOTE_E5,8,
  REST,1,

  NOTE_C5,8, NOTE_C5,4, NOTE_C5,8, REST,8, NOTE_C5,8, NOTE_D5,4, //33
  NOTE_E5,8, NOTE_C5,4, NOTE_A4,8, NOTE_G4,2,
  NOTE_E5,8, NOTE_E5,8, REST,8, NOTE_E5,8, REST,8, NOTE_C5,8, NOTE_E5,4,
  NOTE_G5,4, REST,4, NOTE_G4,4, REST,4, 
  NOTE_E5,8, NOTE_C5,4, NOTE_G4,8, REST,4, NOTE_GS4,4,
  NOTE_A4,8, NOTE_F5,4, NOTE_F5,8, NOTE_A4,2,
  NOTE_D5,-8, NOTE_A5,-8, NOTE_A5,-8, NOTE_A5,-8, NOTE_G5,-8, NOTE_F5,-8,
  
  NOTE_E5,8, NOTE_C5,4, NOTE_A4,8, NOTE_G4,2, //40
  NOTE_E5,8, NOTE_C5,4, NOTE_G4,8, REST,4, NOTE_GS4,4,
  NOTE_A4,8, NOTE_F5,4, NOTE_F5,8, NOTE_A4,2,
  NOTE_B4,8, NOTE_F5,4, NOTE_F5,8, NOTE_F5,-8, NOTE_E5,-8, NOTE_D5,-8,
  NOTE_C5,8, NOTE_E4,4, NOTE_E4,8, NOTE_C4,2,
  
  //game over sound
  NOTE_C5,-4, NOTE_G4,-4, NOTE_E4,4, //45
  NOTE_A4,-8, NOTE_B4,-8, NOTE_A4,-8, NOTE_GS4,-8, NOTE_AS4,-8, NOTE_GS4,-8,
  NOTE_G4,8, NOTE_D4,8, NOTE_E4,-2,  

};
int notes = sizeof(melody) / sizeof(melody[0]) / 2;
int wholenote = (60000 * 4) / tempo;

int divider = 0;
int noteDuration = 0;

unsigned long startTime = 0;
 
void setup() {
  // put your setup code here, to run once:
  //using pinMode to delear each varible as a input or output pin
  Serial.begin(9600);
  pinMode(pushButton, INPUT);
  pinMode(irSensorLeft,INPUT);
  pinMode(irSensorRight,INPUT);
  pinMode(leftEnablePin, OUTPUT);
  pinMode(rightMotorSpeed, OUTPUT);
  //making sure mototr moves forward
  digitalWrite(logicPinRight1,HIGH);
  digitalWrite(logicPinRight2,LOW);
  digitalWrite(logicPinLeft1, HIGH);
  digitalWrite(logicPinLeft2, LOW);
  pinMode(blueLed, OUTPUT);
  pinMode(redLed, OUTPUT);
  pinMode(speakerPin, OUTPUT);
  pinMode(potentiometer, INPUT);

  digitalWrite(speakerPin, LOW);
  
  

}

void loop() {
  // put your main code here, to run repeatedly:
  //if the push button is pressed then the program will start
  analogWrite(rightEnablePin, 0);
  analogWrite(leftEnablePin, 0);

  if(digitalRead(pushButton2) == 1){
    playMusic = playMusic +1;
    delay(200);

  }
    


   if ((currentNote < notes) && (playMusic%2)== 0){
    digitalWrite(speakerPin, HIGH);
  tempo = analogRead(potentiometer);
  Serial.println(tempo);
  /*

The sizeof operator in C/C++ is used to determine the size, in bytes, of a variable or data type.
sizeof(melody) calculates the total size of the array melody in bytes.
sizeof(melody[0]) calculates the size of a single element in the melody array.
The division sizeof(melody) / sizeof(melody[0]) gives the number of elements in the melody array.
Finally, the division by 2 is performed to get half the number of elements in melody.
The result is assigned to the variable notes.
Essentially, this line of code calculates the number of notes in the melody array and stores it in the variable notes.
*/
   int notes = sizeof(melody) / sizeof(melody[0]) / 2;
   /*
   Here, tempo represents the tempo of the music piece.
60000 represents the number of milliseconds in a minute.
The multiplication 60000 * 4 calculates the total duration of a whole note in milliseconds (assuming a 4/4 time signature).
The division (60000 * 4) / tempo calculates the duration of a whole note in milliseconds based on the given tempo.
The result is assigned to the variable wholenote.
In summary, this line of code calculates the duration of a whole note in milliseconds based on the tempo and stores it in the variable wholenote.
*/
   int wholenote = (60000 * 4) / tempo;

    //provding a perview of the song so the tempo and leds can be adusted by the user.
    // Check if enough time has passed to play the next note
    if (millis() - startTime >= noteDuration) {
      // Calculate note duration and start time for the next note
      divider = melody[currentNote * 2 + 1];
      if (divider > 0) {
        noteDuration = (wholenote) / divider;
      } else if (divider < 0) {
        noteDuration = (wholenote) / abs(divider);
        noteDuration *= 1.5;
      }
      startTime = millis();

      // Play the current note
      int notePitch = melody[currentNote * 2];
      if (notePitch != 0) {
        tone(speakerPin, notePitch, noteDuration * 0.9);
      } else {
        noTone(speakerPin);
      }

      currentNote++;
    }
   }else {
    // Reset the melody to play it again
    currentNote = 0;
    startTime = millis();
  }
      //making the leds flash in sync with the music.
     currentMillis = millis();
    
     if((currentMillis - prvMillis) >= noteDuration){
       prvMillis = currentMillis;
       
       if(ledState == HIGH){
         ledState =LOW;
         
         digitalWrite(blueLed, LOW);
         digitalWrite(redLed, HIGH);
       } 
       else {
         ledState = HIGH;
         digitalWrite(blueLed, HIGH);
         digitalWrite(redLed, LOW);
       }
     }



 
 if(digitalRead(pushButton) == 1) {
  delay(500);
   

    // while loop to make sure the code reapeats until the button is pushed again
    while(true){


  if((playMusic%2)== 0){
  tempo = analogRead(potentiometer);
  Serial.println(tempo);
   int notes = sizeof(melody) / sizeof(melody[0]) / 2;
   int wholenote = (60000 * 4) / tempo;


   if (currentNote < notes) {

    //provding a perview of the song so the tempo and leds can be adusted by the user.
    // Check if enough time has passed to play the next note
    if (millis() - startTime >= noteDuration) {
      // Calculate note duration and start time for the next note
      divider = melody[currentNote * 2 + 1];
      if (divider > 0) {
        noteDuration = (wholenote) / divider;
      } else if (divider < 0) {
        noteDuration = (wholenote) / abs(divider);
        noteDuration *= 1.5;
      }
      startTime = millis();

      // Play the current note
      int notePitch = melody[currentNote * 2];
      if (notePitch != 0) {
        tone(speakerPin, notePitch, noteDuration * 0.9);
      } else {
        noTone(speakerPin);
      }

      currentNote++;
    }
   }else {
    // Reset the melody to play it again
    currentNote = 0;
    startTime = millis();
  }
      //making the leds flash in sync with the music.
     currentMillis = millis();
    
     if((currentMillis - prvMillis) >= noteDuration){
       prvMillis = currentMillis;
       
       if(ledState == HIGH){
         ledState =LOW;
         
         digitalWrite(blueLed, LOW);
         digitalWrite(redLed, HIGH);
       } 
       else {
         ledState = HIGH;
         digitalWrite(blueLed, HIGH);
         digitalWrite(redLed, LOW);
       }
     }
  }

      
      //checking if both ir sensors are sensing white bord around the black line
      if(digitalRead(irSensorLeft) ==1 && digitalRead(irSensorRight) ==1){
        digitalWrite(logicPinLeft1, HIGH);
        digitalWrite(logicPinLeft2, LOW);
        digitalWrite(logicPinRight1,HIGH);
        digitalWrite(logicPinRight2,LOW);
        analogWrite(rightEnablePin, rightMotorSpeed);
        analogWrite(leftEnablePin, leftMotorSpeed);
        
      }
      // checking if the robot is going off track then making it 
      else if(digitalRead(irSensorLeft) ==0 && digitalRead(irSensorRight) ==1){
        analogWrite(rightEnablePin, rightMotorTurningSpeed);
        digitalWrite(logicPinLeft1, LOW);
        digitalWrite(logicPinLeft2, HIGH);
        analogWrite(leftEnablePin, 200);
      }
       // checking if the robot is going off track then making it 
      else if(digitalRead(irSensorLeft) ==1 && digitalRead(irSensorRight) ==0){
        digitalWrite(logicPinRight1,LOW);
        digitalWrite(logicPinRight2,HIGH);
        analogWrite(rightEnablePin, 200);
        analogWrite(leftEnablePin, leftMotorTurningSpeed);
      }
      else{
        analogWrite(rightEnablePin, 0);
        analogWrite(leftEnablePin, 0);
        
      }

      // if the button is pressed then the robot will stop follwing the line
      if(digitalRead(pushButton) == 1){
        delay(500);
         digitalWrite(blueLed, LOW);
         digitalWrite(redLed, LOW);
        break;
        
        
      }

    }
 }
 }
