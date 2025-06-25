public class Product {
    // 1. Static: shared discount across all products
    static double discount = 10.0; // default discount in percentage

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to " + discount + "%");
    }

    // 2. Final: productID can't be changed
    private final String productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // 3. Constructor using 'this'
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // 4. Display details using instanceof
    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("\n--- Product Details ---");
            System.out.println("Product ID     : " + productID);
            System.out.println("Product Name   : " + productName);
            System.out.println("Unit Price     : ₹" + price);
            System.out.println("Quantity       : " + quantity);
            System.out.println("Discount       : " + discount + "%");

            double total = price * quantity;
            double finalPrice = total - (total * discount / 100);
            System.out.println("Total Price (After Discount): ₹" + finalPrice);
        } else {
            System.out.println("Invalid product object.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Update shared discount
        Product.updateDiscount(15.0);

        // Create Product objects
        Product p1 = new Product("P101", "Smartphone", 20000.0, 1);
        Product p2 = new Product("P102", "Headphones", 1500.0, 2);

        // Display product details
        p1.displayDetails();
        p2.displayDetails();
    }
}
