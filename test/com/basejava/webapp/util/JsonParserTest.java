package com.basejava.webapp.util;

import com.basejava.webapp.model.AbstractSection;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.model.SectionType;
import com.basejava.webapp.model.TextSection;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static com.basejava.webapp.TestData.RESUME_1;

public class JsonParserTest extends TestCase {
    @Test
    public void testResume() throws Exception {
        String json = JsonParser.write(RESUME_1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(RESUME_1, resume);
    }

    @Test
    public void testWrite() {
        AbstractSection abstractSection = new TextSection("Objective1");
        String json = JsonParser.write(abstractSection, AbstractSection.class);
        System.out.println(json);
        AbstractSection abstractSection2 = JsonParser.read(json, AbstractSection.class);
        Assert.assertEquals(abstractSection, abstractSection2);
    }
}