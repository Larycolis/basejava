package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;
//    private Resume resume = new Resume();

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /*    public void fill() {
     *        Arrays.fill(storage, 0, storage.length, resume);
     *        for (int i = 0; i < storage.length; i++) {
     *            if (storage[i] == resume) {
     *                size++;
     *            }
     *        }
     *        System.out.println(size);
     *    }
     */

    public void save(Resume resume) {
        if (!Arrays.asList(storage).contains(resume)) {
            if (size < storage.length) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("error: " + "the storage is full and can't hold " + resume.getUuid());
            }
        } else {
            System.out.println("error: " + resume.getUuid() + " is already stored in storage");
        }
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.getUuid().equals(storage[i].getUuid())) {
                storage[i] = resume;
                break;
            } else {
                System.out.println("error: " + resume.getUuid() + " is not found in storage");
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        System.out.println("error: " + uuid + " is not found in storage");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            } else {
                System.out.println("error: " + uuid + " is not found in storage");
            }
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
}
