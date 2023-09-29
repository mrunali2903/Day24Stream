package AdressBookSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private String city;
    private String state;
    private String zip;

    public Person(String name, String city, String state, String zip) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return name + " - " + city + ", " + state + " " + zip;
    }
}

public class AddressBook {
    public static void main(String[] args) {
        List<Person> addressBook = new ArrayList<>();

        // Populate the address book with persons

        // Sort by City
        sortByCity(addressBook);
        
        // Sort by State
        sortByState(addressBook);
        
        // Sort by Zip
        sortByZip(addressBook);
    }

    public static void sortByCity(List<Person> addressBook) {
        Collections.sort(addressBook, Comparator.comparing(Person::getCity));
        printAddressBook(addressBook, "Sorted by City");
    }

    public static void sortByState(List<Person> addressBook) {
        Collections.sort(addressBook, Comparator.comparing(Person::getState));
        printAddressBook(addressBook, "Sorted by State");
    }

    public static void sortByZip(List<Person> addressBook) {
        Collections.sort(addressBook, Comparator.comparing(Person::getZip));
        printAddressBook(addressBook, "Sorted by Zip");
    }

    public static void printAddressBook(List<Person> addressBook, String message) {
        System.out.println(message);
        for (Person person : addressBook) {
            System.out.println(person);
        }
    }
}
