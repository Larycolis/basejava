package com.basejava.webapp;

import com.basejava.webapp.storage.SQLStorage;
import com.basejava.webapp.storage.Storage;

import java.io.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Config {
    private static final String PROPS = "/resumes.properties";
    private static final Config INSTANCE = new Config();
    private final File storageDir;
    private final Storage storage;

    private Set<String> immutableUuids = new HashSet<String>() {{  // for JDK 9+: Set.of("111", "222");
        add("11111111-1111-1111-1111-111111111111");
        add("22222222-2222-2222-2222-222222222222");
    }};

    public static Config getConfig() {
        return INSTANCE;
    }

    private Config() {
        try(InputStream is = Config.class.getResourceAsStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
            storage = new SQLStorage(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password")
            );
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS);
        }
    }

    public File getStorageDir() {
        return storageDir;
    }

    public Storage getStorage() {
        return storage;
    }

    public boolean isImmutable(String uuids) {
        return immutableUuids.contains(uuids);
    }

    public void checkImmutable(String uuids) {
        if (immutableUuids.contains(uuids))
            throw new RuntimeException("Зарезервированные резюме нельзя менять");
    }

//        private static File getHomeDir() {
//        String root = System.getProperty("homeDir");
//        File homeDir = new File(root == null ? "." : root);
//        if (!homeDir.isDirectory()) {
//            throw new IllegalStateException(homeDir + " is not directory");
//        }
//        return homeDir;
//    }
}
