package AdressBookSystem;

import java.util.*;

public class PersonManager {
    private Map<String, List<Person>> cityToPersons;
    private Map<String, List<Person>> stateToPersons;

    public PersonManager() {
        cityToPersons = new HashMap<>();
        stateToPersons = new HashMap<>();
    }

    public void addPerson(String name, int age, String city, String state) {
        Person person = new Person(name, age);

        cityToPersons
            .computeIfAbsent(city, k -> new ArrayList<>())
            .add(person);

        stateToPersons
            .computeIfAbsent(state, k -> new ArrayList<>())
            .add(person);
    }

    public List<Person> getPersonsByCity(String city) {
        return cityToPersons.getOrDefault(city, Collections.emptyList());
    }

    public List<Person> getPersonsByState(String state) {
        return stateToPersons.getOrDefault(state, Collections.emptyList());
    }

    public static void main(String[] args) {
        PersonManager manager = new PersonManager();

        // Adding persons
        manager.addPerson("Alice", 30, "New York", "NY");
        manager.addPerson("Bob", 25, "Los Angeles", "CA");
        manager.addPerson("Charlie", 35, "New York", "NY");
        manager.addPerson("David", 40, "Chicago", "IL");

        // Viewing persons by city
        System.out.println("Persons in New York:");
        manager.getPersonsByCity("New York").forEach(System.out::println);

        // Viewing persons by state
        System.out.println("\nPersons in New York (NY):");
        manager.getPersonsByState("NY").forEach(System.out::println);
    }
}
