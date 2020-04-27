package patterns.creational.builder.insideclass;

import java.util.Objects;

public class MyPizza extends Pizza {
    public enum Size {SMALL, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public MyPizza build() {
            return new MyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public MyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return super.toString() +
                "patterns.creational.builder.inside.MyPizza{" +
                "size=" + size +
                '}';
    }
}
