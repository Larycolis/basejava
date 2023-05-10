package com.basejava.webapp.storage;

import com.basejava.webapp.Config;
import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.ResumeTestDataBogdanova;
import com.basejava.webapp.ResumeTestDataKislin;
import com.basejava.webapp.ResumeTestDataNoName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public abstract class AbstractStorageTest {
    protected final static File STORAGE_DIR = Config.getConfig().getStorageDir();
    protected final Storage storage;

    private static final String UUID_NOT_EXIST = "dummy";
    private static final String UUID_1 = UUID.randomUUID().toString();
    private static final String UUID_2 = UUID.randomUUID().toString();
    private static final String UUID_3 = UUID.randomUUID().toString();
    private static final String UUID_4 = UUID.randomUUID().toString();

    private static final String FULL_NAME_1 = "Григорий Кислин";
    private static final String FULL_NAME_2 = "Евгения Богданова";
    private static final String FULL_NAME_3 = "Некий Никто";
    private static final String FULL_NAME_4 = "Иммануил Кант";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = ResumeTestDataKislin.createResume(UUID_1, FULL_NAME_1);
        RESUME_2 = ResumeTestDataBogdanova.createResume(UUID_2, FULL_NAME_2);
        RESUME_3 = ResumeTestDataNoName.createResume(UUID_3, FULL_NAME_3);
        RESUME_4 = ResumeTestDataNoName.createResume(UUID_4, FULL_NAME_4);
    }

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
        Resume updatedResume = ResumeTestDataNoName.createResume(UUID_1, FULL_NAME_4);
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