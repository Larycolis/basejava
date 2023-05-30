package com.basejava.webapp.model;

public enum SectionType {
    OBJECTIVE("Position"),
    PERSONAL("Personal qualities"),
    ACHIEVEMENTS("Achievements"),
    QUALIFICATIONS("Qualification"),
    EXPERIENCE("Experience"),
    EDUCATION("Education");

    private final String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
