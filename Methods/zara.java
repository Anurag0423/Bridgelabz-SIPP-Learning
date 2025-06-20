import java.util.Random;

class Zara {

    public static double[][] generateEmployeeData(int n) {
        Random rand = new Random();
        double[][] data = new double[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); 
            data[i][1] = rand.nextInt(11); 
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        int n = employeeData.length;
        double[][] updatedData = new double[n][2];
        for (int i = 0; i < n; i++) {
            double salary = employeeData[i][0];
            int service = (int) employeeData[i][1];
            double bonus = service > 5 ? 0.05 * salary : 0.02 * salary;
            double newSalary = salary + bonus;
            updatedData[i][0] = Math.round(newSalary * 100.0) / 100.0;
            updatedData[i][1] = Math.round(bonus * 100.0) / 100.0;
        }
        return updatedData;
    }

    public static void displaySalaryReport(double[][] oldData, double[][] newData) {
        double sumOld = 0, sumNew = 0, totalBonus = 0;
        System.out.println("Emp\tOldSalary\tYearsService\tBonus\tNewSalary");
        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            int years = (int) oldData[i][1];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];
            System.out.println((i + 1) + "\t" + oldSalary + "\t\t" + years + "\t\t" + bonus + "\t" + newSalary);
            sumOld += oldSalary;
            sumNew += newSalary;
            totalBonus += bonus;
        }
        System.out.println("\nTotal Old Salary: " + sumOld);
        System.out.println("Total New Salary: " + sumNew);
        System.out.println("Total Bonus Paid: " + totalBonus);
    }

    public static void main(String[] args) {
        int n = 10;
        double[][] employeeData = generateEmployeeData(n);
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displaySalaryReport(employeeData, updatedData);
    }
}
