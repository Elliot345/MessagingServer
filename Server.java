import java.net.*;
import java.io.*;

class Server {
  private Socket socket;
  private ServerSocket server;
  private DataInputStream in;

  public Server(int port) throws Exception {
    server = new ServerSocket(port);
    System.out.println("server started");
  }
  public void run() throws Exception {
    while (true) {
      System.out.println("waiting for client");
      
      socket = server.accept();
      System.out.println("Client accepted");
      System.out.println("--IP:    " + socket.getInetAddress());
      System.out.println("--Port:  " + socket.getPort());

      socket.close();
    }
  }
  
  public static void main(String[] args) throws Exception {
    Server server = new Server(5000);
    server.run();
  }
}