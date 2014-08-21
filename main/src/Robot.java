/**
 * Created by U6017277 on 13/06/2014.
 */
public class Robot {

    private Coordinates coordinates;
    private  compass direction;
    private enum compass {NORTH, EAST, SOUTH, WEST};

    public Robot(Coordinates coordinates, char inital) {

        this.coordinates = coordinates;

        switch (inital) {
            case 'n':
                direction = compass.NORTH;
                break;
            case 's':
                direction = compass.SOUTH;
                break;
            case 'e':
                direction = compass.EAST;
                break;
            case 'w':
                direction = compass.WEST;
        }


    }

    public void turn(String directions) {

        if(directions.equals("l"))
        {
            switch (direction) {
                case NORTH:
                    direction=compass.WEST;
                    break;
                case EAST:
                    direction=compass.NORTH;
                    break;
                case SOUTH:
                    direction=compass.EAST;
                    break;
                case WEST:
                    direction=compass.SOUTH;
                    break;
            }
        }
        else if(directions.equals("r"))
        {
            switch (direction) {
                case NORTH:
                    direction=compass.EAST;
                    break;
                case EAST:
                    direction=compass.SOUTH;
                    break;
                case SOUTH:
                    direction=compass.WEST;
                    break;
                case WEST:
                    direction=compass.NORTH;
                    break;
            }
        }
    }

    public void move() {

        switch (direction) {
            case NORTH:
                coordinates.setY(coordinates.getY() + 1);
                break;
            case EAST:
                coordinates.setX(coordinates.getX() + 1);
                break;
            case SOUTH:
                coordinates.setY(coordinates.getY() - 1);
                break;
            case WEST:
                coordinates.setX(coordinates.getX() - 1);
                break;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean checkPosition(Mars mars){

        if(coordinates.getX()>mars.getSize().getX()||coordinates.getY()>mars.getSize().getY()){
            return true;
        }
        else

        return false;
    }

    public compass getDirection()
    {
        return direction;
    }

}