package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// searchKey - Paths.get(dir)
public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not readable/writable");
        }
    }

    @Override
    protected void doSave(Resume resume, Path searchKey) {
        try {
            Files.createFile(searchKey);
        } catch (IOException e) {
            throw new StorageException("Couldn't create path " + searchKey.toAbsolutePath(), searchKey.getFileName().toString(), e);
        }
        doUpdate(resume, searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, Path searchKey) {
        try {
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(searchKey.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path write error ", resume.getUuid(), e);
        }
    }

    @Override
    protected Resume doGet(Path searchKey) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(searchKey.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path read error", searchKey.getFileName().toString(), e);
        }

    }

    @Override
    protected void doDelete(Path searchKey) {
        try {
            Files.delete(searchKey);
        } catch (IOException e) {
            throw new StorageException("Path delete error ", searchKey.getFileName().toString(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        try {
            Stream<Path> result = Files.list(directory);
            return result.map(this::doGet).collect(Collectors.toList());
        } catch (IOException e) {
            throw new StorageException("Path read error", null, e);
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected boolean isExist(Path searchKey) {
        return Files.exists(searchKey);
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error ", null, e);
        }
    }

    @Override
    public int size() {
        try {
            long size = Files.list(directory).count();
            return (int) size;
        } catch (IOException e) {
            throw new StorageException("Path read error ", null, e);
        }
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;
}