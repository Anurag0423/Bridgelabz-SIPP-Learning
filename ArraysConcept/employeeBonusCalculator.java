import java.util.Scanner;

class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int EMPLOYEE_COUNT = 10;
        double[] salaries = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonuses = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.print("Years of Service: ");
            double service = sc.nextDouble();

            if (salary <= 0 || service < 0) {
                System.out.println("Invalid input! Please enter again.\n");
                i--; // repeat for same index
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = service;
        }
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double bonusPercent = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercent;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        System.out.println("\nEmployee Bonus and New Salary Details:");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d -> Old Salary: ₹%.2f, Bonus: ₹%.2f, New Salary: ₹%.2f\n",
                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }

        System.out.printf("\nTotal Old Salary Payout: ₹%.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Payout: ₹%.2f\n", totalBonus);
        System.out.printf("Total New Salary Payout: ₹%.2f\n", totalNewSalary);

        sc.close();
    }
}
