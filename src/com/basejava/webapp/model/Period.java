package com.basejava.webapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Period(LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate LocaleDate must not be null");
        Objects.requireNonNull(endDate, "endDate LocaleDate must not be null");
        Objects.requireNonNull(title, "title LocaleDate must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (!startDate.equals(period.startDate)) return false;
        if (!endDate.equals(period.endDate)) return false;
        if (!title.equals(period.title)) return false;
        return Objects.equals(description, period.description);
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String startDateDisplayFormat = startDate.format(formatter);
        String endDateDisplayFormat;
        if (endDate.isEqual(LocalDate.now())) {
            endDateDisplayFormat = "Сейчас";
        } else {
            endDateDisplayFormat = endDate.format(formatter);
        }

        return startDateDisplayFormat + " - " + endDateDisplayFormat + "\n" + title + "\n" + description;
    }
}
