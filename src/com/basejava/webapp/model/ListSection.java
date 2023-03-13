package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private final List<String> sectionContent;

    public ListSection(List<String> sectionContent) {
        Objects.requireNonNull(sectionContent, "section content must not be null");
        this.sectionContent = sectionContent;
    }

    public List<String> getSectionContent() {
        return sectionContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return sectionContent.equals(that.sectionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionContent);
    }

    @Override
    public String toString() {
        return "" + sectionContent;
    }
}