package patterns.abstractfactory.factory;

public class FactoryCreator {

    public BudgetFactory getBudgetFactory() {
        return new BudgetFactory();
    }

    public PlanFactory getPlanFactory() {
        return new PlanFactory();
    }
}
