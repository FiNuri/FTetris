package Shape;

public class LittleTShape extends AbstractShape {

    private boolean up, down, left, right;


    public LittleTShape() {
        super();
        initShape();
        up = true;
        down = false;
        left = false;
        right = false;
        colorName = 3;

    }

    protected void initShape() {

        x[0] = 112 + 2 * 16;
        y[0] = 0;
        x[1] = 112 + 16;
        y[1] = 16;
        x[2] = 112 + 2 * 16;
        y[2] = 16;
        x[3] = 112 + 3 * 16;
        y[3] = 16;

    }

    public void tornShape() {

        if (up) {

            x[0] += 16;
            y[0] += 16;
            x[1] += 16;
            y[1] -= 16;
            x[3] -= 16;
            y[3] += 16;

            up = false;
            right = true;
        } else if (right) {

            x[0] -= 16;
            y[0] += 16;
            x[1] += 16;
            y[1] += 16;
            x[3] -= 16;
            y[3] -= 16;

            right = false;
            down = true;
        } else if (down) {

            x[0] -= 16;
            y[0] -= 16;
            x[1] -= 16;
            y[1] += 16;
            x[3] += 16;
            y[3] -= 16;

            down = false;
            left = true;
        } else if (left) {

            x[0] += 16;
            y[0] -= 16;
            x[1] -= 16;
            y[1] -= 16;
            x[3] += 16;
            y[3] += 16;


            left = false;
            up = true;
        }
        super.tornShape();

    }

}
