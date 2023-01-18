package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
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

    protected abstract int findIndex(String uuid);

    protected abstract void printNotFoundMessage(String uuid);
}
