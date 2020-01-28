package com.erc.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Harun ERGUL
 * @date 26.01.2020
 * @note Entry point for application
 */

@SpringBootApplication
public class MainApp {
	public static final int PORT = 9247;
	public static final boolean VERBOSE = true;

	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
		
		
		ServerSocket serverConnect = null;
		try {

			serverConnect = new ServerSocket(PORT);
			System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
			while (true) {
				HttpRequestHandler server = new HttpRequestHandler(serverConnect.accept());
				if (VERBOSE) {
					System.out.println("Connecton opened. (" + new Date() + ")");
				}

				Thread thread = new Thread(server);
				thread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Server Connection error : " + e.getMessage());
		} finally {
			try {
				serverConnect.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Server Connection close error : " + e.getMessage());
			}
		}

	}

}
