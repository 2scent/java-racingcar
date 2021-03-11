package racing;

import java.util.*;

public class RacingSimulator {
    final private List<Round> rounds;
    final private List<Car> cars;
    final private int attemptsCount;

    public RacingSimulator(int carsCount, int attemptsCount) {
        this.rounds = new ArrayList<>();
        this.cars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            this.cars.add(new Car());

        }
        this.attemptsCount = attemptsCount;
    }

    public void runRace() {
        tryMoveCars();
        rounds.add(Round.createFrom(cars));
    }

    private void tryMoveCars() {
        for (Car car : cars) {
            car.tryMove(() -> new Random().nextInt(10));
        }
    }

    public boolean hasNextRound() {
        return rounds.size() < attemptsCount;
    }

    public void showResult() {
        System.out.println("실행 결과");
        for (Round round : rounds) {
            round.showCars();
        }
    }
}

