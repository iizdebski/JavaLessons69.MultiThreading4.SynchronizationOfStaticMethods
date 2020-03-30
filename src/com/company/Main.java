package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.setI(5);
        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();
        myThread.setResource(resource);
        myThread2.setResource(resource);
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        System.out.println(resource.getI());
    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {
        private int i;

        public int getI() {
            return i;
        }

    public synchronized void setI(int i) {
        this.i = this.i;
    }

    public synchronized void changeI() {
            int i = this.i;
            if (Thread.currentThread().equals("one")) {
                Thread.yield();
            }
            i++;
            this.i = i;
    }
}



// synchronized - метод повинен бути синхронізованим. Він не повинен перериватися.
// Поки один із потоків не дійде що кінця, жоден нший не зможе виконувати роботу 