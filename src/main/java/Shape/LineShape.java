package Shape;

public class LineShape extends AbstractShape {

    private boolean up;

    public LineShape() {
        super();
        initShape();
        up = true;
        colorName = 2;

    }

    protected void initShape() {
        for (int i = 0, j = 1; i < x.length; i++, j++) {
            x[i] = 112 + (j * 16);
            y[i] = 0;
        }
    }

    public void tornShape() {
        boolean g = false, b = false;
        if (up) {

            x[0] += 16;
            y[0] += 16;
            x[2] -= 16;
            y[2] -= 16;
            x[3] -= 2 * 16;
            y[3] -= 2 * 16;

            up = false;

        } else {

            x[0] -= 16;
            y[0] -= 16;
            x[2] += 16;
            y[2] += 16;
            x[3] += 2 * 16;
            y[3] += 2 * 16;

            up = true;
        }
        for (int i = 0; i < 4; i++){
            if (x[i] == 320){
                b = true;
            }
            else if (x[i] == 0){
                g = true;
            }
        }
        if (b){
            for (int j = 0; j < 4; j++){
                x[j] -= 32;
            }
        }
        else if (g){
            for (int j = 0; j < 4; j++){
                x[j] += 16;
            }
        }

    }
}
