public class Main {

    public static final int BUYERS = 3;
    static final int STOP_TIME = 1000;

    public static void main(String[] args) {
        final Dealership dealership = new Dealership();

        // Покупатели, чья работа заключается в том, чтобы купить машину - dealership.sellCar()
        for (int i = 1; i <= BUYERS; i++) {
            new Thread(null, () -> {
                while (true) {
                    dealership.sellCar();
                    try {
                        Thread.sleep(STOP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Покупатель " + i).start(); // Зацикливаем покупку
        }

        // Производитель машины, чья работа заключается в том, чтобы привезти машину в салон - dealership.acceptCar()
        new Thread(null, dealership::acceptCar, "Производитель Toyota").start();
    }

}
