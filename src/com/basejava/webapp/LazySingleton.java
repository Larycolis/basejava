package com.basejava.webapp;

public class LazySingleton {
    private static volatile LazySingleton INSTANCE;

    private LazySingleton() {
    }

    // Static initialization
    private static class LazySingletonHolder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    private static LazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
    }

    // Double check locked
//    public static synchronized LazySingleton getInstance(){
//        if (INSTANCE == null) {
//            synchronized (LazySingleton.class) {
//                if (INSTANCE == null) {
//                    i = 13; // happened before
//                    INSTANCE = new LazySingleton();
//                }
//            }
//        }
//        return INSTANCE;
//    }
}
