package AdressBookSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}

public class DeletePerson {
    public static void main(String[] args) {
        // Create a list of people
        ArrayList<Person> people = new ArrayList<>();

        // Add some people to the list
        people.add(new Person("Alice"));
        people.add(new Person("Bob"));
        people.add(new Person("Charlie"));

        // Name of the person you want to delete
        String personNameToDelete = "Bob";

        // Iterate through the list to find and delete the person with the specified name
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName().equals(personNameToDelete)) {
                iterator.remove(); // This will remove the person from the list
                System.out.println("Deleted: " + person);
            }
        }

        // Print the updated list
        System.out.println("Updated List of People:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
