package patterns.creational.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patterns.creational.abstractfactory.domain.Budget;
import patterns.creational.abstractfactory.domain.Plan;
import patterns.creational.abstractfactory.exception.UnknownPlanTypeException;
import patterns.creational.abstractfactory.factory.BudgetFactory;
import patterns.creational.abstractfactory.factory.FactoryCreator;
import patterns.creational.abstractfactory.factory.PlanFactory;

import static patterns.creational.abstractfactory.factory.Type.*;

;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws UnknownPlanTypeException {
        FactoryCreator creator = new FactoryCreator();

        PlanFactory planFactory = creator.getPlanFactory();
        Plan domesticPlan = planFactory.getPlan(Domestic);
        Plan commercialPlan = planFactory.getPlan(Commercial);
        Plan institutionalPlan = planFactory.getPlan(Institutional);
        try {
            planFactory.getPlan(null);
        } catch (UnknownPlanTypeException e) {
            LOGGER.info("Type cannot be null");
        }
        domesticPlan.getRate();
        commercialPlan.getRate();
        institutionalPlan.getRate();

        BudgetFactory budgetFactory = creator.getBudgetFactory();
        Budget domesticBudget = budgetFactory.getBudget(Domestic);
        Budget commercialBudget = budgetFactory.getBudget(Commercial);
        Budget institutionalBudget = budgetFactory.getBudget(Institutional);
        try {
            budgetFactory.getBudget(null);
        } catch (UnknownPlanTypeException e) {
            LOGGER.info("Type cannot be null");
        }
        domesticBudget.getMoney();
        commercialBudget.getMoney();
        institutionalBudget.getMoney();
    }
}
