package AdressBookSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uc3 {


        private String name;
        private String phoneNumber;
        private String email;

        public void Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public class ContactManager {
        public static void main(String[] args) {
            List<Contact> contacts = new ArrayList<>();
            contacts.add(new Contact("John Doe", "123-456-7890", "john@example.com"));
            contacts.add(new Contact("Jane Smith", "987-654-3210", "jane@example.com"));

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter the name of the contact to edit (or 'quit' to exit): ");
                String nameToEdit = scanner.nextLine();

                if (nameToEdit.equalsIgnoreCase("quit")) {
                    break;
                }

                // Use Java Streams to find the contact by name
                Contact contactToEdit = contacts.stream()
                        .filter(contact -> contact.getName().equalsIgnoreCase(nameToEdit))
                        .findFirst()
                        .orElse(null);

                if (contactToEdit != null) {
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    contactToEdit.setPhoneNumber(newPhoneNumber);

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    contactToEdit.setEmail(newEmail);

                    System.out.println("Contact updated successfully.");
                } else {
                    System.out.println("Contact not found.");
                }
            }
        }
    }

}
