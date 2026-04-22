package com.apps.quantitymeasurement;

import org.junit.Assert;
import org.junit.Test;

import com.apps.quantitymeasurement.Quantity.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Quantity oneYard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity threeFeet = new Quantity(3.0, LengthUnit.FEET);
        Assert.assertEquals(oneYard, threeFeet);
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Quantity oneYard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity thirtySixInches = new Quantity(36.0, LengthUnit.INCHES);
        Assert.assertEquals(oneYard, thirtySixInches);
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        Quantity oneCm = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity inches = new Quantity(0.393701, LengthUnit.INCHES);
        Assert.assertEquals(oneCm, inches);
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Quantity a = new Quantity(1.0, LengthUnit.YARDS);
        Quantity b = new Quantity(3.0, LengthUnit.FEET);
        Quantity c = new Quantity(36.0, LengthUnit.INCHES);

        Assert.assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }
}