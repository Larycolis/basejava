package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.model.ResumeTestData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    protected final static String ABSOLUTE_PATH = "C:\\Users\\Евгения\\IdeaProjects\\basejava\\basejava\\storage";
    protected final Storage storage;

    private static final String UUID_NOT_EXIST = "dummy";
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String FULL_NAME_1 = "Иванов Иван Иванович";
    private static final String FULL_NAME_2 = "Петров Петр Петрович";
    private static final String FULL_NAME_3 = "Сидоров Сидор Сидорович";
    private static final String FULL_NAME_4 = "Кант Вольдемар Имануилович";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = ResumeTestData.createResume(UUID_1, FULL_NAME_1);
        RESUME_2 = ResumeTestData.createResume(UUID_2, FULL_NAME_2);
        RESUME_3 = ResumeTestData.createResume(UUID_3, FULL_NAME_3);
        RESUME_4 = ResumeTestData.createResume(UUID_4, FULL_NAME_4);
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
        Resume updatedResume = new Resume(UUID_1, FULL_NAME_4);
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