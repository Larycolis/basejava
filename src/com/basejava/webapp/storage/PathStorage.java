package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serializer.StreamSerializerStrategy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
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
    private final StreamSerializerStrategy streamSerializerStrategy;

    protected PathStorage(String dir, StreamSerializerStrategy streamSerializerStrategy) {
        Objects.requireNonNull(dir, "directory must not be null");
        directory = Paths.get(dir);
        this.streamSerializerStrategy = streamSerializerStrategy;
        if (!Files.isDirectory(directory) || !Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not readable/writable");
        }
    }

    @Override
    protected void doSave(Resume resume, Path searchKey) {
        try {
            Files.createFile(searchKey);
        } catch (IOException e) {
            throw new StorageException("Couldn't create path " + searchKey, getFileName(searchKey), e);
        }
        doUpdate(resume, searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, Path searchKey) {
        try {
            streamSerializerStrategy.doWrite(resume, new BufferedOutputStream(Files.newOutputStream(searchKey)));
        } catch (IOException e) {
            throw new StorageException("Path write error ", resume.getUuid(), e);
        }
    }

    @Override
    protected Resume doGet(Path searchKey) {
        try {
            return streamSerializerStrategy.doRead(new BufferedInputStream(Files.newInputStream(searchKey)));
        } catch (IOException e) {
            throw new StorageException("Path read error", getFileName(searchKey), e);
        }
    }

    @Override
    protected void doDelete(Path searchKey) {
        try {
            Files.delete(searchKey);
        } catch (IOException e) {
            throw new StorageException("Path delete error ", getFileName(searchKey), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        return getFilesList().map(this::doGet).collect(Collectors.toList());
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
        getFilesList().forEach(this::doDelete);
    }

    @Override
    public int size() {
        return (int) getFilesList().count();
    }

    private String getFileName(Path path) {
        return path.getFileName().toString();
    }

    private Stream<Path> getFilesList() {
        Stream<Path> files;
        try {
            files = Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error ", e);
        }
        return files;
    }
}