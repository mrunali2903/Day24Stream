package AdressBookSystem;

import java.util.ArrayList;
import java.util.List;

class Contact {
    private String name;
    private String email;
    private String phoneNumber;

    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone Number: " + phoneNumber;
    }
}

class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        contacts.stream().forEach(contact -> System.out.println(contact));
    }
}

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        
        // Adding some sample contacts
        addressBook.addContact(new Contact("John Doe", "john@example.com", "123-456-7890"));
        addressBook.addContact(new Contact("Alice Smith", "alice@example.com", "987-654-3210"));
        addressBook.addContact(new Contact("Bob Johnson", "bob@example.com", "555-555-5555"));
        
        System.out.println("Welcome to Address Book");
        System.out.println("Contacts:");
        addressBook.displayContacts();
    }
}
