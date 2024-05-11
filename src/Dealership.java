import java.util.ArrayList;
import java.util.List;

public class Dealership {
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);
    protected int soldCars = 0;

    public Car sellCar() {
        return seller.sellCar();
    }

    public void acceptCar() {
        seller.receiveCar();
    }

    List<Car> getCars() {
        return cars;
    }

    public void setSoldCars(int soldCars) {
        this.soldCars = soldCars;
    }
}
