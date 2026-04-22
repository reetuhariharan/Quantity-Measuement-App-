public enum LengthUnit {
    INCHES(1.0 / 12.0),
    FEET(1.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double factor;
    LengthUnit(double factor) { this.factor = factor; }
    public double getFactor() { return factor; }
}
