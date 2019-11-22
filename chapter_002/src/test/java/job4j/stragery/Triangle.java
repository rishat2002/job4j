package job4j.stragery;

public class Triangle implements Shape{
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("  1  \n");
        sb.append(" 111 \n");
        sb.append("11111\n");
        return sb.toString();
    }
}
