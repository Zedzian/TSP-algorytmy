package Data;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */
public class Vertex {

    private int id;
    private double x;
    private double y;

    public Vertex(double x, double y) {
        setX(x);
        setY(y);
    }

    public Vertex(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
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

    public void setOther(Vertex v) {
        this.x = v.x;
        this.y = v.y;
        this.id = v.id;
    }

    @Override
    public String toString() {
        return "Vertex [ x: " + x + ", y: " + y + " ]";
    }
}