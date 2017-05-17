package Data;

/**
 * Created by m.zedzian & 94lucasm on 16-05-2017.
 */
public class Vertex {

    private int id;
    private double x;
    private double y;
    private int kClass = 0;

    public Vertex(double x, double y) {
        setX(x);
        setY(y);
        //System.out.println(toString());
    }

    public Vertex(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getkClass() {
        return kClass;
    }

    public void setkClass(int klas){
        this.kClass = klas;
    }

    @Override
    public String toString() {
        return "Vertex [ x: " + x + ", y: " + y + " ]";
    }
}
