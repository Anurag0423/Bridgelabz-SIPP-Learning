import java.util.Scanner;

class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        if (temperature <= 50 && windSpeed >= 3) {
            return 35.74 + (0.6215 * temperature) - 
                   (35.75 * Math.pow(windSpeed, 0.16)) + 
                   (0.4275 * temperature * Math.pow(windSpeed, 0.16));
        } else {
            return temperature;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (in Fahrenheit): ");
        double temperature = sc.nextDouble();
        System.out.print("Enter wind speed (in mph): ");
        double windSpeed = sc.nextDouble();
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("Wind Chill Temperature: %.2f°F\n", windChill);
        sc.close();
    }
}
