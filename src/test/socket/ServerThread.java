package test.socket;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Yuan on 2015/8/10.
 */
public class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("客户端已连接");
            InputStream stream = socket.getInputStream();
            String info = IOUtils.toString(stream);
            System.out.println(info);
            socket.shutdownInput();

            OutputStream outputStream = socket.getOutputStream();
            IOUtils.write("欢迎你来到这个世界",outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
