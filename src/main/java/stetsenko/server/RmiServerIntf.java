package stetsenko.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerIntf extends Remote {
	
	public InputStream getInputStream(File f) throws IOException, RemoteException;
	
}
