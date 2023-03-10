package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

// searchKey - index

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Resume resume, Integer searchKey) {
        searchKey = size;
        storage[searchKey] = resume;
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        storage[searchKey] = storage[size - 1];
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
