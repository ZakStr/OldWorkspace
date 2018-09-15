package ua.kiev.prog;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ApartmentList {
    @XmlElement(name = "apartment")
    private ArrayList<Apartment> list = new ArrayList<>();

    public ApartmentList() {
        super();
    }

    public ArrayList<Apartment> getList() {
        return new ArrayList<Apartment>(list);
    }

    public void add(Apartment ap) {
        int i = 0;
        for (Apartment apartment : list) {
            if (apartment == ap) {
                i++;
            }
        }

        if (i == 0) {
            list.add(ap);
        }
    }

    public void change(int id, long prise) {
        for (Apartment apartment : list) {
            if (apartment.getId() == id) {
                apartment.setPrise(prise);
            }
        }
    }

    public void delete(int id) {
        for (Apartment apartment : list) {
            if (apartment.getId() == id) {
                list.remove(apartment);
            }
        }
    }

    public ApartmentList priseRange(long start, long end) {
        ApartmentList list2 = new ApartmentList();

        for (Apartment apartment : list) {
            if (apartment.getPrise() >= start && apartment.getPrise() <= end || apartment.getPrise() >= start && (end == 0) || (start == 0) && apartment.getPrise() <= end) {
                list2.add(apartment);
            }
        }
        return list2;
    }

    public ApartmentList roomNumber(int number) {
        ApartmentList list2 = new ApartmentList();
        for (Apartment apartment : list) {
            if (apartment.getRooms() == number) {
                list2.add(apartment);
            }
        }
        return list2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Apartment apartment : list) {
            sb.append(apartment).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
