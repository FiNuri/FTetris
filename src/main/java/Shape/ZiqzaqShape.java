package Shape;

public class ZiqzaqShape extends AbstractShape {

    private boolean up, down, left, right;

    public ZiqzaqShape() {
        super();
        initShape();
        up = true;
        down = false;
        left = false;
        right = false;
        colorName = 5;
    }

    public void tornShape() {

        boolean b = false, d = false;


        if (up) {
            x[0] += 16;
            y[0] -= 16;
            x[2] -= 16;
            y[2] -= 16;
            x[3] -= 2 * 16;


            up = false;
            right = true;
        } else if (right) {
            x[2] += 2 * 16;
            x[3] += 2 * 16;

            right = false;
            left = true;

        } else if (left) {
            x[0] += 16;
            y[0] += 16;
            x[2] -= 16;
            y[2] += 16;
            x[3] -= 2 * 16;

            left = false;
            down = true;
        } else if (down) {
            x[0] -= 2 * 16;
            x[3] += 2 * 16;

            down = false;
            up = true;
        }

        super.tornShape();
    }

    protected void initShape() {
        x[0] = 112 + 16;
        y[0] = 0;
        x[1] = 112 + 2 * 16;
        y[1] = 0;
        x[2] = 112 + 2 * 16;
        y[2] = 16;
        x[3] = 112 + 3 * 16;
        y[3] = 16;
    }
}
