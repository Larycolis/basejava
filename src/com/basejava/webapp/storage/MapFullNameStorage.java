package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.List;

public class MapFullNameStorage extends AbstractStorage {
    @Override
    protected void doSave(Resume resume, Object searchKey) {

    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
