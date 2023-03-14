package com.basejava.webapp.model;

public enum ContactType {
    CELLPHONE("Тел.: "),
    SKYPE("Skype.: "),
    EMAIL("Почта: "),
    LINKEDIN("Профиль LinkedIn: "),
    GITHUB("Профиль GitHub: "),
    STACKOVERFLOW("Профиль Stackoverflow: "),
    HOMEPAGE("Домашняя страница: ");

    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
