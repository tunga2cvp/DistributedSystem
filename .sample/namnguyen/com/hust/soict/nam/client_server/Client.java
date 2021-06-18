package com.hust.soict.nam.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 9898);
		BufferedReader in = new BufferedReader(new
		InputStreamReader(socket.getInputStream()));
		PrintWriter out = new
		PrintWriter(socket.getOutputStream(), true);
		
		System.out.println(in.readLine());
		Scanner scanner = new Scanner(System.in);
		
		String line = null;
		while (!(line = scanner.nextLine()).isEmpty()) {
            //send the numbers
            out.println(line);
            System.out.println(in.readLine()); 
		}

		socket.close();
		scanner.close();
	}
}
