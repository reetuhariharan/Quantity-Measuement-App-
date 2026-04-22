package com.apps.quantitymeasurement;

public class Quantity {
    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        public final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity that = (Quantity) o;

        double thisInInches = this.value * this.unit.factor;
        double thatInInches = that.value * that.unit.factor;

        return Math.abs(thisInInches - thatInInches) < 0.01;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value * unit.factor);
    }
}