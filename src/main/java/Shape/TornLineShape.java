package Shape;

public class TornLineShape extends AbstractShape {

    private boolean up, down, left, right;

    public TornLineShape(){
        super();
        initShape();
        up = true;
        down = false;
        left = false;
        right = false;
        colorName = 4;
    }

    public void tornShape() {

        if (up){

            x[0] += 16;
            y[0] += 16;
            x[2] -= 16;
            y[2] -= 16;
            x[3] -= 2 * 16;

            up = false;
            right = true;
        }
        else if (right){

            x[0] -= 16;
            y[0] += 16;
            x[2] += 16;
            y[2] -= 16;
            y[3] -= 2 * 16;

            right = false;
            down = true;
        }
        else if (down){

            x[0] -= 16;
            y[0] -= 16;
            x[2] += 16;
            y[2] += 16;
            x[3] += 2 * 16;

            down = false;
            left = true;
        }
        else if (left){

            x[0] += 16;
            y[0] -= 16;
            x[2] -= 16;
            y[2] += 16;
            y[3] += 2 * 16;

            left = false;
            up = true;
        }
         super.tornShape();

    }

    protected void initShape() {
        x[0] = 112 + 2 * 16;
        y[0] = 0;
        x[1] = 112 + 2 * 16;
        y[1] = 16;
        x[2] = 112 + 2 * 16;
        y[2] = 2 * 16;
        x[3] = 112 + 3 * 16;
        y[3] = 2 * 16;
    }
}
