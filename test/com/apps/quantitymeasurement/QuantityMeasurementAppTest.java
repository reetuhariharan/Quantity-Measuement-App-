import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // 1. testEquality_SameValue()
    @Test
    public void givenSameValue_WhenCompared_ShouldReturnTrue() {
        QuantityMeasurementApp.Quantity inch1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.INCHES);
        QuantityMeasurementApp.Quantity inch2 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.INCHES);
        assertEquals(inch1, inch2);
    }

    // 2. testEquality_DifferentValue()
    @Test
    public void givenDifferentValue_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Quantity feet1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.FEET);
        QuantityMeasurementApp.Quantity feet2 = new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.Unit.FEET);
        assertNotEquals(feet1, feet2);
    }

    // 3. testEquality_NullComparison()
    @Test
    public void givenNullValue_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Quantity inch = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.INCHES);
        assertNotEquals(null, inch);
    }

    // 4. testEquality_TypeSafety() (Handles Non-Numeric/Different Object types)
    @Test
    public void givenDifferentObjectType_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Quantity feet = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.FEET);
        String notAQuantity = "1.0";
        assertNotEquals(feet, notAQuantity);
    }

    // 5. testEquality_SameReference()
    @Test
    public void givenSameReference_WhenCompared_ShouldReturnTrue() {
        QuantityMeasurementApp.Quantity inch = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.INCHES);
        assertEquals(inch, inch);
    }

    // Bonus: Ensure Units remain separate as per UC2 requirements
    @Test
    public void givenSameValueButDifferentUnits_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Quantity inch = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.INCHES);
        QuantityMeasurementApp.Quantity feet = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.FEET);
        assertNotEquals(inch, feet);
    }
}