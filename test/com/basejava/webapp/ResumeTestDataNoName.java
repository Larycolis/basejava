package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;

import static com.basejava.webapp.model.SectionType.*;
import static com.basejava.webapp.model.SectionType.EDUCATION;

public class ResumeTestDataNoName {
    private static final String PH_NUM = "test data";
    private static final String E_MAIL = "test data";

    private static final String PERS_CONT = "test data";
    private static final String OBJ_CONT = "test data";

    private static final String ACH_1 = "test data";

    private static final String QUAL_1 = "test data";

    private static final Organization EXP_1 = new Organization("test data", "test data", new Organization.Period(2024, Month.DECEMBER, "test data", "test data"));

    private static final Organization EDU_1 = new Organization("test data", "test data", new Organization.Period(2022, Month.JULY, "test data", "test data"), new Organization.Period(2022, Month.JULY, 2023, Month.APRIL, "test data", null));

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        addContact(resume);
        addSection(resume);

        return resume;
    }

    private static void addContact(Resume resume) {
        resume.addContact(ContactType.CELLPHONE, PH_NUM);
        resume.addContact(ContactType.EMAIL, E_MAIL);
    }

    private static void addSection(Resume resume) {
        resume.addSection(PERSONAL, new TextSection(PERS_CONT));
        resume.addSection(OBJECTIVE, new TextSection(OBJ_CONT));
        resume.addSection(ACHIEVEMENTS, new ListSection(ACH_1));
        resume.addSection(QUALIFICATIONS, new ListSection(QUAL_1));
        resume.addSection(EXPERIENCE, new OrganizationSection(EXP_1));
        resume.addSection(EDUCATION, new OrganizationSection(EDU_1));
    }
}