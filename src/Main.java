import java.util.List;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(5);
        for (Philosopher philosopher : table.philosopherList) {
            philosopher.start();
        }
    }
}
