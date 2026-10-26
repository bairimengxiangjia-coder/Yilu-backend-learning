public abstract class AbstractShape implements Shape {
    private final String name;          // 图形名称,子类通过构造方法传入
    public AbstractShape(String name) {
        this.name = name;
    }

    @Override
    public String type() {
        return name;
    }

}
