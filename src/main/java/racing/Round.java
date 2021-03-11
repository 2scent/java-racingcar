package racing;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Round {
    final List<Car> cars;

    public static Round createFrom(List<Car> cars) {
        final List<Car> newCars = cars.stream().map(wrap(Car::copy)).collect(Collectors.toList());
        return new Round(newCars);
    }

    private static <T, R> Function<T, R> wrap(ExceptionFunction<T, R> f) {
        return (T r) -> {
            try {
                return f.apply(r);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Round(List<Car> cars) {
        this.cars = cars;
    }

    public void showCars() {
        final ResultView view = new ResultView();
        for (Car car : cars) {
            view.show(car);
        }
        System.out.println();
    }
}
