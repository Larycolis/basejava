package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;
import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();
    public static final String UUID_NOT_EXIST = "dummy";

    public static final Resume RESUME_1;
    public static final Resume RESUME_2;
    public static final Resume RESUME_3;
    public static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1, "Григорий Кислин");
        RESUME_2 = new Resume(UUID_2, "Евгения Богданова");
        RESUME_3 = new Resume(UUID_3, "Некий Никто");
        RESUME_4 = new Resume(UUID_4, "Иммануил Кант");

        RESUME_1.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        RESUME_1.setContact(ContactType.CELLPHONE, "+7(921) 855-0482");
        RESUME_1.setContact(ContactType.SKYPE, "grigory.kislin");
        RESUME_1.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin/");
        RESUME_1.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        RESUME_1.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        RESUME_1.setContact(ContactType.HOME_PAGE, "https://gkislin.ru/");
        RESUME_1.setSection(SectionType.OBJECTIVE,
                new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        RESUME_1.setSection(SectionType.PERSONAL,
                new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры"));
        RESUME_1.setSection(SectionType.ACHIEVEMENTS,
                new ListSection("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                        "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk",
                        "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера",
                        "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга",
                        "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)",
                        "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа"));
        RESUME_1.setSection(SectionType.QUALIFICATIONS,
                new ListSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                        "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                        "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                        "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                        "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                        "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)",
                        "Python: Django",
                        "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                        "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                        "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT",
                        "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                        "Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                        "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                        "Родной русский, английский \"upper intermediate\""));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Alcatel", "https://www.alcatel.ru/",
                                new Organization.Period(1997, Month.SEPTEMBER, 2005, Month.JANUARY, "Инженер по аппаратному и программному тестированию. ", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Siemens AG", "https://www.siemens.com/global/en.html",
                                new Organization.Period(2005, Month.JANUARY, 2007, Month.FEBRUARY, "Разработчик ПО. ", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Enkata", "https://enkata.com/",
                                new Organization.Period(2007, Month.MARCH, 2008, Month.JUNE, "Разработчик ПО. ", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Yota", "https://www.yota.ru/",
                                new Organization.Period(2008, Month.JUNE, 2010, Month.DECEMBER, "Ведущий специалист. ", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Luxoft (Deutsche Bank)", "https://www.luxoft.ru/",
                                new Organization.Period(2010, Month.DECEMBER, 2012, Month.APRIL, "Ведущий программист. ", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("RIT Center", null,
                                new Organization.Period(2012, Month.APRIL, 2014, Month.OCTOBER, "Java архитектор. ", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Wrike", "https://www.wrike.com/",
                                new Organization.Period(2014, Month.OCTOBER, 2016, Month.JANUARY, "Старший разработчик (backend). ", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO"))));
        RESUME_1.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Java Online Projects", "https://javaops.ru/",
                                new Organization.Period(2013, Month.OCTOBER, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."))));
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Заочная физико-техническая школа при МФТИ. ", "https://mipt.ru/",
                                new Organization.Period(1984, Month.SEPTEMBER, 1987, Month.JUNE, "Закончил с отличием", null))));
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/",
                                new Organization.Period(1993, Month.SEPTEMBER, 1996, Month.JULY, "Инженер (программист Fortran, C)", null),
                                new Organization.Period(1987, Month.SEPTEMBER, 1993, Month.JULY, "Аспирантура (программист С, С++)", null))));
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Alcatel", "https://www.alcatel.ru/",
                                new Organization.Period(1997, Month.SEPTEMBER, 1998, Month.MARCH, "6 месяцев обучения цифровым телефонным сетям (Москва)", null))));
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Siemens AG", "https://www.siemens.ru/",
                                new Organization.Period(2005, Month.JANUARY, 2005, Month.APRIL, "3 месяца обучения мобильным IN сетям (Берлин)", null))));
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Luxoft", "https://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                                new Organization.Period(2011, Month.MARCH, 2011, Month.APRIL, "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML'", null))));
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Coursera", "https://www.coursera.org/course/progfun",
                                new Organization.Period(2013, Month.MARCH, 2013, Month.MAY, "'Functional Programming Principles in Scala' by Martin Odersky", null))));

        RESUME_2.setContact(ContactType.EMAIL, "larycolis@gmail.com");
        RESUME_2.setContact(ContactType.CELLPHONE, "+7(963) 258-6061");
        RESUME_2.setContact(ContactType.SKYPE, "larycolis");
        RESUME_2.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/evgeniya-bogdanova-2522b3250/");
        RESUME_2.setContact(ContactType.GITHUB, "https://github.com/Larycolis");
        RESUME_2.setSection(SectionType.OBJECTIVE,
                new TextSection("Тестировщик и начинающий Java-разработчик"));
        RESUME_2.setSection(SectionType.PERSONAL,
                new TextSection("Аналитический склад ума, быстрая обучаемость, амбициозность, креативность, инициативность"));
        RESUME_2.setSection(SectionType.ACHIEVEMENTS,
                new ListSection("Успешное окончание курса \"Java-разработчик веб-приложений\" и разработка web-приложения \"База данных резюме\""));
        RESUME_2.setSection(SectionType.QUALIFICATIONS,
                new ListSection("JEE AS: Tomcat",
                        "Version control: Git",
                        "DB: PostgreSQL, MySQL",
                        "Languages: Java",
                        "XML, SQL",
                        "Java Frameworks: Java 8 (Time API, Streams), JUnit, Selenium (htmlelements)",
                        "Технологии: Servlet, REST, SOAP, HTML",
                        "SoapUI, Postman",
                        "Базовые знания и опыт применения концепций ООП, шаблонов проектрирования, UML, функционального программирования",
                        "Родной русский, английский \"intermediate\", сербский \"A1\""));
        RESUME_2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Иннополис", "innopolis.university/",
                                new Organization.Period(2021, Month.MARCH, 2021, Month.SEPTEMBER, "Специалист по оформлению презентаций курса (проектная работа). ", "Составление презентаций к курсу \"Автоматизация тестирования\", Оформление презентаций в графическом редакторе"))));
        RESUME_2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("SimbirSoft", null,
                                new Organization.Period(2021, Month.AUGUST, 2021, Month.OCTOBER, "QA инженер-тестировщик. ", "Составление и актуализация тестовой документации, Оформление, приоритизация и отслеживание исправления дефектов, Проведение тестирования, Контроль за соблюдением воркфлоу"))));
        RESUME_2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Nobilis.Team", null,
                                new Organization.Period(2022, Month.JANUARY, 2022, Month.JULY, "QA инженер-тестировщик. ", "Составление и актуализация тестовой документации, Оформление, приоритизация и отслеживание исправления дефектов, Проведение тестирования, Контроль за соблюдением воркфлоу"))));
        RESUME_2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Краудтестинг платформа \"Testbirdscrowd\"", "https://nest.testbirds.com/",
                                new Organization.Period(2020, Month.DECEMBER, "QA инженер-тестировщик. ", "Функциональное тестирование, Smoke-тестирование, Регрессионное тестирование, Кросс-браузерное тестирование, Системное тестирование, Тестирование инсталляции, API тестирование"))));
        RESUME_2.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Санкт-Петербургский гуманитарный университет профсоюзов, Санкт-Петербург", "https://www.gup.ru/",
                                new Organization.Period(2006, Month.SEPTEMBER, 2012, Month.JULY, "Реклама, Маркетинговые коммуникации и сопровождение медиа-проектов", null))));
        RESUME_2.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Beonmax", "https://beonmax.com/",
                                new Organization.Period(2021, Month.MAY, 2021, Month.JUNE, "Курс \"SQL и PostgreSQL (практический курс)\"", null), new Organization.Period(2021, Month.MAY, 2021, Month.MAY, "MySQL (базовый курс)", null))));
        RESUME_2.setSection(SectionType.EDUCATION,
                new OrganizationSection(new Organization("Software-testing", null,
                        new Organization.Period(2021, Month.MAY, 2021, Month.JUNE, "Курс \"Тестирование REST API\"", null))));
        RESUME_2.setSection(SectionType.EDUCATION,
                new OrganizationSection(new Organization("Udemy", null,
                        new Organization.Period(2021, Month.MAY, 2021, Month.JUNE, "Курс: \"Git (полный курс)\"", null))));
        RESUME_2.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Base Java (topjava.ru)", "https://javaops.ru/",
                                new Organization.Period(2023, Month.JANUARY, 2023, Month.MAY, "Курс \"Java-разработчик веб-приложений\"", null))));
        RESUME_2.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("JavaRush", "https://javarush.com/",
                                new Organization.Period(2022, Month.JULY, "Основы языка Java", null))));

        RESUME_3.setContact(ContactType.EMAIL, "test data");
        RESUME_3.setContact(ContactType.CELLPHONE, "test data");
        RESUME_3.setSection(SectionType.OBJECTIVE,
                new TextSection("test data"));
        RESUME_3.setSection(SectionType.PERSONAL,
                new TextSection("test data"));
        RESUME_3.setSection(SectionType.ACHIEVEMENTS,
                new ListSection("test data"));
        RESUME_3.setSection(SectionType.QUALIFICATIONS,
                new ListSection("test data"));
        RESUME_3.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("test data", "test data",
                                new Organization.Period(2024, Month.DECEMBER, "test data", "test data"))));
        RESUME_3.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("test data", "test data",
                                new Organization.Period(2022, Month.JULY, "test data", "test data"),
                                new Organization.Period(2022, Month.JULY, 2023, Month.APRIL, "test data", null))));
    }
}
