package me.mastermind.NXJ;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXT;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;
import lejos.util.Delay;

/**
 *
 * @author Alexander Schulz
 */
public class RemoteReceiver {

    private static OutputStream conOut = null;
    private static DisplayHandler displayHandler = new DisplayHandler();
    
    public static int motorSpeed = 360;
    public static int maxSpeed = 1000;
    public static int minSpeed = 10;
    public static int data = 0;
    public static String state = "Standing";
    public static int protocol;

    public static void main(String[] args) {
        new Thread(new Runnable() { //Emergency Shutdown Thread (listening in background for escape keypress and sending shutdown packet upon keypress).
            public void run() {
                while(true) {
                    if (Button.waitForAnyPress() == Button.ID_ESCAPE) {
                        try {
                            conOut.write(255);
                            conOut.flush();
                            DisplayHandler.displayState = 4;  // Shutdown fine, display shutdown message.
                            Delay.msDelay(2000);
                            NXT.shutDown();
                        } catch (IOException ex) { // Should never happen.
                            System.out.println(ex.toString());
                            Button.waitForAnyPress();
                            NXT.shutDown();
                        } catch (NullPointerException ex) { // If the PC Program is already offline.
                            NXT.shutDown();
                        }
                    }
                }
            }
        }).start();
        new Thread(displayHandler).start(); // Starting teh DisplayHandler get some nice information on the screen.
        
        Motor.A.setSpeed(motorSpeed);
        Motor.C.setSpeed(motorSpeed);
        int timeout = 0; // 0 - forever
        int mode = 0; // NXTComm modes: 0 - All, 1 - USB, 2 - Bluetooth
        Boolean i = true;

        DisplayHandler.displayState = 0;
        NXTConnection con;
        while (true) {
            int keyPress = Button.waitForAnyPress();
            if (keyPress == Button.ID_LEFT) { // Bluetooth
                protocol = 2;
                DisplayHandler.displayState = 1;
                con = Bluetooth.waitForConnection(timeout, mode);
                break;
            } else if (keyPress == Button.ID_RIGHT) { // USB
                protocol = 1;
                DisplayHandler.displayState = 1;
                con = USB.waitForConnection(timeout, mode);
                break;
            }
        }
        InputStream conIn = con.openInputStream();
        conOut = con.openOutputStream();
        DisplayHandler.displayState = 3;

        while (i) { // Main loop where data is received and processed.
            try {
                data = conIn.read();
                i = EventHandler.eventHandler(data); // Processing data in EventHandler.
            } catch (IOException ex) { // Always these IOExceptions, sheesh...
                System.out.println(ex.toString());
                Button.waitForAnyPress();
                NXT.shutDown();
            }
        }

        DisplayHandler.displayState = 4; // Shutting down in 2s and displaying shutdown message!
        Delay.msDelay(2000);
        NXT.shutDown();
    }
}