// Category interfaces
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Generic Product class
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        this.price -= this.price * (percentage / 100);
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

// Utility class with generic method
class DiscountUtils {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Discount applied to " + product.getName() +
                " [" + product.getCategory().getCategoryName() + "]: New price = ₹" + product.getPrice());
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 499.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 999.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15999.0, new GadgetCategory());

        // Apply discounts using generic method
        DiscountUtils.applyDiscount(book, 10);     // 10% off
        DiscountUtils.applyDiscount(shirt, 20);    // 20% off
        DiscountUtils.applyDiscount(phone, 15);    // 15% off
    }
}
