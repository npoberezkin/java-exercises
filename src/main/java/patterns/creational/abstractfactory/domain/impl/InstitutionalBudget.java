package patterns.creational.abstractfactory.domain.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.creational.abstractfactory.domain.Budget;

public class InstitutionalBudget extends Budget {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstitutionalBudget.class);

    @Override
    public void getMoney() {
        LOGGER.info("Institutional money");
    }
}
