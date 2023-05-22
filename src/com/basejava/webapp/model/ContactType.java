package com.basejava.webapp.model;

public enum ContactType {
    // в настоящее время уже практически не используется
    //HOME_PHONE("Домашний: "),
    PHONE("Phone: "),
    CELLPHONE("Mobile phone: "),
    SKYPE("Skype: ") {
        @Override
        public String toHtml0(String value) {
            return "<a href='skype:" + value + "'>" + value + "</a>";
        }
    },
    EMAIL("Email: ") {
        @Override
        public String toHtml0(String value) {
            return "<a href='mailto:" + value + "'>" + value + "</a>";
        }
    },
    LINKEDIN("Profile LinkedIn"),
    GITHUB("Profile GitHub"),
    STACKOVERFLOW("Profile Stackoverflow"),
    HOME_PAGE("Home page");

    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    protected String toHtml0(String value) {
        return type + ": " + value;
    }

    public String toHtml(String value) {
        return (value == null) ? "" : toHtml0(value);
    }
}
