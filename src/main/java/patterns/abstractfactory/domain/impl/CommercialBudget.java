package patterns.abstractfactory.domain.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.abstractfactory.domain.Budget;

public class CommercialBudget extends Budget {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommercialBudget.class);

    @Override
    public void getMoney() {
        LOGGER.info("Commercial money");
    }
}
