package app;
import java.util.List;
import java.util.Arrays;
import elements.Circle;
import elements.Shape;
import elements.Square;
import elements.Triangle;
import visitors.AreaCalculatorVisitor;
import visitors.ExportVisitor;
import visitors.PerimeterCalculatorVisitor;



public class SimpleTest {

    public static void main(String[] args) {

        List<Shape> shapes = Arrays.asList(
                new Circle(2),
                new Square(3),
                new Triangle(4)
        );

        AreaCalculatorVisitor area = new AreaCalculatorVisitor();
        PerimeterCalculatorVisitor perimeter = new PerimeterCalculatorVisitor();
        ExportVisitor export = new ExportVisitor();

        for (Shape shape : shapes) {
            shape.accept(area);
            shape.accept(perimeter);
            shape.accept(export);
        }

        double expectedArea = 4 * Math.PI + 9 + 4 * Math.sqrt(3);
        double expectedPerimeter = 4 * Math.PI + 24;

        check("Area",
                Math.abs(area.getTotalArea() - expectedArea) < 0.0001);

        check("Perimeter",
                Math.abs(perimeter.getTotalPerimeter() - expectedPerimeter) < 0.0001);

        String xml = export.getXml();

        check("XML Export",
                xml.contains("<circle radius=\"2.0\"/>")
                        && xml.contains("<square side=\"3.0\"/>")
                        && xml.contains("<triangle side=\"4.0\"/>"));

        boolean invalidSizeRejected = false;

        try {
            new Circle(-1);
        } catch (IllegalArgumentException e) {
            invalidSizeRejected = true;
        }

        check("Validation", invalidSizeRejected);
    }

    private static void check(String name, boolean passed) {
        System.out.println(name + " test: " + (passed ? "PASS" : "FAIL"));

        if (!passed) {
            throw new AssertionError(name + " test failed");
        }
    }
}
