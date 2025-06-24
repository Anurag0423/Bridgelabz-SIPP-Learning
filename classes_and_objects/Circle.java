package classes_and_objects;

public class Circle {
	double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double calculateArea() {
		return Math.PI * radius * radius;
	}
	
	public double calculateCircumference() {
		return 2 * Math.PI * radius;
	}
	public void diaplay() {
		System.out.println("Radius: " + radius);
		System.out.println("Circumference: " + calculateCircumference());
		System.out.println("Area: " + calculateArea());

	}
	public static void main(String[] args) {
		Circle c = new Circle(5.0);
		c.diaplay();
	}
}
