package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by Yuan on 2015/6/25 0025.
 */
public class CreateTemplate {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(System.getProperty("user.dir"));
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            InputStream inputStream = url.openStream();
            InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.readLine();
            while (data != null){
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
