package com.dvk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;

public class Client {
	
	static ClassLoader cl;
	static ServerItf server;

	static void reloadServer() throws Exception {
		URL[] url = new URL[]{new URL("file:./serverclass/")};
		cl = new URLClassLoader(url);
		server = (ServerItf)cl.loadClass("server.ServerImpl").newInstance();
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		reloadServer();
		while (true) {
			System.out.print("Enter QUOTE, RELOAD, or QUIT: ");
			String cmdRead = br.readLine();
			String cmd = cmdRead.toUpperCase();
			if (cmd.equals("QUIT")) {
				return;
			} else if (cmd.equals("QUOTE")) {
				System.out.println(server.getQuote());
			} else if (cmd.equals("RELOAD")) {
				reloadServer();
			}
		}
	}

}
