public class GPSModule {

    public static String getCurrentCoordinates() {

        double lat = 34.05 + Math.random() * 0.01;
        double lon = -118.24 + Math.random() * 0.01;

        return lat + ", " + lon;
    }
}