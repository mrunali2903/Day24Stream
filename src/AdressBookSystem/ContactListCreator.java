package AdressBookSystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactListCreator {
    public static void main(String[] args) {
        // Create a list of contacts using Java streams
        List<Contact> contacts = Stream.of(
            new Contact("John", "Doe", "123 Main St", "Anytown", "CA", "12345", "555-555-5555", "john.doe@email.com"),
            new Contact("Jane", "Smith", "456 Elm St", "Othercity", "NY", "67890", "555-123-4567", "jane.smith@email.com"),
            // Add more contacts here
        ).collect(Collectors.toList());

        // Print the list of contacts
        contacts.forEach(contact -> System.out.println(contact.toString()));
    }
}