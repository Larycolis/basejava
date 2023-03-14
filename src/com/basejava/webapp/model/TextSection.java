package com.basejava.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection {
    private final String text;

    public TextSection(String text) {
        Objects.requireNonNull(text, "section content must not be null");
        this.text = text;
    }

    public String gettext() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
