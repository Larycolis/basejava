package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(ABSOLUTE_PATH, new XmlStreamSerializer()));
    }
}
