import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest{

    @Test
    void testConversion_FeetToInches() {
        // 1.0 Feet should be 12.0 Inches
        assertEquals(12.0, Quantity.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), 1e-6);
    }

    @Test
    void testConversion_YardsToInches() {
        // 1.0 Yard should be 36.0 Inches
        assertEquals(36.0, Quantity.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES), 1e-6);
    }

    @Test
    void testConversion_CentimetersToInches() {
        // 2.54 cm is approximately 1.0 Inch
        assertEquals(1.0, Quantity.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES), 0.01);
    }

    @Test
    void testEquality_CrossUnits() {
        Quantity oneYard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity threeFeet = new Quantity(3.0, LengthUnit.FEET);
        assertEquals(oneYard, threeFeet);
    }

    @Test
    void testConversion_InvalidInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Quantity.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES);
        });
    }

    @Test
    void testRoundTrip_PreservesValue() {
        double original = 10.0;
        double toInches = Quantity.convert(original, LengthUnit.FEET, LengthUnit.INCHES);
        double backToFeet = Quantity.convert(toInches, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(original, backToFeet, 1e-6);
    }
}