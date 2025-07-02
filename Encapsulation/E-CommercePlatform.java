import java.util.ArrayList;

// Interface for tax-related products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        setPrice(price); // Use setter to ensure validation
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Setter with validation
    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            System.out.println("Price cannot be negative.");
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateDiscount();

    // Method to display common product details
    public void displayInfo() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Name         : " + name);
        System.out.println("Base Price   : ₹" + price);
    }
}

// Electronics class (taxable product)
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied to Electronics";
    }
}

// Clothing class (taxable product)
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public String getTaxDetails() {
        return "12% GST applied to Clothing";
    }
}

// Groceries class (non-taxable product)
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class to run the e-commerce platform
public class ECommercePlatform {
    // Method to calculate final price and print details
    public static void printFinalPrice(Product product) {
        product.displayInfo();

        double tax = 0;
        if (product instanceof Taxable) {
            Taxable taxable = (Taxable) product;
            tax = taxable.calculateTax();
            System.out.println("Tax Info     : " + taxable.getTaxDetails());
            System.out.println("Tax Amount   : ₹" + tax);
        } else {
            System.out.println("Tax Info     : No tax applicable");
        }

        double discount = product.calculateDiscount();
        System.out.println("Discount     : ₹" + discount);

        double finalPrice = product.getPrice() + tax - discount;
        System.out.println("Final Price  : ₹" + finalPrice);
        System.out.println("-----------------------------------------");
    }

    // Main method
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();

        productList.add(new Electronics(101, "Smartphone", 30000));
        productList.add(new Clothing(102, "T-Shirt", 1500));
        productList.add(new Groceries(103, "Wheat Flour (10kg)", 700));

        for (Product product : productList) {
            printFinalPrice(product); // Polymorphism in action
        }
    }
}
