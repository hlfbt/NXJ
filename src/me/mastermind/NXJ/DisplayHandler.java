package me.mastermind.NXJ;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/**
 *
 * @author alex
 */
public class DisplayHandler implements Runnable {
    
    public static boolean running = true;
    
    @Override
    public void run() {
        while(running) {
            LCD.clear(1);
            LCD.drawString("State: "+RemoteReceiver.state,0,1);
            LCD.clear(2);
            LCD.drawString("Packet: "+RemoteReceiver.data,0,2);
            LCD.clear(3);
            LCD.drawString("Speed: "+RemoteReceiver.motorSpeed,0,3);
            LCD.clear(4);
            LCD.drawString("Tachometer:",0,4);
            LCD.clear(5);
            LCD.drawString("R "+Motor.A.getTachoCount(),0,5);
            LCD.clear(6);
            LCD.drawString("L "+Motor.C.getTachoCount(),0,6);
            drawConnectionIndicator(0);
            Delay.msDelay(200); // 200ms~5FPS, 60ms~15FPS, 45ms~21FPS, 30ms~31FPS
        }
    }
    
    public static void clearDisplay() {
        LCD.clearDisplay();
    }
    
    public static void drawListening() {
        LCD.clearDisplay();
        LCD.drawString("Listening...", 2, 3);
        drawConnectionIndicator(0);
    }
    
    public static void drawBye() {
        LCD.clearDisplay();
        LCD.drawString("Bye!", 7, 3);
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
