/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (uuid.equals(String.valueOf(resume))) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(String.valueOf(storage[i]))) {
                storage[i] = null;
            }
        }
        for (int i = 0; i < storage.length; i++) {
            for (int j = i + 1; j < storage.length; j++) {
                if (storage[i] == null && storage[j] != null) {
                    storage[i] = storage[j];
                    storage[j] = null;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                result[i] = storage[i];
            }
        }
        return result;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }
}
