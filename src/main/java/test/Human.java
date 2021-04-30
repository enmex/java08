package test;
import java.io.Serializable;
import java.util.Objects;
public class Human extends BaseHuman {
    private String name;
    private String surname;
    private String middleName;
    private String birthDate;
    public Human(){}
    public Human(String name, String surname, String middleName, String birthDate){
        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public String getFullName(){
        return surname + " " + name + " " + middleName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Lodgings.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, middleName, birthDate);
    }
}
