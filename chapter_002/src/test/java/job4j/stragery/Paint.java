package job4j.stragery;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint=new Paint();
        Shape triangle=new Triangle();
        Shape square=new Square();
        paint.draw(triangle);
        paint.draw(square);
    }
}
