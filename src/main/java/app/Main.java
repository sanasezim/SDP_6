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
import visitors.ShapeVisitor;


import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        List<Shape> shapes = Arrays.asList(
                new Circle(2),
                new Square(3),
                new Triangle(4)
        );

        AreaCalculatorVisitor area = new AreaCalculatorVisitor();
        PerimeterCalculatorVisitor perimeter = new PerimeterCalculatorVisitor();
        ExportVisitor export = new ExportVisitor();

        applyVisitor(shapes, area);
        applyVisitor(shapes, perimeter);
        applyVisitor(shapes, export);

        System.out.printf(Locale.US,
                "Total area: %.2f%n", area.getTotalArea());

        System.out.printf(Locale.US,
                "Total perimeter: %.2f%n", perimeter.getTotalPerimeter());

        System.out.println("\nXML Export:");
        System.out.println(export.getXml());
    }

    private static void applyVisitor(List<Shape> shapes,
                                     ShapeVisitor visitor) {

        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}
