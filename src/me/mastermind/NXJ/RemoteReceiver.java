package me.mastermind.NXJ;

import java.io.IOException;
import java.io.InputStream;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXT;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;

/**
 *
 * @author Alexander Schulz
 */
public class RemoteReceiver {

    public static int motorSpeed = 360;
    public static int maxSpeed = 760;
    public static int minSpeed = 10;
    public static String state = "Standing";
    public static int data = 0;

    public RemoteReceiver() {
        Motor.A.setSpeed(motorSpeed);
        Motor.C.setSpeed(motorSpeed);
        // Emergency Sutdown (not working ATM)
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    if (Button.waitForAnyPress() == Button.ID_ESCAPE) {
                        NXT.shutDown();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        int timeout = 0;
        int mode = 0; // NXTComm modes: 0 - All, 1 - USB, 2 - Bluetooth
        Boolean i = true;

        DisplayHandler.drawListening();
        USBConnection con = USB.waitForConnection(timeout, mode);
        InputStream conIn = con.openInputStream();
        new Thread(new DisplayHandler()).start();

        while (i) {
            try {
                data = conIn.read();
                i = EventHandler.eventHandler(data);
            } catch (IOException ex) {
                System.out.println(ex.toString());
                Button.waitForAnyPress();
                NXT.shutDown();
            }
        }

        NXT.shutDown();
    }
}