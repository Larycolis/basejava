package com.basejava.webapp.model;

public enum ContactType {
    // в настоящее время уже практически не используется
    //HOME_PHONE("Домашний: "),
    PHONE("Phone: "),
    CELLPHONE("Mobile phone: "),
    SKYPE("Skype: ") {
        @Override
        public String toHtml0(String value) {
            return getType() + ": " + toLink("skype:" + value, value);
        }
    },
    EMAIL("Email: ") {
        @Override
        public String toHtml0(String value) {
            return getType() + ": " + toLink(value);
        }

        @Override
        public String toLink(String value) {
            return (value == null) ? "" : toLink("mailto:" + value, value);
        }
    },
    LINKEDIN("Profile LinkedIn") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    },
    GITHUB("Profile GitHub") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    },
    STACKOVERFLOW("Profile Stackoverflow") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    },
    HOME_PAGE("Home page") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    };

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

    public String toLink(String href) {
        return toLink(href, type);
    }

    public static String toLink(String href, String title) {
        return "<a class=\"contact-link\" href='" + href + "'>" + title + "</a>";
    }
}
