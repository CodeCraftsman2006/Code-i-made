/*
Samme do not touch stuff you dont understand !!
all I want you to do is put the startLunch method in void loop
then troble shoot the startLunch method. Put the pin number for the
motors in the according varible. Once Shoots are consistent and are perfect
wire spearker, leds, H-brige.
Thank you 
love Raj

*/
// importing library's
#include <SoftwareSerial.h>
#include <Servo.h>
//defing notes in the array
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

/*
Rajvansh Sandhu 
2024-01-14 
This code allows a robot to go and stop 10 cm aways from a wall
and shoot a ball in the hoop.
*/
int trigPin = 9;
int echopin = 8;
int BTserialParameter1 = 13;
int BTserialParameter2 = 12;
int DcMotor1 = A0;
const int servoPin = A1;
int DriveMotor1 = 6;
int DriveMotor2 = 5;
char BTDataIn;

SoftwareSerial BTSerial(BTserialParameter1, BTserialParameter2);
Servo servo1;
int melody[] = {

  // Pink Panther theme
  // Open MenuPink Panther Tone Using Arduino by rayankiwan63 https://www.instructables.com/Pink-Panther-Tone-Using-Arduino/
  // Score available at https://musescore.com/benedictsong/the-pink-panther
  // Theme by Masato Nakamura, arranged by Teddy Mason

  REST,2, REST,4, REST,8, NOTE_DS4,8, 
  NOTE_E4,-4, REST,8, NOTE_FS4,8, NOTE_G4,-4, REST,8, NOTE_DS4,8,
  NOTE_E4,-8, NOTE_FS4,8,  NOTE_G4,-8, NOTE_C5,8, NOTE_B4,-8, NOTE_E4,8, NOTE_G4,-8, NOTE_B4,8,   
  NOTE_AS4,2, NOTE_A4,-16, NOTE_G4,-16, NOTE_E4,-16, NOTE_D4,-16, 
  NOTE_E4,2, REST,4, REST,8, NOTE_DS4,4,

  NOTE_E4,-4, REST,8, NOTE_FS4,8, NOTE_G4,-4, REST,8, NOTE_DS4,8,
  NOTE_E4,-8, NOTE_FS4,8,  NOTE_G4,-8, NOTE_C5,8, NOTE_B4,-8, NOTE_G4,8, NOTE_B4,-8, NOTE_E5,8,
  NOTE_DS5,1,   
  NOTE_D5,2, REST,4, REST,8, NOTE_DS4,8, 
  NOTE_E4,-4, REST,8, NOTE_FS4,8, NOTE_G4,-4, REST,8, NOTE_DS4,8,
  NOTE_E4,-8, NOTE_FS4,8,  NOTE_G4,-8, NOTE_C5,8, NOTE_B4,-8, NOTE_E4,8, NOTE_G4,-8, NOTE_B4,8,   
  
  NOTE_AS4,2, NOTE_A4,-16, NOTE_G4,-16, NOTE_E4,-16, NOTE_D4,-16, 
  NOTE_E4,-4, REST,4,
  REST,4, NOTE_E5,-8, NOTE_D5,8, NOTE_B4,-8, NOTE_A4,8, NOTE_G4,-8, NOTE_E4,-8,
  NOTE_AS4,16, NOTE_A4,-8, NOTE_AS4,16, NOTE_A4,-8, NOTE_AS4,16, NOTE_A4,-8, NOTE_AS4,16, NOTE_A4,-8,   
  NOTE_G4,-16, NOTE_E4,-16, NOTE_D4,-16, NOTE_E4,16, NOTE_E4,16, NOTE_E4,2,
 
};


void setup() {
  // setting serial communicaion to 9600
  Serial.begin(9600);
  //setting bt conmmunicaion to 9600
  BTSerial.begin(9600);
  // setting pins for ultra sonic sensor
  pinMode(trigPin, OUTPUT);
  pinMode(echopin, INPUT);
  pinMode(BTserialParameter1, INPUT);
  pinMode(BTserialParameter2, OUTPUT);
  pinMode(DcMotor1, OUTPUT);
  pinMode(2, OUTPUT);
  servo1.attach(servoPin); //function in the library 
  // declearing what pin is the motor is connected to
}


bool FoundWall(int trigPin,int echopin, int wallDistance){
long duration;
float distance;
//setting the trig pin low/0
digitalWrite(trigPin, LOW);

delayMicroseconds(2);// waiting to Microseconds then sending sound waves out
digitalWrite(trigPin, HIGH);

delayMicroseconds(10);// waiting 10 Microseconds then making trig pin low to stop sending sound waves
digitalWrite(trigPin, LOW);

//using the pluseIn function to read the echoPin value and store it in Duration
duration = pulseIn(echopin, HIGH);
 
//from the time it took the sound wave to return be can calulate how far the object is 
distance = duration*0.034/2;

if ( distance<= wallDistance){ 
  return true;
} else{
  return false;
}
}


char readBluetoothData(){

//setting the pins of the module

char BTDataIn;

if( BTSerial.available() > 0){

  // reading the data
  BTDataIn = BTSerial.read();
  Serial.print(BTDataIn);
  return BTDataIn;
}
}

bool wait(int seconds){
int prvMillis = 0;
//making the leds flash in sync with the music.
int currentMillis = millis();
if((currentMillis - prvMillis) >= seconds){
 prvMillis = currentMillis; 
 return true;
} else {
  return false;
}
}

void ledFlash(int Duration,int blueLed,int redLed){
int ledState = 0;

if(wait(Duration) == true){  
 if(ledState == 1){
   ledState =0;
   digitalWrite(blueLed, LOW);
   digitalWrite(redLed, HIGH);
  } 
  else {
    ledState = 1;
    digitalWrite(blueLed, HIGH);
    digitalWrite(redLed, LOW);
  }
  }
}
void pinkpanther(int speakerPin, int melody[]){
  int tempo = 120;
  int notes = sizeof(melody) / sizeof(melody[0]) / 2;
  int wholenote = (60000 * 4) / tempo;
  int noteDuration;
  int currentNote = 0;

  if (currentNote < notes) {

    // Check if enough time has passed to play the next note
    if (wait(noteDuration) == true) {
      // Calculate note duration and start time for the next note
      int divider = melody[currentNote * 2 + 1];
      if (divider > 0) {
        noteDuration = (wholenote) / divider;
      } else if (divider < 0) {
        noteDuration = (wholenote) / abs(divider);
        noteDuration *= 1.5;
      }

      // Play the current note
      int notePitch = melody[currentNote * 2];
      if (notePitch != 0) {
        tone(speakerPin, notePitch, noteDuration * 0.9);
      } else {
        noTone(speakerPin);
      }
    }
    currentNote++;
   }else {
    // Reset the melody to play it again
    currentNote = 0;
  }
}

void StartLaunch(int DcMotor1, Servo ServoMotor){
//making the motors spain
analogWrite(DcMotor1, 100);
int angle=90;
//writing the angle to the motor
servo1.write(angle);
if(wait(2000) == true){
  //writing the angle to the motor
  angle= 0;
}
}

void loop() {
  BTDataIn = readBluetoothData();

  if(BTDataIn == 'd'){
        //making the motors spain
    analogWrite(DcMotor1, 185);
    int angle=90;
  //writing the angle to the motor
  servo1.write(angle);
  if(wait(2000) == true){
    //writing the angle to the motor
    angle= 0;
}

servo1.write(90);


}
else if(BTDataIn == 'b'){
  analogWrite(DcMotor1 , 0);
      
}
  
}

