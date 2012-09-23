package me.mastermind.NXJ;

import lejos.nxt.Battery;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/**
 *
 * @author Alexander Schulz
 */
public class DisplayHandler implements Runnable {
    
    public static boolean running = true;
    public static int displayState = 0;
    
    @Override
    public void run() {
        LCD.clearDisplay();
        drawConnectionIndicator(0);
        drawBattery();
        drawCharge();
        int i = 0;
        running = true;
        while (running) {
            switch (displayState) {
                case 0:
                    LCD.clear(3);
                    LCD.drawString("Listening...", 2, 3);
                    break;
                case 1: // Beautiful main screen!
                    LCD.clear(1);
                    LCD.drawString("Packet: "+RemoteReceiver.data,0,1);
                    LCD.clear(2);
                    LCD.drawString("State: "+RemoteReceiver.state,0,2);
                    LCD.clear(3);
                    LCD.drawString("Speed: "+RemoteReceiver.motorSpeed,0,3);
                    LCD.clear(4);
                    LCD.drawString("Tachometer:",0,4);
                    LCD.clear(5);
                    LCD.drawString("R "+Motor.A.getTachoCount(),0,5);
                    LCD.clear(6);
                    LCD.drawString("L "+Motor.C.getTachoCount(),0,6);
                    break;
                case 2:
                    LCD.clearDisplay();
                    LCD.drawString("Bye!", 7, 3);
                    break;
            }
            if (i == 100) { // Battery doesn't need to be updated every frame, every 10s is enough.
                i = 0;
                drawCharge();
            } else i++;
            Delay.msDelay(100); // 200ms~5FPS, 100ms~10FPS, 60ms~15FPS, 45ms~21FPS, 30ms~31FPS
        }
    }
    
    public static void clearDisplay() {
        LCD.clearDisplay();
    }
    
    public static void drawConnectionIndicator(int usb0bt1) { // Of course every single pixel must be set individually to draw stuff ಠ_ಠ
        if (usb0bt1 == 0) { // USB Indicator
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
        } else if (usb0bt1 == 1) { // Bluetooth Indicator
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
        } else { // ??? Indicator
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
    
    public static void drawBattery() { // And that's only the Battery's outer shell!
        LCD.setPixel(0, 0, 1);
        LCD.setPixel(1, 0, 1);
        LCD.setPixel(2, 0, 1);
        LCD.setPixel(3, 0, 1);
        LCD.setPixel(4, 0, 1);
        LCD.setPixel(5, 0, 1);
        LCD.setPixel(6, 0, 1);
        LCD.setPixel(7, 0, 1);
        LCD.setPixel(8, 0, 1);
        LCD.setPixel(9, 0, 1);
        LCD.setPixel(10, 0, 1);
        LCD.setPixel(0, 1, 1);
        LCD.setPixel(0, 2, 1);
        LCD.setPixel(0, 3, 1);
        LCD.setPixel(0, 4, 1);
        LCD.setPixel(0, 5, 1);
        LCD.setPixel(1, 5, 1);
        LCD.setPixel(2, 5, 1);
        LCD.setPixel(3, 5, 1);
        LCD.setPixel(4, 5, 1);
        LCD.setPixel(5, 5, 1);
        LCD.setPixel(6, 5, 1);
        LCD.setPixel(7, 5, 1);
        LCD.setPixel(8, 5, 1);
        LCD.setPixel(9, 5, 1);
        LCD.setPixel(10, 5, 1);
        LCD.setPixel(10, 4, 1);
        LCD.setPixel(10, 3, 1);
        LCD.setPixel(11, 3, 1);
        LCD.setPixel(10, 2, 1);
        LCD.setPixel(11, 2, 1);
        LCD.setPixel(10, 1, 1);
    }
    
    public static void drawCharge() { //  (╯°□°）╯︵ ┻━┻
        
        //<editor-fold defaultstate="collapsed" desc="Clear Charge">
        LCD.setPixel(1, 1, 0);
        LCD.setPixel(2, 1, 0);
        LCD.setPixel(3, 1, 0);
        LCD.setPixel(4, 1, 0);
        LCD.setPixel(5, 1, 0);
        LCD.setPixel(6, 1, 0);
        LCD.setPixel(7, 1, 0);
        LCD.setPixel(8, 1, 0);
        LCD.setPixel(9, 1, 0);
        LCD.setPixel(1, 2, 0);
        LCD.setPixel(2, 2, 0);
        LCD.setPixel(3, 2, 0);
        LCD.setPixel(4, 2, 0);
        LCD.setPixel(5, 2, 0);
        LCD.setPixel(6, 2, 0);
        LCD.setPixel(7, 2, 0);
        LCD.setPixel(8, 2, 0);
        LCD.setPixel(9, 2, 0);
        LCD.setPixel(1, 3, 0);
        LCD.setPixel(2, 3, 0);
        LCD.setPixel(3, 3, 0);
        LCD.setPixel(4, 3, 0);
        LCD.setPixel(5, 3, 0);
        LCD.setPixel(6, 3, 0);
        LCD.setPixel(7, 3, 0);
        LCD.setPixel(8, 3, 0);
        LCD.setPixel(9, 3, 0);
        LCD.setPixel(1, 4, 0);
        LCD.setPixel(2, 4, 0);
        LCD.setPixel(3, 4, 0);
        LCD.setPixel(4, 4, 0);
        LCD.setPixel(5, 4, 0);
        LCD.setPixel(6, 4, 0);
        LCD.setPixel(7, 4, 0);
        LCD.setPixel(8, 4, 0);
        LCD.setPixel(9, 4, 0);
        //</editor-fold>
        
        switch ((int)(Battery.getVoltage()+0.5)) {
            case 11:
            case 10:
            case 9:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(4, 1, 1);
                LCD.setPixel(5, 1, 1);
                LCD.setPixel(6, 1, 1);
                LCD.setPixel(7, 1, 1);
                LCD.setPixel(8, 1, 1);
                LCD.setPixel(9, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(4, 2, 1);
                LCD.setPixel(5, 2, 1);
                LCD.setPixel(6, 2, 1);
                LCD.setPixel(7, 2, 1);
                LCD.setPixel(8, 2, 1);
                LCD.setPixel(9, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(4, 3, 1);
                LCD.setPixel(5, 3, 1);
                LCD.setPixel(6, 3, 1);
                LCD.setPixel(7, 3, 1);
                LCD.setPixel(8, 3, 1);
                LCD.setPixel(9, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                LCD.setPixel(4, 4, 1);
                LCD.setPixel(5, 4, 1);
                LCD.setPixel(6, 4, 1);
                LCD.setPixel(7, 4, 1);
                LCD.setPixel(8, 4, 1);
                LCD.setPixel(9, 4, 1);
                break;
            case 8:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(4, 1, 1);
                LCD.setPixel(5, 1, 1);
                LCD.setPixel(6, 1, 1);
                LCD.setPixel(7, 1, 1);
                LCD.setPixel(8, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(4, 2, 1);
                LCD.setPixel(5, 2, 1);
                LCD.setPixel(6, 2, 1);
                LCD.setPixel(7, 2, 1);
                LCD.setPixel(8, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(4, 3, 1);
                LCD.setPixel(5, 3, 1);
                LCD.setPixel(6, 3, 1);
                LCD.setPixel(7, 3, 1);
                LCD.setPixel(8, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                LCD.setPixel(4, 4, 1);
                LCD.setPixel(5, 4, 1);
                LCD.setPixel(6, 4, 1);
                LCD.setPixel(7, 4, 1);
                LCD.setPixel(8, 4, 1);
                break;
            case 7:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(4, 1, 1);
                LCD.setPixel(5, 1, 1);
                LCD.setPixel(6, 1, 1);
                LCD.setPixel(7, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(4, 2, 1);
                LCD.setPixel(5, 2, 1);
                LCD.setPixel(6, 2, 1);
                LCD.setPixel(7, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(4, 3, 1);
                LCD.setPixel(5, 3, 1);
                LCD.setPixel(6, 3, 1);
                LCD.setPixel(7, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                LCD.setPixel(4, 4, 1);
                LCD.setPixel(5, 4, 1);
                LCD.setPixel(6, 4, 1);
                LCD.setPixel(7, 4, 1);
                break;
            case 6:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(4, 1, 1);
                LCD.setPixel(5, 1, 1);
                LCD.setPixel(6, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(4, 2, 1);
                LCD.setPixel(5, 2, 1);
                LCD.setPixel(6, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(4, 3, 1);
                LCD.setPixel(5, 3, 1);
                LCD.setPixel(6, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                LCD.setPixel(4, 4, 1);
                LCD.setPixel(5, 4, 1);
                LCD.setPixel(6, 4, 1);
                break;
            case 5:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(4, 1, 1);
                LCD.setPixel(5, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(4, 2, 1);
                LCD.setPixel(5, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(4, 3, 1);
                LCD.setPixel(5, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                LCD.setPixel(4, 4, 1);
                LCD.setPixel(5, 4, 1);
                break;
            case 4:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(4, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(4, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(4, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                LCD.setPixel(4, 4, 1);
                break;
            case 3:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(3, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(3, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(3, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                LCD.setPixel(3, 4, 1);
                break;
            case 2:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(2, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(2, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(2, 3, 1);
                LCD.setPixel(1, 4, 1);
                LCD.setPixel(2, 4, 1);
                break;
            case 1:
                LCD.setPixel(1, 1, 1);
                LCD.setPixel(1, 2, 1);
                LCD.setPixel(1, 3, 1);
                LCD.setPixel(1, 4, 1);
                break;
            default:
                break;
        }
    }
}
