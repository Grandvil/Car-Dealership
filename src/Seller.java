public class Seller {
    private Dealership dealership;
    static final int RECEIVE_TIME = 1500;
    static final int BUY_TIME = 1000;
    private int size = 10;

    public Seller(Dealership dealership) {
        this.dealership = dealership;
    }

    public void receiveCar() {
        try {
            for (int i = 0; i < size; i++) {
                Thread.sleep(RECEIVE_TIME);
                dealership.getCars().add(new Car());
                System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
                synchronized (this) {
                    notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (dealership.getCars().size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(BUY_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            dealership.soldCars++; // Увеличиваем счетчик проданных машин
            if (dealership.soldCars >= 10) {
                System.exit(0); // Завершаем программу
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dealership.getCars().remove(0);
    }

}
