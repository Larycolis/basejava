package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveNewObject(Resume resume, int index) {
        System.out.println("Method not implemented yet");
        // use method System.arraycopy();
    }

    @Override
    protected void deleteObject(int index) {
        System.out.println("Method not implemented yet");
        // use method System.arraycopy();
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
