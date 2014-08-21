import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by U6017277 on 13/06/2014.
 */
public class robotsOnMars {


    public static void main(String[] args) {

        Scanner user_input = new Scanner( System.in );
        System.out.println("How big is mars: ");

        String size = user_input.next();

        int xco = Integer.parseInt(size.substring(0, 1));
        int yco = Integer.parseInt(size.substring(1, 2));

        Coordinates marsSize = new Coordinates(xco,yco);

        Mars mars = new Mars(marsSize);

        System.out.println("Enter intial coordiantes ");
        Scanner intialCooridnates = new Scanner( System.in );

        String intial = intialCooridnates.next();
        String intialdirections = intialCooridnates.next();

        Coordinates robotCordiantes = new Coordinates(Integer.parseInt(intial.substring(0,1)),Integer.parseInt(intial.substring(1,2)));

        char initialdirections = intialdirections.charAt(0);

        Robot robot = new Robot(robotCordiantes,initialdirections);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input=null;
        System.out.println("Enter instructions ");

        try {
            input = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

        Scanner insturctionInput = new Scanner( input );
        ArrayList<String> instructions = new ArrayList<String>();

        while (insturctionInput.hasNext()) {
            instructions.add(insturctionInput.next());
        }





            for(String in : instructions){

                boolean isLost = robot.checkPosition(mars);

                if(!isLost) {


                    if (in.equals("f")) {
                        robot.move();

                        System.out.print(robot.getCoordinates().getX());
                        System.out.print(robot.getCoordinates().getY());
                        System.out.println(robot.getDirection());

                        isLost=robot.checkPosition(mars);

                    } else if (in.equals("l") || in.equals("r")) {
                        robot.turn(in);

                    }

                }

        }



    }//end method
}//end class

