
package elements;

import visitors.ShapeVisitor;

public final class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        ShapeValidation.requirePositive(radius, "Radius");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}
