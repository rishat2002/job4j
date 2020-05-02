package ru.job4j.XMLOptimizataion;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class ConvertXSQT {
    public void convert(File source, File dest, File scheme) throws TransformerException {
        Source inputXML = new StreamSource(source);
        Source inputXSL = new StreamSource(scheme);
        Result outputXHTML = new StreamResult(dest);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(inputXSL);
        transformer.transform(inputXML, outputXHTML);
    }
    public static void main(String[] args) throws TransformerException {
    }
}
