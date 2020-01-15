package patterns.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();

    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    @Override
    public String toString() {
        return "patterns.builder.Pizza{" +
                "toppings=" + toppings +
                '}';
    }
}