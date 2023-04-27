package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectStreamSerializerStrategy;

import java.io.File;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(new File(STORAGE_DIR.getAbsolutePath()), new ObjectStreamSerializerStrategy()));
    }
}