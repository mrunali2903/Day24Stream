package AdressBookSystem;

import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private String city;
    private String state;

    public Person(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}

class AddressBook {
    private List<Person> people;

    public AddressBook(List<Person> people) {
        this.people = people;
    }

    public List<Person> searchByCity(String city) {
        return people.stream()
                .filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Person> searchByState(String state) {
        return people.stream()
                .filter(person -> person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
}

public class AddressBookSearch {
    public static void main(String[] args) {
        // Create multiple AddressBooks
        AddressBook addressBook1 = new AddressBook(List.of(
            new Person("John", "New York", "NY"),
            new Person("Alice", "Los Angeles", "CA"),
            new Person("Bob", "New York", "NY")
        ));

        AddressBook addressBook2 = new AddressBook(List.of(
            new Person("Eve", "San Francisco", "CA"),
            new Person("Charlie", "Los Angeles", "CA"),
            new Person("David", "Chicago", "IL")
        ));

        // Search for people in a specific city or state
        String cityToSearch = "New York";
        String stateToSearch = "CA";

        List<Person> peopleInCity = List.of(addressBook1, addressBook2).stream()
                .flatMap(addressBook -> addressBook.searchByCity(cityToSearch).stream())
                .collect(Collectors.toList());

        List<Person> peopleInState = List.of(addressBook1, addressBook2).stream()
                .flatMap(addressBook -> addressBook.searchByState(stateToSearch).stream())
                .collect(Collectors.toList());

        // Display search results
        System.out.println("People in " + cityToSearch + ":");
        peopleInCity.forEach(person -> System.out.println(person.getName()));

        System.out.println("\nPeople in " + stateToSearch + ":");
        peopleInState.forEach(person -> System.out.println(person.getName()));
    }
}
