package enums;

public enum CategoryTaxEnum {
    A(10), B(20), C(0);

    private double tax;

    CategoryTaxEnum(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }
}
