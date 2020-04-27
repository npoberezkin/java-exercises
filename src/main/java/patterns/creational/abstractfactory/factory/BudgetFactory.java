package patterns.creational.abstractfactory.factory;

import patterns.creational.abstractfactory.domain.Budget;
import patterns.creational.abstractfactory.domain.impl.CommercialBudget;
import patterns.creational.abstractfactory.domain.impl.DomesticBudget;
import patterns.creational.abstractfactory.domain.impl.InstitutionalBudget;
import patterns.creational.abstractfactory.exception.UnknownPlanTypeException;

import static patterns.creational.factory.PlanFactory.PlanType.values;

public class BudgetFactory {

    public Budget getBudget(Type type) throws UnknownPlanTypeException {
        if (type == null) {
            throw new UnknownPlanTypeException("Type should not be null");
        }
        switch (type) {
            case Domestic:
                return new DomesticBudget();
            case Commercial:
                return new CommercialBudget();
            case Institutional:
                return new InstitutionalBudget();
            default:
                throw new UnknownPlanTypeException(String.format("Known types: %s", values()));
        }
    }
}
