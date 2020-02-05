package fr.univamu.tp3;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class App {
    public static void main( String[] args ) {
        System.out.println("EchoUDPServer is running…");

        if (args.length < 1) {
            print_help();
            return;
        }

        runServer(new Integer(args[0]));
    }

    public static void runServer(int port) {
        try {
            DatagramSocket server = new DatagramSocket(port);

            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                server.receive(packet);

                String answer = new String(packet.getData());

                System.out.println("Received: " + answer);

                answer = "> " + answer;
                packet.setData(answer.getBytes());
                server.send(packet);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void print_help() {
        System.out.println("Usage: EchoUDPServer.jar port");
    }
}
