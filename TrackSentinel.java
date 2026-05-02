import java.util.Random;

public class TrackSentinel {

    private static final double ULTRASONIC_THRESHOLD = 100.0;
    private static final int IR_NORMAL_SIGNAL = 1;

    private static final Random rand = new Random();

    public static void main(String[] args) {

        System.out.println("Starting Autonomous Track Inspection...");

        // =========================
        // OPTION 3: AUTO STOP
        // =========================
        int maxCycles = 20;   // how many times the loop runs
        int count = 0;

        while (true) {

            count++;

            // =========================
            // SENSOR SIMULATION
            // =========================
            double ultrasonicValue = readUltrasonic();
            int irValue = readIR();

            System.out.println("Cycle " + count +
                    " | Ultrasonic: " + ultrasonicValue +
                    " | IR: " + irValue);

            // =========================
            // ANOMALY DETECTION
            // =========================
            if (ultrasonicValue > ULTRASONIC_THRESHOLD || irValue != IR_NORMAL_SIGNAL) {

                if (verifyDefect()) {
                    handleDefectDetected();
                }
            }

            // =========================
            // STOP CONDITION (OPTION 3)
            // =========================
            if (count >= maxCycles) {
                System.out.println("System shutdown: reached max cycles (" + maxCycles + ")");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // =========================
    // SENSOR METHODS
    // =========================
    private static double readUltrasonic() {
        double value = 70 + rand.nextDouble()*80;
        return Math.round(value*100.0) / 100.0;
    }

    private static int readIR() {
        return rand.nextDouble() > 0.1 ? 1 : 0;
    }

    // =========================
    // VERIFICATION
    // =========================
    private static boolean verifyDefect() {

        int confirmations = 0;

        for (int i = 0; i < 5; i++) {
            if (readUltrasonic() > ULTRASONIC_THRESHOLD) {
                confirmations++;
            }
        }

        return confirmations > 3;
    }

    // =========================
    // ALERT SYSTEM
    // =========================
    private static void handleDefectDetected() {

        String location = getCurrentCoordinates();
        String message = "CRITICAL: Rail Fracture Detected at " + location;

        System.err.println(message);
        sendSMS("+15550123", message);
    }

    // =========================
    // GPS SIMULATION
    // =========================
    private static String getCurrentCoordinates() {

        double lat = Math.round((34.05 + rand.nextDouble() * 0.01) * 10000.0) / 10000.0;
        double lon = Math.round((-118.24 + rand.nextDouble() * 0.01) * 10000.0) / 10000.0;

        return lat + ", " + lon;
    }

    // =========================
    // GSM SIMULATION
    // =========================
    private static void sendSMS(String number, String message) {

        System.out.println("[GSM] Sending SMS to " + number);
        System.out.println("[GSM] MESSAGE: " + message);
    }
}

/*

  ----jGRASP exec: java TrackSentinel
 Starting Autonomous Track Inspection...
 Cycle 1 | Ultrasonic: 138.72 | IR: 1
 Cycle 2 | Ultrasonic: 79.74 | IR: 1
 Cycle 3 | Ultrasonic: 105.05 | IR: 1
 Cycle 4 | Ultrasonic: 114.34 | IR: 1
 CRITICAL: Rail Fracture Detected at 34.0556, -118.2351
 [GSM] Sending SMS to +15550123
 [GSM] MESSAGE: CRITICAL: Rail Fracture Detected at 34.0556, -118.2351
 Cycle 5 | Ultrasonic: 119.83 | IR: 1
 Cycle 6 | Ultrasonic: 143.92 | IR: 1
 CRITICAL: Rail Fracture Detected at 34.053, -118.2301
 [GSM] Sending SMS to +15550123
 [GSM] MESSAGE: CRITICAL: Rail Fracture Detected at 34.053, -118.2301
 Cycle 7 | Ultrasonic: 115.79 | IR: 1
 CRITICAL: Rail Fracture Detected at 34.0588, -118.2311
 [GSM] Sending SMS to +15550123
 [GSM] MESSAGE: CRITICAL: Rail Fracture Detected at 34.0588, -118.2311
 Cycle 8 | Ultrasonic: 87.18 | IR: 1
 Cycle 9 | Ultrasonic: 108.76 | IR: 1
 Cycle 10 | Ultrasonic: 144.43 | IR: 1
 Cycle 11 | Ultrasonic: 102.27 | IR: 1
 Cycle 12 | Ultrasonic: 116.43 | IR: 1
 Cycle 13 | Ultrasonic: 147.53 | IR: 1
 Cycle 14 | Ultrasonic: 129.9 | IR: 1
 Cycle 15 | Ultrasonic: 101.47 | IR: 1
 Cycle 16 | Ultrasonic: 82.22 | IR: 1
 Cycle 17 | Ultrasonic: 109.76 | IR: 1
 CRITICAL: Rail Fracture Detected at 34.0567, -118.2374
 [GSM] Sending SMS to +15550123
 [GSM] MESSAGE: CRITICAL: Rail Fracture Detected at 34.0567, -118.2374
 Cycle 18 | Ultrasonic: 96.96 | IR: 1
 Cycle 19 | Ultrasonic: 77.04 | IR: 1
 Cycle 20 | Ultrasonic: 76.26 | IR: 1
 System shutdown: reached max cycles (20)
 
  ----jGRASP: Operation complete.
 
*/
