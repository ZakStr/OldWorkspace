package ua.kiev.prog;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
public class Apartment {
    private int id;
    private int rooms;
    private String address;
    private int floor;
    private long prise;

    public Apartment(int id, int roomNumber, String address, int floor, long cost) {
        super();
        this.id = id;
        this.rooms = roomNumber;
        this.address = address;
        this.floor = floor;
        this.prise = cost;
    }


    public Apartment() {
        super();
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @XmlElement
    public long getPrise() {
        return prise;
    }

    public void setPrise(long prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Apartment [id=" + id + ", rooms=" + rooms + ", " + (address != null ? "address=" + address + ", " : "")
                + "floor=" + floor + ", prise=" + prise + "]";
    }


}
