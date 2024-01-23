public class Philosopher extends Thread {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private int eatingCounter;


    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (eatingCounter < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Мыслитель " + name + " наелся.");
    }

    private void eating() throws InterruptedException {
        if (!leftFork.isUsingFork()) {
            leftFork.changeForkCondition();
            if (!rightFork.isUsingFork()) {
                rightFork.changeForkCondition();
                System.out.println("Мыслитель " + name + " ест...");
                Thread.sleep(3000);
                System.out.println("Мыслитель " + name + " поел");
                leftFork.changeForkCondition();
                rightFork.changeForkCondition();
                eatingCounter++;
                Thread.sleep(3000);
            } else {
                leftFork.changeForkCondition();
                System.out.println("Мыслитель " + name + " не может есть, правая вилка занята");
            }
        } else {
            System.out.println("Мыслитель " + name + " не может есть, левая вилка занята");
        }
    }

    private void thinking() throws InterruptedException {
        System.out.println("Мыслитель " + name + " думает...");
        Thread.sleep(4000);
    }
}
