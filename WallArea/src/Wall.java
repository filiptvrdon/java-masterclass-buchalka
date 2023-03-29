public class Wall {

    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        if (width < 0) width = 0;
        this.width = width;
    }

    public void setHeight(double height) {
        if (height < 0) height = 0;
        this.height = height;
    }

    public Wall(double width, double height) {
        this.width = width < 0 ? 0 : width;
        this.height = height < 0 ? 0 : height;
    }

    public Wall(){
        this(0,0);
    }
    public double getArea () {
        return getWidth() * getHeight();
    }
}
