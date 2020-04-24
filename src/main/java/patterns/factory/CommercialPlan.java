package patterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommercialPlan extends Plan {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommercialPlan.class);

    @Override
    public void getRate() {
        LOGGER.info("Commercial rate");
    }
}
