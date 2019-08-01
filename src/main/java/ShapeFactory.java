import Shape.*;

import java.util.Random;

public class ShapeFactory {

    public static int LINE = 1, TORNLINE = 2, ZIQZAQ = 3, KUB = 4, LITTLET = 5;
    private Random random;
    private int i;

    public ShapeFactory(){
        random = new Random();
    }

    private AbstractShape createShape(int shapeCode){

        AbstractShape shape = null;

        switch (shapeCode){
            case 1:
                shape = new LineShape();
                break;
            case 2:
                shape = new TornLineShape();
                break;
            case 3:
                shape = new ZiqzaqShape();
                break;
            case 4:
                shape = new KubShape();
                break;
            case 5:
                shape = new LittleTShape();
                break;
        }
        return shape;
    }

    public AbstractShape getShape(){
        i = random.nextInt(5) + 1;
        return createShape(i);
    }

}
