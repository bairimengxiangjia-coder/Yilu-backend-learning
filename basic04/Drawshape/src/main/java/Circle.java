public class Circle extends AbstractShape{
    private final double radius;

    public Circle(double radius) {
        super("圆");
        this.radius = radius;
    }

    @Override
    public double area()
    { return Math.PI * radius * radius; }

    @Override
    public double perimeter()
    { return 2 * Math.PI * radius; }

}


