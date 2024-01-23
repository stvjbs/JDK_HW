import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int numberOfPhilosophers;
    List<Fork> forksList = new ArrayList<>();
    List<Philosopher> philosopherList = new ArrayList<>();

    public Table(int numberOfPhilosophers) {
        this.numberOfPhilosophers = numberOfPhilosophers;
        createForks();
        createPhilosopher();
    }

    private void createForks() {
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forksList.add(new Fork());
        }
    }

    private void createPhilosopher() {
        for (int i = 1; i < numberOfPhilosophers; i++) {
            philosopherList.add(new Philosopher("№" + i, forksList.get(i - 1), forksList.get(i)));
        }
        philosopherList.add(new Philosopher(
                "№" + numberOfPhilosophers,
                forksList.get(numberOfPhilosophers - 1), forksList.get(0)));
    }
}
