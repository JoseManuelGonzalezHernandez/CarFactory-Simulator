import java.util.Random;

public class Commercial extends Thread{
    private Monitor cars;

    private int numProductions;
    private int productionTime;
    private final static int MAX_SELL_TIME = 5000;
    private String car;

    public Commercial (Monitor monitor, int numProductions){  
        cars = monitor;
        this.numProductions = numProductions;
    }

    @Override
    public void run () {
        super.run ();
        try {
            for (int i = 0; i < numProductions; i++) {
                productionTime = getRandomProductionTime();
                sleep(productionTime);
                car = cars.sell();
                System.out.println("Se ha vendido un " + car + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getRandomProductionTime() {
        Random random = new Random();
        int prodTime = random.nextInt(MAX_SELL_TIME);
        return prodTime;
    }
}
