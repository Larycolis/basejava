package com.basejava.webapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.basejava.webapp.util.DateUtil.NOW;
import static com.basejava.webapp.util.DateUtil.of;

public class Organization implements Serializable {
    private static final long serialVersionUUID = 1L;
    private final Link homePage;
    private List<Period> period = new ArrayList<>();

    public Organization(String name, String url, Period... period) {
        this(new Link(name, url), Arrays.asList(period));
    }

    public Organization(Link homePage, List<Period> period) {
        this.homePage = homePage;
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, period);
    }

    @Override
    public String toString() {
        return "\n" + homePage + "\n" + period;
    }

    public static class Period implements Serializable {
        private static final long serialVersionUUID = 1L;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public Period(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), NOW, title, description);
        }

        public Period(int startYear, Month startMonth, int endDate, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endDate, endMonth), title, description);
        }

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

            return Objects.equals(startDate, period.startDate) &&
                    Objects.equals(endDate, period.endDate) &&
                    Objects.equals(title, period.title) &&
                    Objects.equals(description, period.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, title, description);
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
            String startDateDisplayFormat = startDate.format(formatter);
            String endDateDisplayFormat;
            if (endDate.isEqual(NOW)) {
                endDateDisplayFormat = "Сейчас";
            } else {
                endDateDisplayFormat = endDate.format(formatter);
            }

            return startDateDisplayFormat + " - " + endDateDisplayFormat + "\n" + title + "\n" + description;
        }
    }
}
