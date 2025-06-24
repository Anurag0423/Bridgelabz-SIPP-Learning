package classes_and_objects;

public class Item {
	int itemCode;
	String itemName;
	double itemPrice;
	
	public Item(int itemCode, String itemName, double itemPrice) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public void displayDetails() {
		System.out.println("Item Details: ");
		System.out.println("Item Code: " + itemCode);
		System.out.println("Item Name: " + itemName);
		System.out.println("Item Price: "+ itemPrice);
	}
	
	public static void main(String... args) {
		Item item1 = new Item(12354, "Cookies", 99.00);
		item1.displayDetails();
	}
}
