package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStorage extends AbstractStorage {
    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.put((String) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((String) searchKey);
    }

    // TODO: тест не проходит, нужно исправить реализацию метода getAll
    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    /*
     * реализация метода на данный момент ошибочная. дебагер показал, что key uuid1 сохраняется в хранилище как null
     * key должен быть уникальным (предполагается, что в key сохранится uuid), но следующее резюме тоже сохраняется с
     * key = null, поэтому падает ошибка "Resume [uuid] already exist"
     * TODO: сделать так, чтобы в key сохранялся uuid
     */
    protected String getSearchKey(String uuid) {
        Set<Map.Entry<String, Resume>> entries = storage.entrySet();
        for (Map.Entry<String, Resume> pair : entries) {
            String searchKey = pair.getKey();
            if (uuid.equals(searchKey)) {
                return searchKey;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey((String) searchKey);
    }
}
