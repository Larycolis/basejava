package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.*;
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
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + searchKey.getAbsolutePath(), searchKey.getName(), e);
        }
        doUpdate(resume, searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, File searchKey) {
        try {
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(searchKey)));
        } catch (IOException e) {
            throw new StorageException("File write error ", resume.getUuid(), e);
        }
    }

    @Override
    protected Resume doGet(File searchKey) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(searchKey)));
        } catch (IOException e) {
            throw new StorageException("File read error ", searchKey.getName(), e);
        }
    }

    @Override
    protected void doDelete(File searchKey) {
        if (!searchKey.delete()) {
            throw new StorageException("File delete error ", searchKey.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error ", null);
        }
        List<Resume> result = new ArrayList<>(files.length);
        for (File file : files) {
            result.add(doGet(file));
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
        if (files != null) {
            for (File file : files) {
                doDelete(file);
            }
        }
    }

    @Override
    public int size() {
        String[] files = directory.list();
        if (files == null) {
            throw new StorageException("Directory read error ", null);
        }
        return files.length;
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;
}
