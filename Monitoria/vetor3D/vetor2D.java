public class vetor2D {
    protected double x;
    protected double y;
    
    public vetor2D(){
        x = 0.0;
        y = 0.0;
    }
    
    public vetor2D(double x, double y){
        this.x = x;
        this.y = y;
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
}
