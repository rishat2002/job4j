package Syncronized;

import java.io.*;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        String output="";
        try(BufferedInputStream br = new BufferedInputStream(new FileInputStream(file)))
        {
            int data;
            while ((data = br.read()) > 0) {
                output += (char) data;
            }
        }
        return output;
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        String output="";
        try(BufferedInputStream br = new BufferedInputStream(new FileInputStream(file)))
        {
            int data;
            while ((data = br.read()) > 0) {
                if (data < 0x80) {
                    output += (char) data;
                }
            }
        }
        return output;
    }

    public synchronized void saveContent(String content) throws IOException {
        try(BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file)))
        {   for (int i = 0; i < content.length(); i += 1) {
            bw.write(content.charAt(i));
        }
        }
    }
    }

