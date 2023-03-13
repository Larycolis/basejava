package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private final LocalDate beginning;
    private final LocalDate ending;

    public Period(LocalDate beginning, LocalDate ending) {
        Objects.requireNonNull(beginning, "beginning LocaleDate must not be null");
        Objects.requireNonNull(ending, "ending LocaleDate must not be null");
        this.beginning = beginning;
        this.ending = ending;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public LocalDate getEnding() {
        return ending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return beginning.equals(period.beginning) && ending.equals(period.ending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginning, ending);
    }

    @Override
    public String toString() {
        return "Period{" +
                "beginning=" + beginning +
                ", ending=" + ending +
                '}';
    }
}
