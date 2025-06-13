import java.util.*;
class ProfitCalculator {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;

        int profit = sellingPrice - costPrice;
        double profitPercent = (profit * 100.0) / costPrice;

        System.out.printf(
            "The Cost Price is INR %d and the Selling Price is INR %d\nThe Profit is INR %d and the Profit Percentage is %.2f%%\n",
            costPrice, sellingPrice, profit, profitPercent
        );
    }
}
