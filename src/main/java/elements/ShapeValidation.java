
package elements;

public final class ShapeValidation {

    private ShapeValidation() {
    }

    public static void requirePositive(double value, String name) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException(
                    name + " must be positive and finite"
            );
        }
    }
}
