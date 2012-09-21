/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.mastermind.NXJ;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/**
 *
 * @author alex
 */
public class DisplayHandler extends Thread {
    
    @Override
    public void run() {
        while(true) {
            LCD.clearDisplay();
            drawConnectionIndicator(0);
            LCD.drawString("State: "+RemoteReceiver.state,0,1);
            LCD.drawString("Byte: "+RemoteReceiver.data,0,2);
            LCD.drawString(EventHandler.event,10,2);
            LCD.drawString("Speed:"+RemoteReceiver.motorSpeed,0,3);
            LCD.drawString("Tachometer:\nR "+Motor.A.getTachoCount()+"\nL "+Motor.C.getTachoCount(), 0, 4);
            Delay.msDelay(45); // 60ms~15FPS, 45ms~21FPS, 30ms~31FPS
        }
    }
    
    public static void drawListening() {
        LCD.drawString("Listening...", 2, 3);
        drawConnectionIndicator(0);
    }
    
    public static void drawBye() {
        LCD.drawString("Bye!", 6, 3);
    }
    
    public static void drawConnectionIndicator(int usb0bt1) {
        if (usb0bt1 == 0) {
            LCD.setPixel(89, 1, 1);
            LCD.setPixel(89, 2, 1);
            LCD.setPixel(89, 3, 1);
            LCD.setPixel(89, 4, 1);
            LCD.setPixel(89, 5, 1);
            LCD.setPixel(90, 5, 1);
            LCD.setPixel(91, 5, 1);
            LCD.setPixel(91, 1, 1);
            LCD.setPixel(91, 2, 1);
            LCD.setPixel(91, 3, 1);
            LCD.setPixel(91, 4, 1);
            LCD.setPixel(91, 5, 1);
            LCD.setPixel(93, 1, 1);
            LCD.setPixel(94, 1, 1);
            LCD.setPixel(95, 1, 1);
            LCD.setPixel(93, 2, 1);
            LCD.setPixel(93, 3, 1);
            LCD.setPixel(94, 3, 1);
            LCD.setPixel(95, 3, 1);
            LCD.setPixel(95, 4, 1);
            LCD.setPixel(95, 5, 1);
            LCD.setPixel(94, 5, 1);
            LCD.setPixel(93, 5, 1);
            LCD.setPixel(97, 1, 1);
            LCD.setPixel(98, 1, 1);
            LCD.setPixel(97, 2, 1);
            LCD.setPixel(97, 3, 1);
            LCD.setPixel(98, 3, 1);
            LCD.setPixel(99, 2, 1);
            LCD.setPixel(97, 4, 1);
            LCD.setPixel(97, 5, 1);
            LCD.setPixel(98, 5, 1);
            LCD.setPixel(99, 4, 1);
        } else if (usb0bt1 == 1) {
            LCD.setPixel(91, 1, 1);
            LCD.setPixel(92, 1, 1);
            LCD.setPixel(91, 2, 1);
            LCD.setPixel(91, 3, 1);
            LCD.setPixel(92, 3, 1);
            LCD.setPixel(93, 2, 1);
            LCD.setPixel(91, 4, 1);
            LCD.setPixel(91, 5, 1);
            LCD.setPixel(92, 5, 1);
            LCD.setPixel(93, 4, 1);
            LCD.setPixel(95, 1, 1);
            LCD.setPixel(96, 1, 1);
            LCD.setPixel(97, 1, 1);
            LCD.setPixel(96, 2, 1);
            LCD.setPixel(96, 3, 1);
            LCD.setPixel(96, 4, 1);
            LCD.setPixel(96, 5, 1);
        } else {
            LCD.setPixel(97, 1, 1);
            LCD.setPixel(98, 1, 1);
            LCD.setPixel(99, 2, 1);
            LCD.setPixel(98, 3, 1);
            LCD.setPixel(98, 5, 1);
            LCD.setPixel(93, 1, 1);
            LCD.setPixel(94, 1, 1);
            LCD.setPixel(95, 2, 1);
            LCD.setPixel(94, 3, 1);
            LCD.setPixel(94, 5, 1);
            LCD.setPixel(89, 1, 1);
            LCD.setPixel(90, 1, 1);
            LCD.setPixel(91, 2, 1);
            LCD.setPixel(90, 3, 1);
            LCD.setPixel(90, 5, 1);
        }
    }
}
