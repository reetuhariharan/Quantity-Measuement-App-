package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // 1. Same reference
            if (this == obj) return true;

            // 2. Null or different class
            if (obj == null || getClass() != obj.getClass()) return false;

            // 3. Cast
            Feet feet = (Feet) obj;

            // 4. Compare values
            return Double.compare(feet.value, this.value) == 0;
        }
    }

    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println(f1.equals(f2)); // should print true
    }
}