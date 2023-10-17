import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
public class LinearEquationLogic {
    private LinearEquation linearEquation;
    private Scanner scan;
    private int coord1X;
    private int coord1Y;
    private int coord2X;
    private int coord2Y;
    private String coord1;
    private String coord2;
    private String slope;
    private double yIntercept;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.print("enter coord 1: ");
        coord1 = scan.nextLine();
        System.out.print("enter coord 2: ");
        coord2 = scan.nextLine();
        parseCoordinates(coord1, coord2);
        setSlope();
        printSlope();
    }

    private void parseCoordinates(String coord1, String coord2) {
        int commaIndex = coord1.indexOf(",");
        coord1X = Integer.parseInt(coord1.substring(1, commaIndex));
        coord1Y = Integer.parseInt(coord1.substring(commaIndex + 2, coord1.length() - 1));
        commaIndex = coord2.indexOf(",");
        coord2X = Integer.parseInt(coord2.substring(1, commaIndex));
        coord2Y = Integer.parseInt(coord2.substring(commaIndex + 2, coord2.length() - 1));
        linearEquation = new LinearEquation(coord1X, coord1Y, coord2X, coord2Y);
    }

    private void setSlope() {
        linearEquation.calcSlope(coord1X, coord1Y, coord2X, coord2Y);
        slope = linearEquation.getSlope();
        yIntercept = linearEquation.getYIntercept(coord1X, coord1Y);
    }

    private void printSlope() {
        System.out.println("Slope is y = " + slope + "x + " + yIntercept);
    }

    private double rounddedToHundredth(double toRound) {
        return (Math.round(toRound) * 100.0) / 100;
    }


}
