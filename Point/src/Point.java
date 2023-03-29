public class Point{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0,0);
    }
    public double distance() {
        Point basePoint = new Point(0,0);
        return distance(this, basePoint);
    }

    public double distance(Point basePoint){
        return distance (this, basePoint);
    }

    public double distance (int x, int y){
        Point basePoint = new Point(x,y);
        return distance(this, basePoint);
    }

    public double distance(Point thisPoint, Point basePoint){
        int xA = this.getX();
        int xB = basePoint.getX();
        int yA = this.getY();
        int yB = basePoint.getY();

        double distance = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
        System.out.println(distance);

        return distance;

    }

}
