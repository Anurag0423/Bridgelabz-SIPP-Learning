import java.util.*;
class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378.0;
        double pi = Math.PI;
        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);
        double kmToMilesFactor = Math.pow(0.621371, 3);
        double volumeMiles3 = volumeKm3 * kmToMilesFactor;
        System.out.printf("The volume of Earth in cubic kilometers is %.2f and cubic miles is %.2f\n", volumeKm3, volumeMiles3);
    }
}
