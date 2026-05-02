import java.util.Random;

public class SensorSimulator {

    Random rand = new Random();

    public SensorData readSensors() {

        // Normal values
        double ultrasonic = 50 + rand.nextGaussian() * 5;
        double ir = rand.nextDouble();

        // Inject random anomaly (simulating crack)
        if (rand.nextInt(10) == 0) {
            ultrasonic = 10; // abnormal reflection
            ir = 0.95;
        }

        return new SensorData(ultrasonic, ir);
    }
}