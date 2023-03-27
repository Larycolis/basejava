package com.basejava.webapp.storage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

//TODO: implement methods
public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;
    protected AbstractPathStorage(String dir){
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not readable/writable");
        }
    }
/*
    @Override
    protected void doSave(Resume resume, Path searchKey) {

    }

    @Override
    protected void doUpdate(Resume resume, Path searchKey) {

    }

    @Override
    protected Resume doGet(Path searchKey) throws IOException {
        return null;
    }

    @Override
    protected void doDelete(Path searchKey) {

    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Path searchKey) {
        return false;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error ", null);
        }
    }

    @Override
    public int size() {
        return 0;
    }
 */
}