package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveNewObject(Resume resume, int index) {
        index = size;
        storage[index] = resume;
    }

    @Override
    protected void deleteObject(int index) {
        storage[index] = storage[size - 1];
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
