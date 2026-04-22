import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementAppTest {

    // Test: 1.0 Feet == 1.0 Feet
    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Quantity f1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity f2 = new Quantity(1.0, LengthUnit.FEET);
        Assert.assertEquals(f1, f2);
    }

    // Test: 1.0 Inch == 1.0 Inch
    @Test
    public void testEquality_InchToInch_SameValue() {
        Quantity i1 = new Quantity(1.0, LengthUnit.INCH);
        Quantity i2 = new Quantity(1.0, LengthUnit.INCH);
        Assert.assertEquals(i1, i2);
    }

    // Test Cross-Unit: 1.0 Feet == 12.0 Inches
    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Quantity inches = new Quantity(12.0, LengthUnit.INCH);
        Assert.assertEquals(feet, inches);
    }

    // Test Symmetry: 12.0 Inches == 1.0 Feet
    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Quantity inches = new Quantity(12.0, LengthUnit.INCH);
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Assert.assertEquals(inches, feet);
    }

    // Test: 1.0 Feet != 2.0 Feet
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Quantity f1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity f2 = new Quantity(2.0, LengthUnit.FEET);
        Assert.assertNotEquals(f1, f2);
    }

    // Test Reflexive: a.equals(a)
    @Test
    public void testEquality_SameReference() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Assert.assertEquals(feet, feet);
    }

    // Test Null Comparison: a.equals(null) is false
    @Test
    public void testEquality_NullComparison() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Assert.assertNotEquals(null, feet);
    }
}