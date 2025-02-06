package eus.ehu.bum_fx.business_logic;

public class BarcenaysCalculator implements IExchangeCalculator {

    @Override
    public String[] getCurrencyLongNames() {
        return Currency.longNames();
    }

    @Override
    public double getChangeValue(String cur1, double amount, String cur2) throws Exception {
        ForexOperator fo = new ForexOperator(cur1, amount, cur2);
        return fo.getChangeValue();
    }

    @Override
    public double calculateCommission(double amount, String currency) throws Exception {

        CommissionCalculator cc = new CommissionCalculator(amount, currency);
        return cc.calculateCommission();
    }

    @Override
    public boolean isCurrencyValid(String currency) {
        try {
            Currency.valueOf(currency);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
