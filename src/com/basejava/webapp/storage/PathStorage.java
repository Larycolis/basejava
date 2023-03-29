package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serializationStrategy.SerializationStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// searchKey - Paths.get(dir)
public class PathStorage extends AbstractStorage<Path> {
    private final Path directory;
    private final SerializationStrategy serializationStrategy;

    protected PathStorage(String dir, SerializationStrategy serializationStrategy) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not readable/writable");
        }
        this.serializationStrategy = serializationStrategy;
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
            serializationStrategy.doWrite(resume, new BufferedOutputStream(new FileOutputStream(searchKey.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path write error ", resume.getUuid(), e);
        }
    }

    @Override
    protected Resume doGet(Path searchKey) {
        try {
            return serializationStrategy.doRead(new BufferedInputStream(new FileInputStream(searchKey.toFile())));
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
}