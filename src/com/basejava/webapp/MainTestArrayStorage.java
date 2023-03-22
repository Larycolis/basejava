package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.SortedArrayStorage;
import com.basejava.webapp.storage.Storage;

import java.io.IOException;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private final static Storage ARRAY_STORAGE = new SortedArrayStorage(); // new MapUuidStorage(); // new ListStorage(); // new ArrayStorage(); // new MapResumeStorage(); //

    public static void main(String[] args) throws IOException {
        final Resume r1 = new Resume("uuid1", "Иванов Иван Иванович");
        final Resume r2 = new Resume("uuid2", "Петров Петр Петрович");
        final Resume r3 = new Resume("uuid3", "Сидоров Сидор Сидорович");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

//        check binarySearch
//        System.out.println("Index of r3: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r3));

        printAll();
        ARRAY_STORAGE.update(r2);
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}