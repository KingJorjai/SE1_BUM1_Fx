package eus.ehu.bum1_fx.business_logic;

public class BarcenaysCalculator implements ExchangeCalculator {

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
    public double calculateCommission(double amount, String origCurrency) {

        CommissionCalculator cc = new CommissionCalculator(amount, origCurrency);
        double commission;
        try {
            commission = cc.calculateCommission();
        } catch (Exception e) {
            commission = -1;
        }
        return commission;
    }
}
