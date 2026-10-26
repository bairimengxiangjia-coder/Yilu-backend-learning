public class Triangle extends AbstractShape{
    private final double a, b, c;

    public Triangle(double a, double b, double c) {
            super("三角形");
            this.a = a;
            this.b = b;
            this.c = c;
    }
    //海伦公式
    @Override
    public double area() {
        double s = (a + b + c) / 2;                 // 半周长
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter()
    { return a + b + c; }

}