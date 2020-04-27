package patterns.creational.abstractfactory.factory;

import patterns.creational.abstractfactory.domain.Plan;
import patterns.creational.abstractfactory.domain.impl.CommercialPlan;
import patterns.creational.abstractfactory.domain.impl.DomesticPlan;
import patterns.creational.abstractfactory.domain.impl.InstitutionalPlan;
import patterns.creational.abstractfactory.exception.UnknownPlanTypeException;

import static patterns.creational.factory.PlanFactory.PlanType.values;

public class PlanFactory {

    public Plan getPlan(Type type) throws UnknownPlanTypeException {
        if (type == null) {
            throw new UnknownPlanTypeException("Type should not be null");
        }
        switch (type) {
            case Domestic:
                return new DomesticPlan();
            case Commercial:
                return new CommercialPlan();
            case Institutional:
                return new InstitutionalPlan();
            default:
                throw new UnknownPlanTypeException(String.format("Known types: %s", values()));
        }
    }
}
