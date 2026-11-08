package visitors;

import elements.Circle;
import elements.Square;
import elements.Triangle;

public final class ExportVisitor implements ShapeVisitor {

    private final StringBuilder xml = new StringBuilder();

    public ExportVisitor() {
        xml.append("<shapes>\n");
    }

    @Override
    public void visitCircle(Circle circle) {
        xml.append("  <circle radius=\"")
                .append(circle.getRadius())
                .append("\"/>\n");
    }

    @Override
    public void visitSquare(Square square) {
        xml.append("  <square side=\"")
                .append(square.getSide())
                .append("\"/>\n");
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        xml.append("  <triangle side=\"")
                .append(triangle.getSide())
                .append("\"/>\n");
    }

    public String getXml() {
        return xml.toString() + "</shapes>";
    }
}
