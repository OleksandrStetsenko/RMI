package stetsenko.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import stetsenko.server.RmiServerIntf;

public class RmiIO {

    private final static int BUFFER_SIZE = 1024 * 64;
    
	private static void copy(InputStream in, OutputStream out) throws IOException {
        
		System.out.println("copyring....");
        byte[] b = new byte[BUFFER_SIZE];
        int len;
        while ((len = in.read(b)) >= 0) {
            out.write(b, 0, len);
        }
        in.close();
        out.close();
        System.out.println("done!");
        
    }
	
	public static void download(RmiServerIntf server, File src, File dest) throws IOException {
		
		copy(server.getInputStream(src), new FileOutputStream(dest));
		
	}
	
}
