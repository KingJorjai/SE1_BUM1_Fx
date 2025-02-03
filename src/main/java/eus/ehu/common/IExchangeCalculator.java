package eus.ehu.common;

import eus.ehu.backend.Currency;

public interface IExchangeCalculator {

    String[] getCurrencyLongNames();
    double getChangeValue(Currency cur1, double amount, Currency cur2) throws Exception;
    double calculateCommission(double amount, Currency currency) throws Exception;
}
