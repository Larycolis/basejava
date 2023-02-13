package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    // done
    @Override
    public abstract void clear();

    // done
    @Override
    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            save(resume, index);
        }
    }

    // done
    @Override
    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            update(resume, index);
        }
    }

    // done
    @Override
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return get(index);
    }

    // done
    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            delete(index);
        }
    }

    // done
    @Override
    public abstract Resume[] getAll();

    // done
    @Override
    public abstract int size();

    protected abstract int findIndex(String uuid);

    public abstract void save(Resume resume, int index);

    public abstract void update(Resume resume, int index);

    public abstract Resume get(int index);

    public abstract void delete(int index);
}
