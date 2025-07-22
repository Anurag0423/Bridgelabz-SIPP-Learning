import java.util.*;

// Base abstract class for all warehouse items
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getCategory();
}

// Subclass: Electronics
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

// Subclass: Groceries
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}

// Subclass: Furniture
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}

// Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility class with wildcard method
class StorageUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName() + " (" + item.getCategory() + ")");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Bread"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chair"));

        // Display items
        System.out.println("Electronics:");
        StorageUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        StorageUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        StorageUtils.displayItems(furnitureStorage.getItems());
    }
}
