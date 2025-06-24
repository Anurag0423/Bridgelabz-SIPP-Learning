package classes_and_objects;

public class MobilePhone {
	String brand;
	String model;
	double price;
	
	public MobilePhone(String brand, String model,double price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	 public void displayDetails() {
	        System.out.println("Mobile Phone Details:");
	        System.out.println("Brand : " + brand);
	        System.out.println("Model : " + model);
	        System.out.println("Price : ₹" + price);
	        System.out.println("--------------------------");
	    }

	    public static void main(String[] args) {
	        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S23", 74999.99);
	        MobilePhone phone2 = new MobilePhone("Apple", "iPhone 15", 89999.00);
	        MobilePhone phone3 = new MobilePhone("OnePlus", "Nord CE 3", 24999.50);

	        phone1.displayDetails();
	        phone2.displayDetails();
	        phone3.displayDetails();
	    }
	}
