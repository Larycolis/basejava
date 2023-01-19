package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveNewObject(Resume resume) {
        System.out.println("Method not implemented yet");
    }

    @Override
    protected void deleteObject(String uuid, int index) {
        System.out.println("Method not implemented yet");
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
