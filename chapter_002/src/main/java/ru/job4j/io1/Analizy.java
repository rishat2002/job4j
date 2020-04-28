package ru.job4j.io1;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Analizy {
    public void unavailable(String source,String target) throws IOException {
        Map<String, String> values = new HashMap<String, String>();
        File file = new File(source);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        PrintWriter out = new PrintWriter(new FileOutputStream(target));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.indexOf("400") != -1 || line.indexOf("500")!=-1) {
                String beginTime = line.substring(line.indexOf(" ")+1,line.length());
                String endTime=null;
                while(line.indexOf("400") != -1 || line.indexOf("500")!=-1) {
                    line=br.readLine();
                    endTime=line.substring(line.indexOf(" ")+1,line.length());
                }
                out.println(beginTime+";"+endTime);
            }
        }
        br.close();
        fr.close();
        out.close();

    }
    public static void main(String[] args) throws IOException {

    }
}
