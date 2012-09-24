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
        drawBattery();
        drawCharge();
        drawConnectionIndicator();
        int i = 0;
        running = true;
        while (running) {
            switch (displayState) {
                case 0:
                    if (i == 0) {
                        clearDisplay();
                        drawArrows();
                        LCD.drawString("BT", 10, 3);
                        LCD.drawString("USB", 4, 4);
                    }
                    break;
                case 1:
                    LCD.clearDisplay();
                    drawBattery();
                    drawCharge();
                    drawConnectionIndicator();
                    displayState = 2;
                case 2:
                    LCD.clear(3);
                    if (i < 10) {
                        LCD.drawString("Listening", 2, 3);
                    } else if (i >= 10 && i < 20) {
                        LCD.drawString("Listening.", 2, 3);
                    } else if (i >= 20 && i < 30) {
                        LCD.drawString("Listening..", 2, 3);
                    } else if (i >= 30) {
                        LCD.drawString("Listening...", 2, 3);
                    }
                    break;
                case 3: // Beautiful main screen!
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
                case 4:
                    LCD.clearDisplay();
                    LCD.drawString("Bye!", 7, 3);
                    break;
            }
            if (i == 50) { // Battery doesn't need to be updated every frame, every 5s is enough.
                i = 0;
                drawCharge();
            } else i++;
            Delay.msDelay(100); // 200ms~5FPS, 100ms~10FPS, 60ms~15FPS, 45ms~21FPS, 30ms~31FPS
        }
    }
    
    public static void clearDisplay() {
        LCD.clear(1);
        LCD.clear(2);
        LCD.clear(3);
        LCD.clear(4);
        LCD.clear(5);
        LCD.clear(6);
        LCD.clear(7);
    }
    
    public static void drawArrows() {
        //<editor-fold defaultstate="collapsed" desc="Left Arrow">
        LCD.setPixel(46, 26, 1);
        LCD.setPixel(46, 27, 1);
        LCD.setPixel(47, 25, 1);
        LCD.setPixel(47, 26, 1);
        LCD.setPixel(47, 27, 1);
        LCD.setPixel(47, 28, 1);
        LCD.setPixel(48, 25, 1);
        LCD.setPixel(48, 26, 1);
        LCD.setPixel(48, 27, 1);
        LCD.setPixel(48, 28, 1);
        LCD.setPixel(49, 24, 1);
        LCD.setPixel(49, 25, 1);
        LCD.setPixel(49, 26, 1);
        LCD.setPixel(49, 27, 1);
        LCD.setPixel(49, 28, 1);
        LCD.setPixel(49, 29, 1);
        LCD.setPixel(50, 24, 1);
        LCD.setPixel(50, 25, 1);
        LCD.setPixel(50, 26, 1);
        LCD.setPixel(50, 27, 1);
        LCD.setPixel(50, 28, 1);
        LCD.setPixel(50, 29, 1);
        LCD.setPixel(51, 23, 1);
        LCD.setPixel(51, 24, 1);
        LCD.setPixel(51, 25, 1);
        LCD.setPixel(51, 26, 1);
        LCD.setPixel(51, 27, 1);
        LCD.setPixel(51, 28, 1);
        LCD.setPixel(51, 29, 1);
        LCD.setPixel(51, 30, 1);
        LCD.setPixel(52, 23, 1);
        LCD.setPixel(52, 24, 1);
        LCD.setPixel(52, 25, 1);
        LCD.setPixel(52, 26, 1);
        LCD.setPixel(52, 27, 1);
        LCD.setPixel(52, 28, 1);
        LCD.setPixel(52, 29, 1);
        LCD.setPixel(52, 30, 1);
        LCD.setPixel(53, 22, 1);
        LCD.setPixel(53, 23, 1);
        LCD.setPixel(53, 24, 1);
        LCD.setPixel(53, 25, 1);
        LCD.setPixel(53, 26, 1);
        LCD.setPixel(53, 27, 1);
        LCD.setPixel(53, 28, 1);
        LCD.setPixel(53, 29, 1);
        LCD.setPixel(53, 30, 1);
        LCD.setPixel(53, 31, 1);
        LCD.setPixel(54, 22, 1);
        LCD.setPixel(54, 23, 1);
        LCD.setPixel(54, 24, 1);
        LCD.setPixel(54, 25, 1);
        LCD.setPixel(54, 26, 1);
        LCD.setPixel(54, 27, 1);
        LCD.setPixel(54, 28, 1);
        LCD.setPixel(54, 29, 1);
        LCD.setPixel(54, 30, 1);
        LCD.setPixel(54, 31, 1);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Right Arrow">
        LCD.setPixel(54, 34, 1);
        LCD.setPixel(54, 35, 1);
        LCD.setPixel(53, 33, 1);
        LCD.setPixel(53, 34, 1);
        LCD.setPixel(53, 35, 1);
        LCD.setPixel(53, 36, 1);
        LCD.setPixel(52, 33, 1);
        LCD.setPixel(52, 34, 1);
        LCD.setPixel(52, 35, 1);
        LCD.setPixel(52, 36, 1);
        LCD.setPixel(51, 32, 1);
        LCD.setPixel(51, 33, 1);
        LCD.setPixel(51, 34, 1);
        LCD.setPixel(51, 35, 1);
        LCD.setPixel(51, 36, 1);
        LCD.setPixel(51, 37, 1);
        LCD.setPixel(50, 32, 1);
        LCD.setPixel(50, 33, 1);
        LCD.setPixel(50, 34, 1);
        LCD.setPixel(50, 35, 1);
        LCD.setPixel(50, 36, 1);
        LCD.setPixel(50, 37, 1);
        LCD.setPixel(49, 31, 1);
        LCD.setPixel(49, 32, 1);
        LCD.setPixel(49, 33, 1);
        LCD.setPixel(49, 34, 1);
        LCD.setPixel(49, 35, 1);
        LCD.setPixel(49, 36, 1);
        LCD.setPixel(49, 37, 1);
        LCD.setPixel(49, 38, 1);
        LCD.setPixel(48, 31, 1);
        LCD.setPixel(48, 32, 1);
        LCD.setPixel(48, 33, 1);
        LCD.setPixel(48, 34, 1);
        LCD.setPixel(48, 35, 1);
        LCD.setPixel(48, 36, 1);
        LCD.setPixel(48, 37, 1);
        LCD.setPixel(48, 38, 1);
        LCD.setPixel(47, 30, 1);
        LCD.setPixel(47, 31, 1);
        LCD.setPixel(47, 32, 1);
        LCD.setPixel(47, 33, 1);
        LCD.setPixel(47, 34, 1);
        LCD.setPixel(47, 35, 1);
        LCD.setPixel(47, 36, 1);
        LCD.setPixel(47, 37, 1);
        LCD.setPixel(47, 38, 1);
        LCD.setPixel(47, 39, 1);
        LCD.setPixel(46, 30, 1);
        LCD.setPixel(46, 31, 1);
        LCD.setPixel(46, 32, 1);
        LCD.setPixel(46, 33, 1);
        LCD.setPixel(46, 34, 1);
        LCD.setPixel(46, 35, 1);
        LCD.setPixel(46, 36, 1);
        LCD.setPixel(46, 37, 1);
        LCD.setPixel(46, 38, 1);
        LCD.setPixel(46, 39, 1);
        //</editor-fold>
    }
    
    public static void drawConnectionIndicator() { // Of course every single pixel must be set individually to draw stuff ಠ_ಠ
        if (RemoteReceiver.protocol == 1) { // USB Indicator
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
        } else if (RemoteReceiver.protocol == 2) { // Bluetooth Indicator
            LCD.setPixel(93, 3, 1);
            LCD.setPixel(92, 2, 1);
            LCD.setPixel(92, 4, 1);
            LCD.setPixel(94, 1, 1);
            LCD.setPixel(95, 1, 1);
            LCD.setPixel(94, 2, 1);
            LCD.setPixel(94, 3, 1);
            LCD.setPixel(95, 3, 1);
            LCD.setPixel(96, 2, 1);
            LCD.setPixel(94, 4, 1);
            LCD.setPixel(94, 5, 1);
            LCD.setPixel(95, 5, 1);
            LCD.setPixel(96, 4, 1);
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
