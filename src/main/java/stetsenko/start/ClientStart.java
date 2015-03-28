package stetsenko.start;

import java.io.File;
import java.rmi.Naming;

import stetsenko.io.RmiIO;
import stetsenko.server.RmiServerIntf;

public class ClientStart {

	/**
	 * Starts download from server to client
	 * @param args
	 * 		0 - url (example "rmi://localhost")
	 * 		1 - source file path (example "c:\\somefile.log")
	 * 		2 - dest file path (example "c:\\somefile.log")
	 */
    public static void main(String args[]) {
    	    	                 
		try {
	        String url = args[0]; // example: url = "rmi://localhost"
	        File inFile = new File(args[1]); // example: args[1] = "c:\\somefile.log"
	        File outFile = new File(args[2]); // example: args[2] = "c:\\somefile.log"

            System.out.println(url + " " + inFile + " " + outFile);

			RmiServerIntf server = (RmiServerIntf) Naming.lookup(url + "/server");							
	        RmiIO.download(server, inFile, outFile);
			
		} catch (Exception e) {		
			System.err.println("Can not download file from server to client: " + e.getMessage());
		}

    }
    
}
