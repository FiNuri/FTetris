package Shape;

public abstract class AbstractShape {

    protected int[] x, y;
    protected int colorName;

    public AbstractShape(){
        x = new int[4];
        y = new int[4];
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }
    public int getColor(){
        return colorName;
    }

    protected abstract void initShape();

    public void tornShape(){
        boolean b = false, g = false;

        for (int i = 0; i < 4; i++) {
            if (x[i] == 304) {
                b = true;
            } else if (x[i] == 0) {
                g = true;
            }
        }
        if (b) {
            for (int j = 0; j < 4; j++) {
                x[j] -= 16;
            }
        } else if (g) {
            for (int k = 0; k < 4; k++) {
                x[k] += 16;
            }
        }
    };
}
