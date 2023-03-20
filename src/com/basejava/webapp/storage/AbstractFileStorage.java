package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// searchKey - File(directory, uuid)

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected void doSave(Resume resume, File searchKey) {
        try {
            searchKey.createNewFile();
            doWrite(resume, searchKey);
        } catch (IOException e) {
            throw new StorageException("IO Exception: ", searchKey.getName(), e);
        }
    }

    @Override
    protected void doUpdate(Resume resume, File searchKey) {
        try {
            doWrite(resume, searchKey);
        } catch (IOException e) {
            throw new StorageException("IO Exception: ", searchKey.getName(), e);
        }
    }

    @Override
    protected Resume doGet(File searchKey) {
        try {
            return doRead(searchKey);
        } catch (IOException e) {
            throw new StorageException("IO Exception: ", searchKey.getName(), e);
        }
    }

    @Override
    protected void doDelete(File searchKey) {
        searchKey.delete();
    }

    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> result;
        File[] files = directory.listFiles();
        assert files != null;
        result = new ArrayList<>(files.length);
        try {
            for (File file : files) {
                result.add(doRead(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File searchKey) {
        return searchKey.exists();
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        assert files != null;
        return files.length;
    }

    protected abstract void doWrite(Resume resume, File searchKey) throws IOException; // пока нет реализации метода

    protected abstract Resume doRead(File searchKey) throws IOException; // пока нет реализации метода
}
