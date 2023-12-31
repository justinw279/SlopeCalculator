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
        slope = ((double) coord2Y - coord1Y) / ((double) coord2X - coord1X);
        slope = roundedToHundredth(slope);
        return slope;   }

    public String equation() {

        String slopeToReturn = ((coord2Y - coord1Y) + "/" + (coord2X - coord1X)) + "x";
        String yInterceptToReturn = " + " + yIntercept();
        if (coord1Y == coord2Y) {
            return "y = " + yIntercept();
        }
        if (coord1X == coord2X) {
            System.out.println("slope is undefined!");
            return "undefined";
        }
        if ((coord2Y - coord1Y) % (coord2X - coord1X) == 0) {
            slopeToReturn = (int) slope() + "x";
        }
        if ((coord2Y - coord1Y) < 0 && (coord2X - coord1X) < 0) {
            slopeToReturn = (coord2Y - coord1Y) + "/" + Math.abs((coord2X - coord1X)) + "x";
        }
        if (slope() == 1.0) {
            slopeToReturn = "x";
        }
        if (slope() == -1.0) {
            slopeToReturn = "-x";
        }
        if (slope() < 0 && (coord2Y - coord1Y) % (coord2X - coord1X) != 0) {
            slopeToReturn = "-" + Math.abs((coord2Y - coord1Y)) + "/" + Math.abs((coord2X - coord1X)) + "x";
        } else if (slope() > 0 && (coord2Y - coord1Y) % (coord2X - coord1X) == 0) {
            slopeToReturn = (int) Math.abs(slope) + "x";
            if ((coord2Y - coord1Y) / (coord2X - coord1X) == 1.0) {
                slopeToReturn = "x";
            }
        }
        if (yIntercept() == 0.0) {
            yInterceptToReturn = "";
        }
        if (slope() == 0.0) {
            slopeToReturn = "";
        }
        if (yIntercept() < 0.0) {
            yInterceptToReturn = " - " + Math.abs(yIntercept());
        }


        double intercept = yIntercept();
        return "y = " + slopeToReturn + yInterceptToReturn;
    }

    public double yIntercept() {
        return roundedToHundredth(coord1Y - (coord1X * slope));
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(coord2X - coord1X, 2) + Math.pow(coord2Y - coord1Y, 2)));
    }

    public String coordinateForX(double x) {
        return "(" + x + ", " + (slope * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        return "The two points are: (" + coord1X + ", " + coord1Y + ") and (" + coord2X + ", " + coord2Y + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these points is: " + roundedToHundredth(distance());
    
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }

}
