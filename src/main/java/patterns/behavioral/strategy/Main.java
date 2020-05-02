package patterns.behavioral.strategy;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        BigDecimal price = new BigDecimal(1.0);

        Discounter discounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));
        Discounter combinedDiscounters = discounter.combine(discounter);

        BigDecimal priceAfterAllDiscounts = combinedDiscounters.apply(price);
        
        System.out.println(priceAfterAllDiscounts);
    }
}
