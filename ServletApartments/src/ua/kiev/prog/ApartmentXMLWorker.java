package ua.kiev.prog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ApartmentXMLWorker {
    public static void saveToXMLFile(ApartmentList list, File file) {
        try {
            JAXBContext jaxbC = JAXBContext.newInstance(ApartmentList.class);
            Marshaller marSh = jaxbC.createMarshaller();
            marSh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marSh.marshal(list, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static ApartmentList loadFromXMLFile(File file) {
        JAXBContext jaxbC = null;
        try {
            jaxbC = JAXBContext.newInstance(ApartmentList.class);
            Unmarshaller unmarshaller = jaxbC.createUnmarshaller();
            ApartmentList list = (ApartmentList) unmarshaller.unmarshal(file);
            return list;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}