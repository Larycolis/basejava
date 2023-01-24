package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveNewObject(Resume resume, int index) {
        System.arraycopy(storage, (-index - 1), storage, (-index - 1) + 1, size - (-index - 1));
        storage[-index - 1] = resume;
    }

    @Override
    protected void deleteObject(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
