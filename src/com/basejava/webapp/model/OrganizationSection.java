package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private final List<Organization> sectionContent;

    public OrganizationSection(List<Organization> sectionContent) {
        Objects.requireNonNull(sectionContent, "section content must not be null");
        this.sectionContent = sectionContent;
    }

    public List<Organization> getSectionContent() {
        return sectionContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
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
