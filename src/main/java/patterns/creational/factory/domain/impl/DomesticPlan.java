package patterns.creational.factory.domain.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.creational.factory.domain.Plan;

public class DomesticPlan extends Plan {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomesticPlan.class);

    @Override
    public void getRate() {
        LOGGER.info("Domestic rate");
    }
}
