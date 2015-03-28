package stetsenko.start;

import stetsenko.server.RmiServer;

public class ServerStart {

	public static void main(String[] args) {
		
		try {
			RmiServer server = new RmiServer();
			server.start();
			Thread.sleep(2 * 60 * 1000); //2 min
			server.stop();
		} catch (Exception e) {
			System.err.println("Server problems: " + e.getMessage());
		}

	}

}
