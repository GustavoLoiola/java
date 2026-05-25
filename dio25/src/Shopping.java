import java.math.BigDecimal;

public class Shopping {
    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("249.90");

        BigDecimal discount = new BigDecimal("15.50");

        BigDecimal freight = new BigDecimal("20.00");

        BigDecimal finalValue = value.add(freight).subtract(discount);

        System.out.println("O valor final é de: " + finalValue);

    }
}