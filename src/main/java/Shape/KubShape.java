package Shape;

public class KubShape extends AbstractShape {


    public KubShape(){
        super();
        initShape();
        colorName = 1;
    }

    protected void initShape() {

        x[0] = 112 + 2 * 16;
        y[0] = 0;
        x[1] = 112 + 3 * 16;
        y[1] = 0;
        x[2] = 112 + 2 * 16;
        y[2] = 16;
        x[3] = 112 + 3 * 16;
        y[3] = 16;


    }

    public void tornShape() {

        //don't need to realize:

    }



}
