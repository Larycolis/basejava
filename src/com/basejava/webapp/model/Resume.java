package com.basejava.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private final String uuid; // Unique identifier
    private final String fullName;

    private final Map<ContactType, String> contacts = new EnumMap<ContactType, String>(ContactType.class);

    private final Map<SectionType, AbstractSection> sections = new EnumMap<SectionType, AbstractSection>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContacts(ContactType ct) {
        return contacts.get(ct);
    }

    public AbstractSection getSections(SectionType st) {
        return sections.get(st);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
/* класс Resume больше не реализует Comparable<Resume>, класс SortedArrayStorage реализует его в анонимном классе
   @Override
   public int compareTo(Resume resume) {
        return uuid.compareTo(resume.uuid);
    }
 */
}
