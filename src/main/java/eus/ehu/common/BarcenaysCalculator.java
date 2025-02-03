package eus.ehu.common;

import eus.ehu.backend.CommissionCalculator;
import eus.ehu.backend.Currency;
import eus.ehu.backend.ForexOperator;

public class BarcenaysCalculator implements IExchangeCalculator {

    @Override
    public String[] getCurrencyLongNames() {
        return Currency.longNames();
    }

    @Override
    public double getChangeValue(Currency cur1, double amount, Currency cur2) throws Exception {
        ForexOperator fo = new ForexOperator(cur1.name(), amount, cur2.name());
        return fo.getChangeValue();
    }

    @Override
    public double calculateCommission(double amount, Currency currency) throws Exception {
        CommissionCalculator cc = new CommissionCalculator(amount, currency.name());
        return cc.calculateCommission();
    }
}
