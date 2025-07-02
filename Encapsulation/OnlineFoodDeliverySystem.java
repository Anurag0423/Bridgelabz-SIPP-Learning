import java.util.ArrayList;

// Discountable interface
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;   // base price per item
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        setPrice(price);
        setQuantity(quantity);
    }

    // Getters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Encapsulated setters with validation
    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            System.out.println("Invalid price.");
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
        else
            System.out.println("Invalid quantity.");
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item        : " + itemName);
        System.out.println("Price       : ₹" + price);
        System.out.println("Quantity    : " + quantity);
        System.out.println("Total Price : ₹" + calculateTotalPrice());
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discountPercent = 0.0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discountPercent / 100);
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100)
            discountPercent = percent;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on VegItem: " + discountPercent + "%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double discountPercent = 0.0;
    private static final double NON_VEG_CHARGE = 30.0; // extra per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + NON_VEG_CHARGE) * getQuantity();
        return total - (total * discountPercent / 100);
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100)
            discountPercent = percent;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount on NonVegItem: " + discountPercent + "%";
    }
}

// Main class
public class FoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            System.out.println(d.getDiscountDetails());
        }
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<FoodItem> orderList = new ArrayList<>();

        VegItem paneer = new VegItem("Paneer Butter Masala", 180, 2);
        paneer.applyDiscount(10);

        NonVegItem chicken = new NonVegItem("Chicken Biryani", 220, 3);
        chicken.applyDiscount(5);

        orderList.add(paneer);
        orderList.add(chicken);

        System.out.println("----- Order Summary -----\n");
        for (FoodItem item : orderList) {
            processOrder(item); // Polymorphism in action
        }
    }
}
