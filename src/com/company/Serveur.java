package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Serveur {

    public static void main(String[] args) {
        try {
            ServerSocket ss= new ServerSocket(1234);
            System.out.println("Attente d'une connexion client ...");
            Socket so = ss.accept();

                InputStream in = so.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bfr= new BufferedReader(isr);

                OutputStream out = so.getOutputStream();
                PrintWriter pw=new PrintWriter(out,true);

                String ident =bfr.readLine();
                System.out.println("le client "+ident+" est connexté ");
                pw.println("Bienvenu à toi "+ident);
                 Scanner sc= new Scanner(System.in);
                System.out.println("DEBUT DE LA CONVERSATION AVEC LE CLIENT . . .");
               while (true)
                {
                    System.out.println("Le serveur dit :");
                    String sendMessage =sc.next();
                    pw.println(sendMessage);
                    String receiveMessage =bfr.readLine();
                    System.out.println("le client dit "+receiveMessage);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
