package racing;

import java.util.function.Supplier;

public class Car implements Cloneable {
    private int distance;

    public Car() {
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void tryMove(Supplier<Integer> randomSupplier) {
        if (randomSupplier.get() >= 4) {
            distance++;
        }
    }

    public Car copy() throws CloneNotSupportedException {
        return (Car) clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
