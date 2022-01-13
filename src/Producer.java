import java.util.Random;

public class Producer extends Thread{
    private Monitor cars;

    private int productionTime;
    private final static int MAX_PROD_TIME = 5000;
    private int numProductions;
    private String car;
    private static String carModels [] = {
        "Seat León",
        "Audi accidentado",
        "Nissan Qashqai",
        "Citröen Berlingo",
        "Volkswagen Polo",
        "Opel Meriva",
        "Fiat Punto",
        "Tesla Roadster",
        "Hyundai Ioniq"
    };
    
    public Producer (Monitor monitor, int numProductions){  
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
                car = getRandomModel();
                cars.add(car);
                System.out.println("Se ha fabricado un " + car + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getRandomModel() {
        Random random = new Random();
        String model = carModels[random.nextInt(carModels.length - 1)];
        return model;
    }

    private static int getRandomProductionTime() {
        Random random = new Random();
        int prodTime = random.nextInt(MAX_PROD_TIME);
        return prodTime;
    }
}
