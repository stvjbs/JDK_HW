import java.util.concurrent.atomic.AtomicBoolean;

public class Fork {
    private final AtomicBoolean usingFork = new AtomicBoolean(false);

    public void changeForkCondition() {
        usingFork.set(!usingFork.get());
    }

    public boolean isUsingFork() {
        return usingFork.get();
    }
}
