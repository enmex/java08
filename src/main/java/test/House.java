package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
public class House {
    private String number;
    private String address;
    private Human housekeeper;
    private ArrayList<Flat> flats;

    public House(){
    }

    public House(String number, String address, Human housekeeper, int sumOfFlats){
        this.number = number;
        this.address = address;
        this.housekeeper = housekeeper;
        flats = new ArrayList<>(sumOfFlats);
    }
    public void addFlat(Flat flat){
        flats.add(flat);
    }

    public void setFlats(List<Flat> flats){
        this.flats = new ArrayList<>(flats);
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public Human getHousekeeper() {
        return housekeeper;
    }

    public ArrayList<Flat> getFlats() {
        return flats;
    }

    @Override
    public String toString() {
        return "Lodgings.House{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", housekeeper=" + housekeeper +
                ", flats=" + flats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return number.equals(house.number) && address.equals(house.address) && housekeeper.equals(house.housekeeper) && flats.equals(house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, address, housekeeper, flats);
    }
}
