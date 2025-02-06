package eus.ehu.bum1_fx.business_logic;

public interface ExchangeCalculator {

    String[] getCurrencyLongNames();
    double getChangeValue(String cur1, double amount, String cur2) throws Exception;
    double calculateCommission(double amount, String currency) throws Exception;
    boolean isCurrencyValid(String currency);
}
