public class LinearEquation {
    private String coord1;
    private String coord2;
    private int coord1X;
    private int coord1Y;
    private int coord2X;
    private int coord2Y;
    private double slope;
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

    public double getSlope() {
        return slope;
    }



    public double slope() {
        slope = ((double) coord2Y - coord1Y) / (coord2X - coord1X);
        return roundedToHundredth(slope);   }

    public String equation() {
        if (coord1Y == coord2Y) {
            return "y = " + yIntercept(coord1X, coord1Y);
        }
        String equation = ((coord2Y - coord1Y) + "/" + (coord2X - coord1X));
        double intercept = yIntercept(coord1X, coord1Y);
        return "y = " + equation + "x + " + intercept;
    }

    public double yIntercept(int coord1X, int coord1Y) {
        return roundedToHundredth(coord1Y - (coord1X * slope));
    }

    private double distance() {
        return Math.sqrt(Math.pow(coord2X - coord1X, 2) + Math.pow(coord2Y - coord1Y, 2) );
    }

    private String coordinateforX(double x) {
        return "(" + x + ", " + (slope * x + yIntercept(coord1X, coord1Y)) + ")";
    }

    private String lineInfo() {
        return "The two points are: (" + coord1X + ", " + coord1Y + ") and (" + coord2X + ", " + coord2Y + ")\nThe equation of the line between these points is: " + equation() + "\n The slope of this line is " + slope + "The y-intercept of this line is: " + yIntercept(coord1X, coord1Y) + "\nThe distance between these points is: " + distance();
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

}
