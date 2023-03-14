package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final String name;
    private final String website;
    private final List<Period> period;

    public Organization(String name, String website, List<Period> period) {
        Objects.requireNonNull(name, "organization name must not be null");
        Objects.requireNonNull(website, "website must not be null");
        Objects.requireNonNull(period, "period must not be null");
        this.name = name;
        this.website = website;
        this.period = period;
    }

    public List<Period> getPeriod() {
        return period;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return period.equals(that.period) && name.equals(that.name) && website.equals(that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, name, website);
    }

    @Override
    public String toString() {
        return "\n" + name + website + "\n" + period;
    }
}
