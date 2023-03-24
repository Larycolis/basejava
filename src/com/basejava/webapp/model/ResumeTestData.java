package com.basejava.webapp.model;

import java.time.Month;
import java.util.EnumMap;
import java.util.Map;

import static com.basejava.webapp.model.SectionType.*;

public class ResumeTestData {
    private static final String PH_NUM = "+7(921) 855-0482";
    private static final String ACCOUNT = "skype:grigory.kislin";
    private static final String E_MAIL = "gkislin@yandex.ru";
    private static final String LINK_1 = "https://www.linkedin.com/in/gkislin/";
    private static final String LINK_2 = "https://github.com/gkislin";
    private static final String LINK_3 = "https://stackoverflow.com/users/548473/grigory-kislin";
    private static final String LINK_4 = "https://gkislin.ru/";

    private static final String PERS_CONT = "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям ";
    private static final String OBJ_CONT = "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры";

    private static final String ACH_1 = "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет";
    private static final String ACH_2 = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников";
    private static final String ACH_3 = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk";
    private static final String ACH_4 = "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера";
    private static final String ACH_5 = "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга";
    private static final String ACH_6 = "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)";
    private static final String ACH_7 = "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа";

    private static final String QUAL_1 = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
    private static final String QUAL_2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
    private static final String QUAL_3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB";
    private static final String QUAL_4 = "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy";
    private static final String QUAL_5 = "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts";
    private static final String QUAL_6 = "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)";
    private static final String QUAL_7 = "Python: Django";
    private static final String QUAL_8 = "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js";
    private static final String QUAL_9 = "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka";
    private static final String QUAL_10 = "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT";
    private static final String QUAL_11 = "Инструменты: Maven + plugin development, Gradle, настройка Ngnix";
    private static final String QUAL_12 = "Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer";
    private static final String QUAL_13 = "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования";
    private static final String QUAL_14 = "Родной русский, английский \"upper intermediate\"";

    private static final Organization EXP_8 = new Organization("Java Online Projects", "https://javaops.ru/", new Organization.Period(2013, Month.OCTOBER, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
    private static final Organization EXP_7 = new Organization("Wrike", "https://www.wrike.com/", new Organization.Period(2014, Month.OCTOBER, 2016, Month.JANUARY, "Старший разработчик (backend). ", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO"));
    private static final Organization EXP_6 = new Organization("RIT Center", null, new Organization.Period(2012, Month.APRIL, 2014, Month.OCTOBER, "Java архитектор. ", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
    private static final Organization EXP_5 = new Organization("Luxoft (Deutsche Bank)", "https://www.luxoft.ru/", new Organization.Period(2010, Month.DECEMBER, 2012, Month.APRIL, "Ведущий программист. ", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5"));
    private static final Organization EXP_4 = new Organization("Yota", "https://www.yota.ru/", new Organization.Period(2008, Month.JUNE, 2010, Month.DECEMBER, "Ведущий специалист. ", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
    private static final Organization EXP_3 = new Organization("Enkata", "https://enkata.com/", new Organization.Period(2007, Month.MARCH, 2008, Month.JUNE, "Разработчик ПО. ", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)"));
    private static final Organization EXP_2 = new Organization("Siemens AG", "https://www.siemens.com/global/en.html", new Organization.Period(2005, Month.JANUARY, 2007, Month.FEBRUARY, "Разработчик ПО. ", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)"));
    private static final Organization EXP_1 = new Organization("Alcatel", "https://www.alcatel.ru/", new Organization.Period(1997, Month.SEPTEMBER, 2005, Month.JANUARY, "Инженер по аппаратному и программному тестированию. ", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)"));

    private static final Organization EDU_6 = new Organization("Coursera", "https://www.coursera.org/course/progfun", new Organization.Period(2013, Month.MARCH, 2013, Month.MAY, "'Functional Programming Principles in Scala' by Martin Odersky", null));
    private static final Organization EDU_5 = new Organization("Luxoft", "https://www.luxoft-training.ru/training/catalog/course.html?ID=22366", new Organization.Period(2011, Month.MARCH, 2011, Month.APRIL, "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML'", null));
    private static final Organization EDU_4 = new Organization("Siemens AG", "https://www.siemens.ru/", new Organization.Period(2005, Month.JANUARY, 2005, Month.APRIL, "3 месяца обучения мобильным IN сетям (Берлин)", null));
    private static final Organization EDU_3 = new Organization("Alcatel", "https://www.alcatel.ru/", new Organization.Period(1997, Month.SEPTEMBER, 1998, Month.MARCH, "6 месяцев обучения цифровым телефонным сетям (Москва)", null));
    private static final Organization EDU_2 = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/", new Organization.Period(1993, Month.SEPTEMBER, 1996, Month.JULY, "Инженер (программист Fortran, C)", null), new Organization.Period(1987, Month.SEPTEMBER, 1993, Month.JULY, "Аспирантура (программист С, С++)", null));
    private static final Organization EDU_1 = new Organization("Заочная физико-техническая школа при МФТИ. ", "https://mipt.ru/", new Organization.Period(1984, Month.SEPTEMBER, 1987, Month.JUNE, "Закончил с отличием", null));

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.addContact(ContactType.CELLPHONE, PH_NUM);
        resume.addContact(ContactType.SKYPE, ACCOUNT);
        resume.addContact(ContactType.EMAIL, E_MAIL);
        resume.addContact(ContactType.LINKEDIN, LINK_1);
        resume.addContact(ContactType.GITHUB, LINK_2);
        resume.addContact(ContactType.STACKOVERFLOW, LINK_3);
        resume.addContact(ContactType.HOME_PAGE, LINK_4);
        resume.addSection(PERSONAL, new TextSection(PERS_CONT));
        resume.addSection(OBJECTIVE, new TextSection(OBJ_CONT));
        resume.addSection(ACHIEVEMENT, new ListSection(ACH_1, ACH_2, ACH_3, ACH_4, ACH_5, ACH_6, ACH_7));
        resume.addSection(QUALIFICATIONS, new ListSection(QUAL_1, QUAL_2, QUAL_3, QUAL_4, QUAL_5, QUAL_6, QUAL_7, QUAL_8, QUAL_9, QUAL_10, QUAL_11, QUAL_12, QUAL_13, QUAL_14));
        resume.addSection(EXPERIENCE, new OrganizationSection(EXP_8, EXP_7, EXP_6, EXP_5, EXP_4, EXP_3, EXP_2, EXP_1));
        resume.addSection(EDUCATION, new OrganizationSection(EDU_6, EDU_5, EDU_4, EDU_3, EDU_2, EDU_1));
        return resume;
    }

    public static void main(String[] args) {
        // Анализ времени выполнения процедуры создания и заполнения резюме
        long start = System.currentTimeMillis();
        String uuid = "uuid1";
        String fullName = "Григорий Кислин";

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        contacts.put(ContactType.CELLPHONE, PH_NUM);
        contacts.put(ContactType.SKYPE, ACCOUNT);
        contacts.put(ContactType.EMAIL, E_MAIL);
        contacts.put(ContactType.LINKEDIN, LINK_1);
        contacts.put(ContactType.GITHUB, LINK_2);
        contacts.put(ContactType.STACKOVERFLOW, LINK_3);
        contacts.put(ContactType.HOME_PAGE, LINK_4);

        Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
        sections.put(PERSONAL, new TextSection(PERS_CONT));
        sections.put(OBJECTIVE, new TextSection(OBJ_CONT));
        sections.put(ACHIEVEMENT, new ListSection(ACH_1, ACH_2, ACH_3, ACH_4, ACH_5, ACH_6, ACH_7));
        sections.put(QUALIFICATIONS, new ListSection(QUAL_1, QUAL_2, QUAL_3, QUAL_4, QUAL_5, QUAL_6, QUAL_7, QUAL_8, QUAL_9, QUAL_10, QUAL_11, QUAL_12, QUAL_13, QUAL_14));
        sections.put(EXPERIENCE, new OrganizationSection(EXP_8, EXP_7, EXP_6, EXP_5, EXP_4, EXP_3, EXP_2, EXP_1));
        sections.put(EDUCATION, new OrganizationSection(EDU_6, EDU_5, EDU_4, EDU_3, EDU_2, EDU_1));

        Resume resume = new Resume(uuid, fullName, contacts, sections);

        // Проверка вывода заполненного резюме
        System.out.println("Идентификационный номер резюме: " + resume.getUuid());
        System.out.println("Полное имя: " + resume.getFullName() + "\n");

        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey().getType() + entry.getValue());
        }

        System.out.println(" ");

        for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
            System.out.println(entry.getKey().getTitle() + "\n" + entry.getValue());
        }

        System.out.printf("Creating a resume and filling in the values took %d milliseconds", System.currentTimeMillis() - start);
    }
}