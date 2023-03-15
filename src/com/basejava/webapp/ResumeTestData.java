package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.basejava.webapp.model.ContactType.*;
import static com.basejava.webapp.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        String fullName = "Григорий Кислин";

        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        contacts.put(CELLPHONE, "+7(921) 855-0482");
        contacts.put(SKYPE, "skype:grigory.kislin");
        contacts.put(EMAIL, "gkislin@yandex.ru");
        contacts.put(LINKEDIN, "https://www.linkedin.com/in/gkislin/");
        contacts.put(GITHUB, "https://github.com/gkislin");
        contacts.put(STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        contacts.put(HOMEPAGE, "https://gkislin.ru/");

        AbstractSection personalContent = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям ");
        AbstractSection objectiveContent = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры ");

        List<String> achievementContent = new ArrayList<>();
        achievementContent.add("- Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievementContent.add("\n - С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников");
        achievementContent.add("\n - Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk");
        achievementContent.add("\n - Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера");
        achievementContent.add("\n - Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга");
        achievementContent.add("\n - Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)");
        achievementContent.add("\n - Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа");

        List<String> qualificationsContent = new ArrayList<>();
        qualificationsContent.add("- JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationsContent.add("\n - Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualificationsContent.add("\n - DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        qualificationsContent.add("\n - Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualificationsContent.add("\n - XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualificationsContent.add("\n - Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)");
        qualificationsContent.add("\n - Python: Django");
        qualificationsContent.add("\n - JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualificationsContent.add("\n - Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualificationsContent.add("\n - Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT");
        qualificationsContent.add("\n - Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualificationsContent.add("\n - Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        qualificationsContent.add("\n - Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualificationsContent.add("\n - Родной русский, английский \"upper intermediate\"");

        AbstractSection achievement = new ListSection(achievementContent);
        AbstractSection qualifications = new ListSection(qualificationsContent);

        List<Period> expData8 = new ArrayList<>();
        expData8.add(new Period(LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        List<Period> expData7 = new ArrayList<>();
        expData7.add(new Period(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "Старший разработчик (backend). ", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO"));
        List<Period> expData6 = new ArrayList<>();
        expData6.add(new Period(LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1), "Java архитектор. ", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        List<Period> expData5 = new ArrayList<>();
        expData5.add(new Period(LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1), "Ведущий программист. ", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5"));
        List<Period> expData4 = new ArrayList<>();
        expData4.add(new Period(LocalDate.of(2008, 6, 1), LocalDate.of(2010, 12, 1), "Ведущий специалист. ", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        List<Period> expData3 = new ArrayList<>();
        expData3.add(new Period(LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1), "Разработчик ПО. ", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)"));
        List<Period> expData2 = new ArrayList<>();
        expData2.add(new Period(LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1), "Разработчик ПО. ", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)"));
        List<Period> expData1 = new ArrayList<>();
        expData1.add(new Period(LocalDate.of(1997, 9, 1), LocalDate.of(2005, 1, 1), "Инженер по аппаратному и программному тестированию. ", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)"));

        List<Organization> expSectionContent = new ArrayList<>();
        expSectionContent.add(new Organization(" - Java Online Projects. ", "https://javaops.ru/", expData8));
        expSectionContent.add(new Organization(" - Wrike. ", "https://www.wrike.com/", expData7));
        expSectionContent.add(new Organization(" - RIT Center. ", "", expData6));
        expSectionContent.add(new Organization(" - Luxoft (Deutsche Bank). ", "https://www.luxoft.ru/", expData5));
        expSectionContent.add(new Organization(" - Yota. ", "https://www.yota.ru/", expData4));
        expSectionContent.add(new Organization(" - Enkata. ", "https://enkata.com/", expData3));
        expSectionContent.add(new Organization(" - Siemens AG. ", "https://www.siemens.com/global/en.html", expData2));
        expSectionContent.add(new Organization(" - Alcatel. ", "https://www.alcatel.ru/", expData1));

        List<Period> eduData7 = new ArrayList<>();
        eduData7.add(new Period(LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "'Functional Programming Principles in Scala' by Martin Odersky", ""));
        List<Period> eduData6 = new ArrayList<>();
        eduData6.add(new Period(LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML'", ""));
        List<Period> eduData5 = new ArrayList<>();
        eduData5.add(new Period(LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1), "3 месяца обучения мобильным IN сетям (Берлин)", ""));
        List<Period> eduData4 = new ArrayList<>();
        eduData4.add(new Period(LocalDate.of(1997, 9, 1), LocalDate.of(1998, 3, 1), "6 месяцев обучения цифровым телефонным сетям (Москва)", ""));
        List<Period> eduData3 = new ArrayList<>();
        eduData3.add(new Period(LocalDate.of(1993, 9, 1), LocalDate.of(1996, 7, 1), "Инженер (программист Fortran, C)", ""));
        List<Period> eduData2 = new ArrayList<>();
        eduData2.add(new Period(LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1), "Аспирантура (программист С, С++)", ""));
        List<Period> eduData1 = new ArrayList<>();
        eduData1.add(new Period(LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1), "Закончил с отличием", ""));

        List<Organization> eduSectionContent = new ArrayList<>();
        eduSectionContent.add(new Organization("- Coursera. ", "https://www.coursera.org/course/progfun", eduData7));
        eduSectionContent.add(new Organization("- Luxoft. ", "https://www.luxoft-training.ru/training/catalog/course.html?ID=22366", eduData6));
        eduSectionContent.add(new Organization("- Siemens AG. ", "https://www.siemens.ru/", eduData5));
        eduSectionContent.add(new Organization("- Alcatel. ", "https://www.alcatel.ru/", eduData4));
        eduSectionContent.add(new Organization("- Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики. ", "https://itmo.ru/", eduData3));
        eduSectionContent.add(new Organization("- Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики. ", "https://itmo.ru/", eduData2));
        eduSectionContent.add(new Organization("- Заочная физико-техническая школа при МФТИ. ", "https://mipt.ru/", eduData1));

        AbstractSection experience = new OrganizationSection(expSectionContent);
        AbstractSection education = new OrganizationSection(eduSectionContent);

        Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
        sections.put(PERSONAL, personalContent);
        sections.put(OBJECTIVE, objectiveContent);
        sections.put(ACHIEVEMENT, achievement);
        sections.put(QUALIFICATIONS, qualifications);
        sections.put(EXPERIENCE, experience);
        sections.put(EDUCATION, education);

        Resume resume = new Resume(fullName, contacts, sections);
        System.out.println("Идентификационный номер резюме: " + resume.getUuid());
        System.out.println("Полное имя: " + resume.getFullName() + "\n");
        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey().getType() + entry.getValue());
        }
        System.out.println(" ");
        for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
            System.out.println(entry.getKey().getTitle() + "\n" + entry.getValue());
        }

        // проверка вывода значений enum ContactType
//        for (ContactType ct : ContactType.values()) {
//            System.out.println(ct);
//        }
    }
}