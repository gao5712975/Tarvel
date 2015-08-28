package test.socket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * Created by Yuan on 2015/8/9.
 */
public class Server {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器即将启动");
            Socket socket = null;
            int count = 0;
            while (true){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端的数量" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
