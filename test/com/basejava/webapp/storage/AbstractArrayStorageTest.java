package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final Resume RESUME_1 = new Resume("uuid1");
    private static final Resume RESUME_2 = new Resume("uuid2");
    private static final Resume RESUME_3 = new Resume("uuid3");

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
    }

    @Test
    public void clear() {
        storage.clear();
        sizeAssert(0);
    }

    @Test
    public void save() {
        storage.save(RESUME_3);
        sizeAssert(3);
        getAssert(RESUME_3);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 3; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(RESUME_3);
    }

    @Test
    public void update() {
        Resume resumeUpdate = new Resume(RESUME_1.getUuid());
        storage.update(resumeUpdate);
        Assert.assertSame(resumeUpdate, storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resumeUpdate = new Resume(RESUME_3.getUuid());
        storage.update(resumeUpdate);
    }

    @Test
    public void get() {
        getAssert(RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        storage.delete(RESUME_1.getUuid());
        sizeAssert(1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] allResume = storage.getAll();
        Assert.assertEquals(2, allResume.length);
    }

    @Test
    public void size() throws Exception {
        sizeAssert(2);
    }

    private void sizeAssert(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void getAssert(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}