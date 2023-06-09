package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        phonebook.put(name, phoneNumbers);
    }

    public void addAll(String name, String[] phoneNumbers) {
        List<String> phoneNumber = new ArrayList<>();
        for (String p : phoneNumbers) {
            phoneNumber.add(p);
        }
        phonebook.put(name, phoneNumber);
    }

    public void remove(String name) {
        List<String> names = new ArrayList<>();
        names.remove(name);
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return "Invalid Phone Number";
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        for (String name : phonebook.keySet()) {
            names.add(name);
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
