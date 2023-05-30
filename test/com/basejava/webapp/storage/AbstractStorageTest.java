package com.basejava.webapp.storage;

import com.basejava.webapp.Config;
import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.model.ContactType;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.basejava.webapp.TestData.*;

public abstract class AbstractStorageTest {
    protected final static File STORAGE_DIR = Config.getConfig().getStorageDir();
    protected final Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        List<Resume> actual = storage.getAllSorted();
        Resume[] expected = new Resume[0];
        Assert.assertEquals(expected.length, actual.size());
    }

    @Test
    public void save() throws IOException {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test
    public void update() throws IOException {
        Resume updatedResume = new Resume(UUID_1, "Updated name");
        RESUME_1.setContact(ContactType.EMAIL, "update@email.com");
        RESUME_1.setContact(ContactType.SKYPE, "update Skype");
        RESUME_1.setContact(ContactType.CELLPHONE, "+8569852147");
        storage.update(updatedResume);
        Assert.assertEquals(updatedResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resumeUpdate = new Resume(UUID_4);
        storage.update(resumeUpdate);
    }

    @Test
    public void get() throws IOException {
        assertGet(RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws IOException {
        storage.get(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws IOException {
        storage.delete(UUID_1);
        assertSize(2);
        assertGet(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }

    // not for MapUuidStorageTest
    @Test
    public void getAllSorted() {
        List<Resume> expected = new ArrayList<>(Arrays.asList(RESUME_1, RESUME_2, RESUME_3));
        List<Resume> actual = storage.getAllSorted();
        Collections.sort(expected);
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) throws IOException {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}