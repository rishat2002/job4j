package ru.job4j.XMLOptimizataion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }
    public void save(List<XmlUsage.Field> list) throws JAXBException {

        XmlUsage.Entries n = new XmlUsage.Entries();
        n.entry=new ArrayList(list);
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlUsage.Field.class, XmlUsage.Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                n,
                target
        );

    }

    public static void main(String[] args) throws JAXBException, SQLException, ClassNotFoundException {


    }
}
