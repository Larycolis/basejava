package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.io.IOException;
import java.util.List;

public interface Storage {
    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid) throws IOException;

    void delete(String uuid);

    List<Resume> getAllSorted();

    int size();
}
