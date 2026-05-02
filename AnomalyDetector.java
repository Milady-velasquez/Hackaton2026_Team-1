public class AnomalyDetector {

    public boolean isAnomaly(SensorData data) {

        if (data.ultrasonic < 20) {
            return true;
        }

        if (data.ir > 0.8) {
            return true;
        }

        return false;
    }
}