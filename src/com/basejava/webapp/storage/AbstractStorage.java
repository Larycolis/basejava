package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Comparator<Resume> RESUME_NAME_UUID_COMPARATOR = Comparator.comparing(Resume::getFullName)
            .thenComparing(Resume::getUuid);

    @Override
    public final void save(Resume resume) {
        SK searchKey = getNotExistingSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public final void update(Resume resume) {
        SK searchKey = getExistingSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public final Resume get(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public final void delete(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resultList = doCopyAll();
        resultList.sort(RESUME_NAME_UUID_COMPARATOR);
        return resultList;
    }

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract List<Resume> doCopyAll();

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    private SK getExistingSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistingSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
