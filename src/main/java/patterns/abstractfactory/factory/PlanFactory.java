package patterns.abstractfactory.factory;

import patterns.abstractfactory.domain.Plan;
import patterns.abstractfactory.domain.impl.CommercialPlan;
import patterns.abstractfactory.domain.impl.DomesticPlan;
import patterns.abstractfactory.domain.impl.InstitutionalPlan;
import patterns.abstractfactory.exception.UnknownPlanTypeException;

import static patterns.factory.PlanFactory.PlanType.values;

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
