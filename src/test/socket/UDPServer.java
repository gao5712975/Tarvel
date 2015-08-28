package test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Yuan on 2015/8/10.
 */
public class UDPServer {
    public static void main(String[] args) throws SocketException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
        System.out.println("服务器启动成功");
        try {
            datagramSocket.receive(datagramPacket);
            String info =new String(data,0,datagramPacket.getLength());
            System.out.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
