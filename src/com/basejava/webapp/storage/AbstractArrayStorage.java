package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void doSave(Resume resume, Integer searchKey) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Error: storage overflow and can't hold ", resume.getUuid());
        } else {
            insertResume(resume, searchKey);
            size++;
        }
    }

    protected void doUpdate(Resume resume, Integer searchKey) {
        storage[searchKey] = resume;
    }

    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    protected void doDelete(Integer searchKey) {
        deleteResume(searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    protected abstract void insertResume(Resume resume, Integer searchKey);

    protected abstract void deleteResume(Integer searchKey);

    protected abstract Integer getSearchKey(String uuid);
}