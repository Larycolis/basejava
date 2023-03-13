package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final List<Period> period;

    private final String orgName;
    private final String role;
    private final String content;


    public Organization(List<Period> period, String orgName, String role, String content) {
        Objects.requireNonNull(period, "period must not be null");
        Objects.requireNonNull(orgName, "organization name must not be null");
        Objects.requireNonNull(role, "role must not be null");
        Objects.requireNonNull(content, "content must not be null");
        this.period = period;
        this.orgName = orgName;
        this.role = role;
        this.content = content;
    }

    public List<Period> getPeriod() {
        return period;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return period.equals(that.period) && orgName.equals(that.orgName) && role.equals(that.role) && content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, orgName, role, content);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "period=" + period +
                ", orgName='" + orgName + '\'' +
                ", role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
