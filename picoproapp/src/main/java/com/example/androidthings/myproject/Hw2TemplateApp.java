package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class Hw2TemplateApp extends SimplePicoPro {
    @Override
    public void setup() {
        //set two GPIOs to input
        pinMode(GPIO_128,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);
        pinMode(GPIO_37,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_37,Gpio.EDGE_BOTH);
        pinMode(GPIO_35,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);
        pinMode(GPIO_34,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_34,Gpio.EDGE_BOTH);
        pinMode(GPIO_33,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_33,Gpio.EDGE_BOTH);
        pinMode(GPIO_32,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_32,Gpio.EDGE_BOTH);
        pinMode(GPIO_10,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_10,Gpio.EDGE_BOTH);
        pinMode(GPIO_172,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_172,Gpio.EDGE_BOTH);
        pinMode(GPIO_173,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_173,Gpio.EDGE_BOTH);
        pinMode(GPIO_174,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_174,Gpio.EDGE_BOTH);
        pinMode(GPIO_175,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_175,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
        //nothing to do here

    }
    char[][] text={{'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'g','k','l'},
            {'m','n','o'},
            {'p','q','r',' '},
            {'s','t','u','v'},
            {'w','x','y','z'},
    };
    int counter=0;
    int but=0;

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors
        if(pin==GPIO_128 && value==HIGH) {
            if(but!=0){
                but=0;
                counter=0;
            }
            counter++;
            if(counter>3) counter=1;
            //printCharacterToScreen('a');
        }
        else if(pin==GPIO_39 && value==HIGH) {
            if(but!=1){
                but=1;
                counter=0;
            }
            counter++;
            if(counter>3) counter=1;
            //printCharacterToScreen('a');
        }
        else if(pin==GPIO_37 && value==HIGH) {
            if(but!=2){
                but=2;
                counter=0;
            }
            counter++;
            if(counter>3) counter=1;
            //printCharacterToScreen('a');
        }

        else if(pin==GPIO_35 && value==HIGH) {
            if(but!=3){
                but=3;
                counter=0;
            }
            counter++;
            if(counter>3) counter=1;
            //printCharacterToScreen('a');
        }
        else if(pin==GPIO_34 && value==HIGH) {
            if(but!=4){
                but=4;
                counter=0;
            }
            counter++;
            if(counter>3) counter=1;
            //printCharacterToScreen('a');
        }
        else if(pin==GPIO_33 && value==HIGH) {
            if(but!=5){
                but=5;
                counter=0;
            }
            counter++;
            if(counter>4) counter=1;
            //printCharacterToScreen('a');
        }
        else if(pin==GPIO_32 && value==HIGH) {
            if(but!=6){
                but=6;
                counter=0;
            }
            counter++;
            if(counter>4) counter=1;
            //printCharacterToScreen('a');
        }
        else if(pin==GPIO_10 && value==HIGH) {
            if(but!=7){
                but=7;
                counter=0;
            }
            counter++;
            if(counter>4) counter=1;
            //printCharacterToScreen('a');
        }


        //when 39 goes from HIGH to HIGH
        else if (pin==GPIO_174 && value==LOW) {
            if(counter!=0) {
                printCharacterToScreen(text[but][counter - 1]);
                counter = 0;
            }
        }else if(pin==GPIO_175&& value==LOW){
            deletecharToScreen();
        }
    }
}
