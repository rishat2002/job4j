package concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileDownload {
    public static void main(String[] args) throws Exception {
        String file = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";
        int v=Integer.parseInt(args[0])*1000;
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("ump.txt")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            long a=System.currentTimeMillis();
            long byteCount=0;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                byteCount=byteCount+1024;
                long b=System.currentTimeMillis();
                if (b-a==1000){
                    a=b;
                    if (byteCount>v) {
                    long sleepTime=(byteCount-v)/v-1000;
                    Thread.sleep(sleepTime);
                        System.out.println(sleepTime);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
