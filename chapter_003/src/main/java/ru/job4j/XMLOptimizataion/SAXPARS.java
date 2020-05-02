package ru.job4j.XMLOptimizataion;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXPARS extends DefaultHandler {
    private int sum=0;
    private int countEl=0;
    public void startDocument ()
    {
        System.out.println("Start document");
    }

    public void endDocument ()
    {
        System.out.println(sum/countEl);
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("entry")) {
            String fieldValue = attributes.getValue("field");
            System.out.println("Field : " + fieldValue);
            sum= sum+Integer.parseInt(fieldValue);
            countEl += 1;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(" ")) {
            System.out.println("End Element :");
        }
    }


    public static void main(String[] args) throws SAXException {
        try {
            File inputFile = new File("C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\art.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXPARS userhandler = new SAXPARS();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

