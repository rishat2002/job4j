package concurrent;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Exp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread t=new Thread(()->{
            String file = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";
            try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream("C:\\projects\\job4j\\chapter_004\\src\\main\\java\\concurrent\\download.xml")) {
                byte dataBuffer[] = new byte[1000];
                System.out.println(dataBuffer.length);
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, dataBuffer.length)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                    Thread.sleep(10000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    while (t.isAlive()) {
        Thread.sleep(100);
    }
    }
}
