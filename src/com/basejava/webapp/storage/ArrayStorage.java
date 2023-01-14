package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (!Arrays.asList(storage).contains(resume)) {
            if (size < storage.length) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("Error: the storage is full and can't hold " + resume.getUuid());
            }
        } else {
            System.out.println("Error: " + resume.getUuid() + " is already stored in storage");
        }
    }

    public void update(Resume resume) {
        index = findIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            throwNotFoundError(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        index = findIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            throwNotFoundError(uuid);
            return null;
        }
    }

    public void delete(String uuid) {
        index = findIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            throwNotFoundError(uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    private void throwNotFoundError(String uuid) {
        System.out.printf("\nError: %s is not found in storage\n", uuid);
    }
}
