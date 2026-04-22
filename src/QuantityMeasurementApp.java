public class QuantityMeasurementApp {

    public enum Unit {
        FEET, INCHES
    }

    public static class Quantity {
        private final double value;
        private final Unit unit;

        public Quantity(double value, Unit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quantity quantity = (Quantity) o;
            // Note: This UC2 implementation keeps units separate as per requirements
            return Double.compare(quantity.value, value) == 0 && unit == quantity.unit;
        }
    }

    public static boolean checkEquality(double val1, double val2, Unit unit) {
        Quantity q1 = new Quantity(val1, unit);
        Quantity q2 = new Quantity(val2, unit);
        return q1.equals(q2);
    }

    public static void main(String[] args) {
        System.out.println("1.0 inch == 1.0 inch: " + checkEquality(1.0, 1.0, Unit.INCHES));
        System.out.println("1.0 ft == 1.0 ft: " + checkEquality(1.0, 1.0, Unit.FEET));
    }
}