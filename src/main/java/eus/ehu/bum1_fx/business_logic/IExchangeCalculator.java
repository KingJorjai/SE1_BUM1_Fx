package eus.ehu.bum1_fx.business_logic;

public interface IExchangeCalculator {

    String[] getCurrencyLongNames();
    double getChangeValue(String origCurrency, double amount, String endCurrency) throws Exception;
    double calculateCommission(double amount, String origCurrency) throws Exception;
    boolean isCurrencyValid(String origCurrency);
}
