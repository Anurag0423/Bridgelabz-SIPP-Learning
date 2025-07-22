import java.util.*;

// MealPlan interface
interface MealPlan {
    String getMealType();
    int getCalories();
}

// Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public int getCalories() {
        return 500;
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public int getCalories() {
        return 450;
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public int getCalories() {
        return 600;
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public int getCalories() {
        return 700;
    }
}

// Generic class to handle different meal plans
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void showMealDetails() {
        System.out.println("Meal Type: " + meal.getMealType());
        System.out.println("Calories: " + meal.getCalories());
    }

    public T getMeal() {
        return meal;
    }
}

// Utility class with generic method to generate personalized plan
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generatePlan(T meal) {
        System.out.println("Generating personalized meal plan...");
        return new Meal<>(meal);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create different meal plans
        VegetarianMeal vegMeal = new VegetarianMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal proteinMeal = new HighProteinMeal();

        // Generate and show plans using generic method
        Meal<VegetarianMeal> vegPlan = MealPlanGenerator.generatePlan(vegMeal);
        vegPlan.showMealDetails();

        System.out.println();

        Meal<KetoMeal> ketoPlan = MealPlanGenerator.generatePlan(ketoMeal);
        ketoPlan.showMealDetails();

        System.out.println();

        Meal<HighProteinMeal> proteinPlan = MealPlanGenerator.generatePlan(proteinMeal);
        proteinPlan.showMealDetails();
    }
}
