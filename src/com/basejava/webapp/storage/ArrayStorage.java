package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (findIndex(resume.getUuid()) != -1) {
            System.out.println("Error: " + resume.getUuid() + " is already stored in storage");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Error: storage overflow and can't hold " + resume.getUuid());
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            printNotFoundMessage(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            printNotFoundMessage(uuid);
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    protected void printNotFoundMessage(String uuid) {
        System.out.printf("\nError: %s is not found in storage\n", uuid);
    }
}
