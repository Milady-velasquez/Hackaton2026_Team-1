public class SensorData {
    double ultrasonic;
    double ir;

    public SensorData(double ultrasonic, double ir) {
        this.ultrasonic = ultrasonic;
        this.ir = ir;
    }

    public String toString() {
        return "[Ultrasonic=" + ultrasonic + ", IR=" + ir + "]";
    }
}