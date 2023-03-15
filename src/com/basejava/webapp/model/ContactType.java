package com.basejava.webapp.model;

public enum ContactType {
    // в настоящее время уже практически не используется
    //HOME_PHONE("Домашний: "),
    PHONE("Тел.: "),
    CELLPHONE("Мобильный: "),
    SKYPE("Skype.: "),
    EMAIL("Почта: "),
    LINKEDIN("Профиль LinkedIn: "),
    GITHUB("Профиль GitHub: "),
    STACKOVERFLOW("Профиль Stackoverflow: "),
    HOME_PAGE("Домашняя страница: ");

    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
