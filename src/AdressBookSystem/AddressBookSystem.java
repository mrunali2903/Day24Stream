package AdressBookSystem;

import java.util.*;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class AddressBook {
    private String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(String name, String phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
    }
}

public class AddressBookSystem {
    private Map<String, AddressBook> addressBooks;

    public AddressBookSystem() {
        addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name) {
        addressBooks.put(name, new AddressBook(name));
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void addContactToAddressBook(String addressBookName, String name, String phoneNumber) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.addContact(name, phoneNumber);
        } else {
            System.out.println("Address Book with that name does not exist.");
        }
    }

    public static void main(String[] args) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();

        // Adding new Address Books
        addressBookSystem.addAddressBook("Family");
        addressBookSystem.addAddressBook("Friends");

        // Adding contacts to Address Books
        addressBookSystem.addContactToAddressBook("Family", "John Doe", "123-456-7890");
        addressBookSystem.addContactToAddressBook("Friends", "Alice Smith", "987-654-3210");

        // Retrieve and print contacts from Address Books
        AddressBook familyAddressBook = addressBookSystem.getAddressBook("Family");
        if (familyAddressBook != null) {
            List<Contact> familyContacts = familyAddressBook.getContacts();
            System.out.println("Family Address Book Contacts:");
            for (Contact contact : familyContacts) {
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
            }
        }

        AddressBook friendsAddressBook = addressBookSystem.getAddressBook("Friends");
        if (friendsAddressBook != null) {
            List<Contact> friendsContacts = friendsAddressBook.getContacts();
            System.out.println("Friends Address Book Contacts:");
            for (Contact contact : friendsContacts) {
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
            }
        }
    }
}
