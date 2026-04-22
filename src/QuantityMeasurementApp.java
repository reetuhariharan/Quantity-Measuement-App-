import java.util.Objects;

/**
 * UC3: Generic Quantity Class to handle different units (Feet, Inch)
 * and eliminate code duplication (DRY Principle).
 */

// Step 1: Enum to define units and their conversion factors relative to a base unit (Feet)
enum LengthUnit {
    FEET(1.0),
    INCH(1.0 / 12.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getToFeetFactor() {
        return conversionFactor;
    }
}

// Step 2: Generic Quantity class
class Quantity {
    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Reflexive
        if (o == null || getClass() != o.getClass()) return false; // Null and Type check

        Quantity that = (Quantity) o;

        // Handle potential null units
        if (this.unit == null || that.unit == null) return false;

        // Convert both values to base unit (Feet) for comparison
        double value1 = this.value * this.unit.getToFeetFactor();
        double value2 = that.value * that.unit.getToFeetFactor();

        // Use epsilon for double comparison to handle precision
        return Math.abs(value1 - value2) < 1e-4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("Quantity Measurement App Loaded.");
    }
}