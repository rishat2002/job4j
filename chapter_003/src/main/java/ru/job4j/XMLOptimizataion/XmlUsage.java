package ru.job4j.XMLOptimizataion;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlUsage {
    @XmlType(name = "entries")
    @XmlRootElement
    static
    class Entries
    {
        @XmlElement
        public List entry = new ArrayList();
    }

    public static class Field {
        @XmlElement
        private int field;

        public Field(int field) {
            this.field = field;
        }

        public Field() {
        }

    }


    public static void main(String[] args) throws Exception {
        Field f=new Field(5);
        Entries zoo = new Entries();
        zoo.entry=Arrays.asList(f,f);
        JAXBContext jaxbContext = JAXBContext.newInstance(Field.class, Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                zoo,
                System.out
        );
    }
}
//<entries>
//<entry>
//<field>значение поля field</field>
//</entry>
//...
//<entry>
//<field>значение поля field</field>
//</entry>
//</entries>


//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//<user>
// <values>
// <value>1</value>
// </values>
// <values>
// <value>2</value>
// </values>
//</user>