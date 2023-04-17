package com.basejava.webapp;

// В комментариях параллельно выполняющийся второй thread обозначается символом *

public class MainDeadlock implements Runnable {
    Obj1 obj1 = new Obj1();
    Obj2 obj2 = new Obj2();

    public MainDeadlock() {
        Thread thread2 = new Thread(this); // 2. Создается второй thread c переданной ссылкой на конструируемый объект
        thread2.start(); // 3. В основном thread вызывается метод запуска второго thread

        obj1.catchUp1(obj2); // 5. В основном thread вызывается метод catchUp1 и захватывается synchronized у obj1
    }

    // 0. основной thread
    public static void main(String[] args) {
        new MainDeadlock(); // 1. Создается объект класса MainDeadlock в основном thread
    }

    // 4. Во втором thread исполняется метод run;
    @Override
    public void run() {
        obj2.catchUp2(obj1); // 5*. Во втором thread вызывается метод catchUp2 и захватывается synchronized у obj2
    }

    class Obj1 {
        synchronized void catchUp1(Obj2 obj2) {
            try {
                Thread.sleep(1000); // 6. Основной thread погружается в сон, synchronized у obj1 остается захваченным
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            obj2.goHere2(); // 7. Основной thread просыпается и вызывает метод goHere2, метод пытается захватить synchronized у obj2. Но synchronized у obj2 остается захваченным (см. 5*). Происходит ожидание освобождения synchronized у obj2 = Deadlock
        }

        synchronized void goHere1() {
            System.out.println("How did you get here, main thread?");
        }
    }

    class Obj2 {
        synchronized void catchUp2(Obj1 obj1) {
            try {
                Thread.sleep(1000); // 6*. Второй thread погружается в сон, synchronized у obj2 остается захваченным
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            obj1.goHere1(); //7*. Второй thread просыпается и вызывает метод goHere1, метод пытается захватить synchronized у obj1. Но synchronized у obj1 остается захваченным (см. 5). Происходит ожидание освобождения synchronized у obj1 = Deadlock
        }

        synchronized void goHere2() {
            System.out.println("How did you get here, thread2?");
        }
    }
}
