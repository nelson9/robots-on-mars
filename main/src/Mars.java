/**
 * Created by U6017277 on 13/06/2014.
 */
public class Mars {

    private int x;
    private int y;
    private Coordinates size;

    public Mars(int xco, int yco) {
        this.x = xco;
        this.y = yco;
    }

    public Mars(Coordinates size) {
        this.size = size;
    }


    public Coordinates getSize() {
        return size;
    }
}
