package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index != -1) {
            System.out.println("Error: " + resume.getUuid() + " is already stored in storage");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Error: storage overflow and can't hold " + resume.getUuid());
        } else {
            saveNewObject(resume);
            size++;
        }
    }

    protected abstract void saveNewObject(Resume resume);

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            printNotFoundMessage(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            printNotFoundMessage(uuid);
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            printNotFoundMessage(uuid);
        } else {
            deleteObject(uuid, index);
            size--;
        }
    }

    protected abstract void deleteObject(String uuid, int index);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findIndex(String uuid);

    protected void printNotFoundMessage(String uuid) {
        System.out.printf("\nError: %s is not found in storage\n", uuid);
    }
}