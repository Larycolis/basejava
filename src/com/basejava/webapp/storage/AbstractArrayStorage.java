package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume, int index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Error: storage overflow and can't hold ", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    public void update(Resume resume, int index) {
        storage[index] = resume;
    }

    public Resume get(int index) {
        return storage[index];
    }

    public void delete(int index) {
        deleteResume(index);
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void deleteResume(int index);

    protected abstract int findIndex(String uuid);
}
