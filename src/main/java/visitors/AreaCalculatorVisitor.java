package visitors;

import elements.Circle;
import elements.Square;
import elements.Triangle;

public final class AreaCalculatorVisitor implements ShapeVisitor {

    private double totalArea = 0;

    @Override
    public void visitCircle(Circle circle) {
        double radius = circle.getRadius();
        totalArea += Math.PI * radius * radius;
    }

    @Override
    public void visitSquare(Square square) {
        double side = square.getSide();
        totalArea += side * side;
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        double side = triangle.getSide();
        totalArea += Math.sqrt(3) / 4 * side * side;
    }

    public double getTotalArea() {
        return totalArea;
    }
}
