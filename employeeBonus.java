import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee's salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter employee's years of service: ");
        int years = sc.nextInt();

        if (years > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus amount: ₹" + bonus);
        } else {
            System.out.println("No bonus. Service must be more than 5 years.");
        }

        sc.close();
    }
}
