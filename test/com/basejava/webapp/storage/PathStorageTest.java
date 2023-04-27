package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectStreamSerializerStrategy;

public class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializerStrategy()));
    }
}