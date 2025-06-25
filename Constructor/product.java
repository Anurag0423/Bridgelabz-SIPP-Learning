public class Product {
    // Instance Variables
    private String productName;
    private double price;

    // Class Variable (Static)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment count whenever a new product is created
    }

    // Instance Method
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class Method
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main Method to Test
    public static void main(String[] args) {
        // Creating products
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Smartphone", 22000);
        Product p3 = new Product("Headphones", 3000);

        // Display product details
        System.out.println("Product 1:");
        p1.displayProductDetails();

        System.out.println("\nProduct 2:");
        p2.displayProductDetails();

        System.out.println("\nProduct 3:");
        p3.displayProductDetails();

        System.out.println();
        // Display total products
        Product.displayTotalProducts();
    }
}
