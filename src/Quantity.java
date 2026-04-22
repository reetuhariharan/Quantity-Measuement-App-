public class Quantity{
    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");
        this.value = value;
        this.unit = unit;
    }

    // Static API for raw conversion
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) throw new IllegalArgumentException("Units cannot be null");
        return (value * source.getFactor()) / target.getFactor();
    }

    // Instance method for object-oriented conversion
    public Quantity convertTo(LengthUnit targetUnit) {
        return new Quantity(convert(this.value, this.unit, targetUnit), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;
        Quantity that = (Quantity) obj;
        return Math.abs((this.value * this.unit.getFactor()) - (that.value * that.unit.getFactor())) < 1e-6;
    }

    @Override
    public String toString() { return value + " " + unit; }
}