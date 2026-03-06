package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    private HashMap<String, ArrayList<String>> directory;

    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }
    public void add(String surname, String phone) {

        ArrayList<String> phones = directory.get(surname);
        if (phones == null) {
            phones = new ArrayList<>();
            directory.put(surname, phones);
        }
        phones.add(phone);
    }
    public ArrayList<String> get(String surname) {
        // Возвращаем копию списка или пустой список, чтобы избежать изменений извне
        return directory.get(surname);
    }
}
