package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    // Done
    @Test(expected = StorageException.class)
    public void saveOverflow() {
        storage.clear();
        try {
            for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT - 1; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }
}