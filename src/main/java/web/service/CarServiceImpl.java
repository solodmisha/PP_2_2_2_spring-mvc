package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    public static final List<Car> cars = CarServiceImpl.createCarList();

    private static List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Lamborghini", "Diablo", "red"));
        carList.add(new Car("Suzuki", "SX4", "white"));
        carList.add(new Car("BMW", "M4", "blue"));
        carList.add(new Car("Mercedes", "W220", "yellow"));
        carList.add(new Car("Mazda", "SX7", "black"));
        return carList;
    }

    @Override
    public List<Car> getCountOfCars(List<Car> list, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must be non-negative");
        }
        return count >= 5 ? cars : list.subList(0, count);
    }
}