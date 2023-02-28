package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.List;

// TODO refactoring
public interface Storage {
    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

//    return list sorted by fullName
    List<Resume> getAllSorted();
    Resume[] getAll();
    int size();
}
