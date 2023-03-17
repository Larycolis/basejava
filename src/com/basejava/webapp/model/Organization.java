package com.basejava.webapp.model;

import java.util.List;

public class Organization {
    private final Link homePage;

    private final List<Period> period;

    public Organization(String name, String url, List<Period> period) {
        this.homePage = new Link(name, url);
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return period.equals(that.period);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + period.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + homePage + "\n" + period;
    }
}
