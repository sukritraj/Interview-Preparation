package com.example.lld.phoneBook;

import java.util.*;

public class PhonebookApp {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhonebook Application");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts (Sorted by Name)");
            System.out.println("5. Display All Contacts (Sorted by Phone Number)");
            System.out.println("6. Search by Name");
            System.out.println("7. Search by Phone Number");
            System.out.println("8. Search by Wildcard");
            System.out.println("9. Filter by First Letter");
            System.out.println("10. AutoSuggest");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter Email (optional): ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Address (optional): ");
                        String address = scanner.nextLine();
                        phonebook.addContact(new Contact(name, phoneNumber, email, address));
                        System.out.println("Contact added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Phone Number of the contact to edit: ");
                        String editPhoneNumber = scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter New Address: ");
                        String newAddress = scanner.nextLine();
                        phonebook.editContact(editPhoneNumber, newName, newEmail, newAddress);
                        System.out.println("Contact updated successfully!");
                        break;

                    case 3:
                        System.out.print("Enter Name or Phone Number to delete: ");
                        String identifier = scanner.nextLine();
                        phonebook.deleteContact(identifier);
                        System.out.println("Contact deleted successfully!");
                        break;

                    case 4:
                        System.out.println("All Contacts (Sorted by Name):");
                        phonebook.getAllContactsSortedByName().forEach(System.out::println);
                        break;

                    case 5:
                        System.out.println("All Contacts (Sorted by Phone Number):");
                        phonebook.getAllContactsSortedByPhoneNumber().forEach(System.out::println);
                        break;

                    case 6:
                        System.out.print("Enter Name to search: ");
                        String searchName = scanner.nextLine();
                        phonebook.searchByName(searchName).forEach(System.out::println);
                        break;

                    case 7:
                        System.out.print("Enter Phone Number to search: ");
                        String searchPhoneNumber = scanner.nextLine();
                        phonebook.searchByPhoneNumber(searchPhoneNumber).forEach(System.out::println);
                        break;

                    case 8:
                        System.out.print("Enter Wildcard Pattern (e.g., Jo*): ");
                        String wildcardPattern = scanner.nextLine();
                        phonebook.searchByWildcard(wildcardPattern).forEach(System.out::println);
                        break;

                    case 9:
                        System.out.print("Enter First Letter to filter: ");
                        char letter = scanner.nextLine().charAt(0);
                        phonebook.filterByFirstLetter(letter).forEach(System.out::println);
                        break;

                    case 10:
                        System.out.print("Enter Prefix for AutoSuggest: ");
                        String prefix = scanner.nextLine();
                        phonebook.autoSuggest(prefix).forEach(System.out::println);
                        break;

                    case 11:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
