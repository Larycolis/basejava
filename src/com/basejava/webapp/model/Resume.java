package com.basejava.webapp.model;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;
    private String fullName;

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String uuid, String fullName) {
        if (uuid == null || uuid.equals("")){
            this.uuid = UUID.randomUUID().toString();
        } else {
            this.uuid = uuid;
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

/* класс Resume больше не реализует Comparable<Resume>, класс SortedArrayStorage реализует его в анонимном классе
   @Override
   public int compareTo(Resume resume) {
        return uuid.compareTo(resume.uuid);
    }
 */
}
