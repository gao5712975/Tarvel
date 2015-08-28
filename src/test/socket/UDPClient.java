package test.socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by Yuan on 2015/8/10.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 8888;
        byte[] data = "我是客户端".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);
    }
}
