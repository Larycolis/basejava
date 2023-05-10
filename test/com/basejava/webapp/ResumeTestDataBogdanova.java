package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;

import static com.basejava.webapp.model.SectionType.*;

public class ResumeTestDataBogdanova {
    private static final String PH_NUM = "+7(963) 258-6061";
    private static final String ACCOUNT = "skype:larycolis";
    private static final String E_MAIL = "larycolis@gmail.com";
    private static final String LINK_1 = "https://www.linkedin.com/in/evgeniya-bogdanova-2522b3250/";
    private static final String LINK_2 = "https://github.com/Larycolis";

    private static final String PERS_CONT = "Тестировщик и начинающий Java-разработчик";
    private static final String OBJ_CONT = "Аналитический склад ума, быстрая обучаемость, амбициозность, креативность, инициативность";

    private static final String ACH_1 = "Успешное окончание курса \"Java-разработчик веб-приложений\" и разработка web-приложения \"База данных резюме\"";

    private static final String QUAL_1 = "JEE AS: Tomcat";
    private static final String QUAL_2 = "Version control: Git";
    private static final String QUAL_3 = "DB: PostgreSQL, MySQL";
    private static final String QUAL_4 = "Languages: Java";
    private static final String QUAL_5 = "XML, SQL";
    private static final String QUAL_6 = "Java Frameworks: Java 8 (Time API, Streams), JUnit, Selenium (htmlelements)";
    private static final String QUAL_7 = "Технологии: Servlet, REST, SOAP, HTML";
    private static final String QUAL_8 = "SoapUI, Postman";
    private static final String QUAL_9 = "Базовые знания и опыт применения концепций ООП, шаблонов проектрирования, UML, функционального программирования";
    private static final String QUAL_10 = "Родной русский, английский \"intermediate\", сербский \"elementary\"";

    private static final Organization EXP_8 = new Organization("Краудтестинг платформа \"Testbirdscrowd\"", "https://nest.testbirds.com/", new Organization.Period(2020, Month.DECEMBER, "QA инженер-тестировщик. ", "Функциональное тестирование, Smoke-тестирование, Регрессионное тестирование, Кросс-браузерное тестирование, Системное тестирование, Тестирование инсталляции, API тестирование"));
    private static final Organization EXP_7 = new Organization("Nobilis.Team", null, new Organization.Period(2022, Month.JANUARY, 2022, Month.JULY, "QA инженер-тестировщик. ", "Составление и актуализация тестовой документации, Оформление, приоритизация и отслеживание исправления дефектов, Проведение тестирования, Контроль за соблюдением воркфлоу"));
    private static final Organization EXP_6 = new Organization("SimbirSoft", null, new Organization.Period(2021, Month.AUGUST, 2021, Month.OCTOBER, "QA инженер-тестировщик. ", "Составление и актуализация тестовой документации, Оформление, приоритизация и отслеживание исправления дефектов, Проведение тестирования, Контроль за соблюдением воркфлоу"));
    private static final Organization EXP_5 = new Organization("Иннополис", "innopolis.university/", new Organization.Period(2021, Month.MARCH, 2021, Month.SEPTEMBER, "Специалист по оформлению презентаций курса (проектная работа). ", "Составление презентаций к курсу \"Автоматизация тестирования\", Оформление презентаций в графическом редакторе"));

    private static final Organization EDU_6 = new Organization("JavaRush", "https://javarush.com/", new Organization.Period(2022, Month.JULY, "Основы языка Java", null));
    private static final Organization EDU_5 = new Organization("Base Java (topjava.ru)", "https://javaops.ru/", new Organization.Period(2023, Month.JANUARY, 2023, Month.MAY, "Курс \"Java-разработчик веб-приложений\"", null));
    private static final Organization EDU_4 = new Organization("Udemy", null, new Organization.Period(2021, Month.MAY, 2021, Month.JUNE, "Курс: \"Git (полный курс)\"", null));
    private static final Organization EDU_3 = new Organization("Software-testing", null, new Organization.Period(2021, Month.MAY, 2021, Month.JUNE, "Курс \"Тестирование REST API\"", null));
    private static final Organization EDU_2 = new Organization("Beonmax", "https://beonmax.com/", new Organization.Period(2021, Month.MAY, 2021, Month.JUNE, "Курс \"SQL и PostgreSQL (практический курс)\"", null), new Organization.Period(2021, Month.MAY, 2021, Month.MAY, "MySQL (базовый курс)", null));
    private static final Organization EDU_1 = new Organization("Санкт-Петербургский гуманитарный университет профсоюзов, Санкт-Петербург", "https://www.gup.ru/", new Organization.Period(2006, Month.SEPTEMBER, 2012, Month.JULY, "Реклама, Маркетинговые коммуникации и сопровождение медиа-проектов", null));

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        addContact(resume);
        addSection(resume);

        return resume;
    }

    private static void addContact(Resume resume){
        resume.addContact(ContactType.CELLPHONE, PH_NUM);
        resume.addContact(ContactType.SKYPE, ACCOUNT);
        resume.addContact(ContactType.EMAIL, E_MAIL);
        resume.addContact(ContactType.LINKEDIN, LINK_1);
        resume.addContact(ContactType.GITHUB, LINK_2);
    }

    private static void addSection(Resume resume){
        resume.addSection(PERSONAL, new TextSection(PERS_CONT));
        resume.addSection(OBJECTIVE, new TextSection(OBJ_CONT));
        resume.addSection(ACHIEVEMENT, new ListSection(ACH_1));
        resume.addSection(QUALIFICATIONS, new ListSection(QUAL_1, QUAL_2, QUAL_3, QUAL_4, QUAL_5, QUAL_6, QUAL_7, QUAL_8, QUAL_9, QUAL_10));
        resume.addSection(EXPERIENCE, new OrganizationSection(EXP_8, EXP_7, EXP_6, EXP_5));
        resume.addSection(EDUCATION, new OrganizationSection(EDU_6, EDU_5, EDU_4, EDU_3, EDU_2, EDU_1));
    }
}