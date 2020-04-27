package patterns.creational.factory;

import patterns.creational.factory.domain.Plan;
import patterns.creational.factory.domain.impl.CommercialPlan;
import patterns.creational.factory.domain.impl.DomesticPlan;
import patterns.creational.factory.domain.impl.InstitutionalPlan;

import static patterns.creational.factory.PlanFactory.PlanType.values;

public class PlanFactory {

    public enum PlanType {
        Domestic, Institutional, Commercial
    }

    Plan getPlan(PlanType type) throws UnknownPlanTypeException {
        if (type == null) {
            throw new UnknownPlanTypeException("PlanType should not be null");
        }
        switch (type) {
            case Domestic:
                return new DomesticPlan();
            case Commercial:
                return new CommercialPlan();
            case Institutional:
                return new InstitutionalPlan();
            default:
                throw new UnknownPlanTypeException(String.format("Known plan types: %s", values()));
        }
    }
}
