package lesson3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    HashMap<String, HashSet<String>> book;

    public PhoneBook(int initialCapacity) {
        book = new HashMap<>(initialCapacity);
    }

    public void add(String surname, String phoneNumber) {
        HashSet<String> phoneNumbers = book.get(surname);
        if (phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            book.put(surname, phoneNumbers);
        } else {
            phoneNumbers.add(phoneNumber);
        }
    }

    public HashSet<String> get(String surname) {
        return book.get(surname);
    }
}
