import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private int x1;
    private int y1;
    private int y2;
    private int x2;
    private String coord1;
    private String coord2;
    private String slope;
    private double yIntercept;
    private String yesOrNo;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        calculatorUI();
        while (yesOrNo.equals("yes")) {
            calculatorUI();
        }
    }


    private void parseCoords(String coord1, String coord2) {
        int commaIndex = coord1.indexOf(",");
        x1 = Integer.parseInt(coord1.substring(1, commaIndex));
        y1 = Integer.parseInt(coord1.substring(commaIndex + 2, coord1.indexOf(")")));
        commaIndex = coord2.indexOf(",");
        x2 = Integer.parseInt(coord2.substring(1, commaIndex));
        y2 = Integer.parseInt(coord2.substring(commaIndex + 2, coord2.indexOf(")")));
    }

    private void calculatorUI() {
        System.out.print("enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("enter coordinate 2: ");
        coord2 = scan.nextLine();
        parseCoords(coord1, coord2);
        LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);
        if (linearEquation.equation().equals("undefined")) {
            System.out.println("Undefined slope.");
        } else {
            System.out.println(linearEquation.lineInfo());
            System.out.print("Enter any x-value and get a corresponding coordinate point: ");
            double newX = scan.nextDouble();
            scan.nextLine();
            System.out.println("Coordinate for x: " + linearEquation.coordinateforX(newX));
        }
        System.out.println("Calculate again? (yes/no): ");
        yesOrNo = scan.nextLine();
    }


}
