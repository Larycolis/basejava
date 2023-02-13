package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    public void update(Resume resume, int index) {
        storage.set(index, resume);
    }

    @Override
    public Resume get(int index) {
        return storage.get(index);
    }

    @Override
    public void delete(int index) {
        storage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        Resume[] results = new Resume[storage.size()];
        results = storage.toArray(results);
        return results;
    }

    @Override
    public int size() {
        return storage.size();
    }

    protected int findIndex(String uuid) {
        for (Resume resume : storage) {
            if (uuid.equals(resume.getUuid())) {
                return storage.indexOf(resume);
            }
        }
        return -1;
    }
}
