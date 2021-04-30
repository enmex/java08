package test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
public class Flat implements Serializable {
    private ArrayList<Human> personList;
    private int square;
    private int number;

    public Flat(){}

    public Flat(ArrayList<Human> personList, int square, int number) {
        this.personList = personList;
        this.square = square;
        this.number = number;
    }
    public Flat(Human person, int square, int number){
        personList = new ArrayList<>(1);
        personList.add(person);
        this.square = square;
        this.number = number;
    }

    public ArrayList<Human> getPersonList() {
        return personList;
    }

    public String getPersonListString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Human person : personList){
            stringBuilder.append(person.getFullName()  + " " + person.getBirthDate() + ",");
        }
        if(personList.size() == 0){
            return stringBuilder.toString();
        }
        return stringBuilder.toString().substring(0, stringBuilder.length()-1);
    }

    public int getSquare() {
        return square;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Lodgings.Flat{" +
                "personList=" + personList +
                ", square=" + square +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return Double.compare(flat.square, square) == 0 && number == flat.number && Objects.equals(personList, flat.personList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personList, square, number);
    }
}
