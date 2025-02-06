package eus.ehu.bum1_fx.business_logic;

public interface ExchangeCalculator {

    String[] getCurrencyLongNames();
    double getChangeValue(String origCurrency, double amount, String endCurrency) throws Exception;
    double calculateCommission(double amount, String currency) throws Exception;
    boolean isCurrencyValid(String origCurrency);
}
