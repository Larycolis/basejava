package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serializer.StreamSerializerStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// searchKey - File(directory, uuid)

public class FileStorage extends AbstractStorage<File> {
    private final File directory;
    private final StreamSerializerStrategy streamSerializerStrategy;

    protected FileStorage(File directory, StreamSerializerStrategy streamSerializerStrategy) {
        Objects.requireNonNull(directory, " directory must not be null");
        this.directory = directory;
        this.streamSerializerStrategy = streamSerializerStrategy;
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
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
            streamSerializerStrategy.doWrite(resume, new BufferedOutputStream(new FileOutputStream(searchKey)));
        } catch (IOException e) {
            throw new StorageException("File write error ", resume.getUuid(), e);
        }
    }

    @Override
    protected Resume doGet(File searchKey) {
        try {
            return streamSerializerStrategy.doRead(new BufferedInputStream(new FileInputStream(searchKey)));
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
        List<Resume> result = new ArrayList<>(getFilesArray().length);
        for (File file : getFilesArray()) {
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
        for (File file : getFilesArray()) {
            doDelete(file);
        }
    }

    @Override
    public int size() {
        return getFilesArray().length;
    }

    private File[] getFilesArray() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error ");
        }
        return files;
    }
}
