package com.basejava.webapp;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final Resume RESUME_1 = new Resume("uuid1");
    private static final Resume RESUME_2 = new Resume("uuid2");
    private static final Resume RESUME_3 = new Resume("uuid3");
    private static final Resume RESUME_4 = new Resume("uuid4");

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), RESUME_1.getUuid())) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put(RESUME_1.getUuid(), RESUME_1);
        map.put(RESUME_2.getUuid(), RESUME_2);
        map.put(RESUME_3.getUuid(), RESUME_3);

        // wrong way
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
