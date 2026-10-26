public class drawshape {
    public static void main(String[] args) {
        // 父类型数组装子类对象 —— 向上转型
        Shape[] shapes = {
                new Rectangle(3, 4),
                new Circle(2.5),
                new Triangle(3, 4, 5),
                new Shape(){
                    private final double side=10;
                    @Override
                    public double area()  { return side*side; }
                    @Override
                    public double perimeter() { return 4*side; }
                    @Override
                    public String type() { return "匿名内部类创建的正方形"; }
                }
        };
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].type() + " 面积=" + shapes[i].area()
                    + " 周长=" + shapes[i].perimeter());
        }
    }
}