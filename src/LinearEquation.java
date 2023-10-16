public class LinearEquation {
    private String coord1;
    private String coord2;
    private int coord1X;
    private int coord1Y;
    private int coord2X;
    private int coord2Y;
    private double actualSlope;
    private String slope;
    public LinearEquation(int coord1X, int coord1Y, int coord2X, int coord2Y) {
        this.coord1X = coord1X;
        this.coord1Y = coord1Y;
        this.coord2X = coord2X;
        this.coord2Y = coord2Y;
    }

    public int getCoord1X() {
        return coord1X;
    }

    public int getCoord2X() {
        return coord2X;
    }

    public int getCoord1Y() {
        return coord1Y;
    }

    public int getCoord2Y() {
        return coord2Y;
    }

    public String getSlope() {
        return slope;
    }



    public void calcSlope(int coord1X, int coord1Y, int coord2X, int coord2Y) {
        slope = ((coord2Y - coord1Y) + "/" + (coord2X - coord1X));
        actualSlope = (double) ((coord2Y - coord1Y) / (coord2X - coord1X));
    }

    public double getYIntercept(int coord1X, int coord1Y) {
        return (double) coord1Y /  (coord1X * actualSlope);
    }


}
