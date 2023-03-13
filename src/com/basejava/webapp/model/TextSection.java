package com.basejava.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection {
    private final String sectionContent;

    public TextSection(String sectionContent) {
        Objects.requireNonNull(sectionContent, "section content must not be null");
        this.sectionContent = sectionContent;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return sectionContent.equals(that.sectionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionContent);
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "sectionContent='" + sectionContent + '\'' +
                '}';
    }
}
