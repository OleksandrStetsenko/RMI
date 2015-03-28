package stetsenko.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import stetsenko.io.RmiInputStream;
import stetsenko.io.RmiInputStreamImpl;

public class RmiServer extends UnicastRemoteObject implements RmiServerIntf {

	private static final long serialVersionUID = 1L;	
	private Registry rmiRegistry; 
	
    public RmiServer() throws RemoteException {
    }
  	
	@Override
	public InputStream getInputStream(File f) throws IOException, RemoteException {
	    return new RmiInputStream(new RmiInputStreamImpl(new FileInputStream(f)));
	}
	
    public void start() throws Exception {
        rmiRegistry = LocateRegistry.createRegistry(1099);
        rmiRegistry.bind("server", this);
        System.out.println("Server started");
    }

    public void stop() throws Exception {
        rmiRegistry.unbind("server");
        unexportObject(this, true);
        unexportObject(rmiRegistry, true);
        System.out.println("Server stopped");
    }

}
