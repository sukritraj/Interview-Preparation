package com.example.lld.phoneBook;

import java.util.*;
import java.util.stream.Collectors;

public class Phonebook {

    private Map<String, Contact> contactByPhoneNumber = new HashMap<>();
    private TreeMap<String, Contact> contactByName = new TreeMap<>();

    public void addContact(Contact contact) throws Exception {
        if (contactByPhoneNumber.containsKey(contact.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone Number already exists");
        }
        if (contactByName.containsKey(contact.getName().toUpperCase())) {
            throw new IllegalArgumentException("Name already exists");
        } else {
            contactByPhoneNumber.put(contact.getPhoneNumber(), contact);
            contactByName.put(contact.getName().toUpperCase(), contact);
        }
    }

    public void editContact(String phoneNumber, String newName, String newEmail, String newAddress) {
        if(!contactByPhoneNumber.containsKey(phoneNumber)) {
            throw new IllegalArgumentException("Contact not found!");
        }
        Contact contact = contactByPhoneNumber.get(phoneNumber);
        contactByName.remove(contact.getName().toUpperCase());
        contact.setName(newName);
        contact.setEmail(newEmail);
        contact.setAddress(newAddress);
        contactByPhoneNumber.put(phoneNumber, contact);
        contactByName.put(newName.toUpperCase(), contact);
    }

    public void deleteContact(String phoneNumber) {
        if (!contactByPhoneNumber.containsKey(phoneNumber)) {
            throw new IllegalArgumentException("Contact not found!");
        }
        contactByName.remove(contactByPhoneNumber.get(phoneNumber).getName().toUpperCase());
        contactByPhoneNumber.remove(phoneNumber);
    }

    public List<Contact> searchByName(String name) {
        return contactByName.keySet().stream()
                .filter(key -> key.startsWith(name.toUpperCase()))
                .map(contactByName::get).toList();
    }

    public List<Contact> searchByPhoneNumber(String phoneNumber) {
        return contactByPhoneNumber.keySet().stream()
                .filter(key -> key.startsWith(phoneNumber))
                .map(contactByPhoneNumber::get).toList();
    }

    public List<Contact> searchByWildcard(String pattern) {
        return contactByName.keySet().stream()
                .filter(key -> key.matches(pattern))
                .map(contactByName::get).toList();
    }

    public List<Contact> getAllContactsSortedByName() {
        return contactByName.keySet()
                .stream()
                .map(contactByName::get).toList();
    }

    public List<Contact> getAllContactsSortedByPhoneNumber() {
        return contactByPhoneNumber.values().stream()
                .sorted(Comparator.comparing(Contact::getPhoneNumber))
                .collect(Collectors.toList());
    }

    public List<Contact> filterByFirstLetter(char letter) {
        return contactByName.values().stream()
                .filter(contact -> contact.getName().charAt(0) == letter)
                .collect(Collectors.toList());
    }

    public List<Contact> autoSuggest(String prefix) {
        return contactByName.keySet().stream()
                .filter(key -> key.startsWith(prefix))
                .map(contactByName::get)
                .collect(Collectors.toList());
    }


}
