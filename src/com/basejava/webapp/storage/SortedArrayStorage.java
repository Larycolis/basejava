package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

// searchKey - index

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void insertResume(Resume resume, Integer searchKey) {
        int insertionIndex = -searchKey - 1;
        System.arraycopy(storage, insertionIndex, storage, insertionIndex + 1, size - insertionIndex);
        storage[insertionIndex] = resume;
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        int numMoved = size - searchKey - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, searchKey + 1, storage, searchKey, numMoved);
        }
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Иванов Иван Иванович"); // тут проблема т.к. конструктора Resume(String uuid) больше нет
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR); // а сюда нужно подавать объект
    }

    /* Делаем код короче посредством анонимного класса
    private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
     */
}
