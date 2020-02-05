package fr.univamu.tp3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class App {
    public static void main( String[] args ) {
        if (args.length < 2) {
            print_help();
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = null;

            try {
                msg = reader.readLine();
            } catch(IOException e) {
                continue;
            }
            if (msg == null) {
                break;
            }

            sendDatagram(msg, args[0], new Integer(args[1]));
        }
    }

    public static void print_help() {
        System.out.println("Usage: EchoUDPClient.jar serveur port");
    }

    public static void sendDatagram(String msg, String serveur, int port) {
        try {
            DatagramSocket s = new DatagramSocket();
            DatagramPacket paquet = new DatagramPacket(msg.getBytes(), msg.length(),
                                                       InetAddress.getByName(serveur),
                                                       port);
            s.send(paquet);
        } catch (Exception e) {

        }
    }
}
