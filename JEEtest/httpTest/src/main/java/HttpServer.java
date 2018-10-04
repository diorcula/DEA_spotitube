
import nl.han.ica.dea.fedor.ConnectionHandler;

import java.io.IOException;
import java.net.ServerSocket;


public class HttpServer {

    private int tcpPort;

    public HttpServer(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public static void main(String[] args) {
        new HttpServer(8383).startServer();
    }

    public void startServer() {
        try (
                ServerSocket serverSocket = new ServerSocket(this.tcpPort)
        ) {
            while (true) {
                System.out.println("Server accepting requests on port " + tcpPort);
               ConnectionHandler connectionHandler =  new ConnectionHandler(serverSocket.accept());    //new ConnectionHandler(serverSocket.accept()).handle();

                Thread thread = new Thread(connectionHandler);
                thread.start();
                connectionHandler.handle();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
