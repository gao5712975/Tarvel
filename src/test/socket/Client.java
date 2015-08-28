package test.socket;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 * Created by Yuan on 2015/8/9.
 */
public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();
            IOUtils.write("1234567".getBytes(),outputStream);
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            String info = IOUtils.toString(inputStream);
            System.out.println(info);

            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
