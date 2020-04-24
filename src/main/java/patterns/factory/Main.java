package patterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.factory.domain.Plan;

import static patterns.factory.PlanFactory.PlanType.*;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws UnknownPlanTypeException {
        PlanFactory factory = new PlanFactory();
        Plan domesticPlan = factory.getPlan(Domestic);
        Plan commercialPlan = factory.getPlan(Commercial);
        Plan institutionalPlan = factory.getPlan(Institutional);
        try {
            factory.getPlan(null);
        } catch (UnknownPlanTypeException e) {
            LOGGER.info("Type cannot be null");
        }
        domesticPlan.getRate();
        commercialPlan.getRate();
        institutionalPlan.getRate();
    }
}
