package CurrencyConverter;

/**
 *  Brian Dao
 *  11/25/2022
 */

public enum Currencies {
    USD(1.0, 1.0),
    EUR(0.96, 1.04),
    JPY(139.1, 0.0072),
    VND(24770.00, 0.000040),
    MXN(19.34, 0.052),
    KRW(1335.56,0.00075);

    public final double valueFrom;
    public final double valueTo;

    private Currencies(double valueFrom, double valueTo) {
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
    }
}
