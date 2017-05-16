package Data;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */
public class Vertex {

    private double x;
    private double y;

    public Vertex(double x, double y){
        setX(x);
        setY(y);
        System.out.println(toString());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "Vertex [ x: " + x + ", y: " + y + " ]";
    }
}
