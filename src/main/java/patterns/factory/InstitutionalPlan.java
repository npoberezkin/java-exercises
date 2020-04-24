package patterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstitutionalPlan extends Plan {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstitutionalPlan.class);

    @Override
    public void getRate() {
        LOGGER.info("Institutional rate");
    }
}
