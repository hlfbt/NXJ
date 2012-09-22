package me.mastermind.NXJ;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    private static OutputStream conOut = null;
    
    public static int motorSpeed = 360;
    public static int maxSpeed = 760;
    public static int minSpeed = 10;
    public static String state = "Standing";
    public static int data = 0;

    public static void main(String[] args) {
        //Emergency Shutdown
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    if (Button.waitForAnyPress() == Button.ID_ESCAPE) {
                        try {
                            conOut.write(255);
                            NXT.shutDown();
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                            Button.waitForAnyPress();
                            NXT.shutDown();
                        } catch (NullPointerException ex) {
                            NXT.shutDown();
                        }
                    }
                }
            }
        }).start();
        
        Motor.A.setSpeed(motorSpeed);
        Motor.C.setSpeed(motorSpeed);
        int timeout = 0;
        int mode = 0; // NXTComm modes: 0 - All, 1 - USB, 2 - Bluetooth
        Boolean i = true;

        DisplayHandler.drawListening();
        USBConnection con = USB.waitForConnection(timeout, mode);
        InputStream conIn = con.openInputStream();
        conOut = con.openOutputStream();
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