package com.basejava.webapp.model;

import com.basejava.webapp.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private static final long serialVersionUUID = 1L;

    public static final Organization EMPTY = new Organization("", "", Period.EMPTY);
    private Link homePage;
    private List<Period> period = new ArrayList<>();

    public Organization() {
    }

    public Organization(String name, String url, Period... period) {
        this(new Link(name, url), Arrays.asList(period));
    }

    public Organization(Link homePage, List<Period> period) {
        this.homePage = homePage;
        this.period = period;
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Period> getPeriod() {
        return period;
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
        return "Organization(" + homePage + "," + period + ')';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Period implements Serializable {
        private static final long serialVersionUUID = 1L;

        public static final Period EMPTY = new Period();
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate startDate;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate endDate;
        private String title;
        private String description;

        public Period() {
        }

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
            this.description = description == null ? "" : description;
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
            return "Period(" + startDate + ',' + endDate + ',' + title + ',' + description + ')';
        }
    }
}
