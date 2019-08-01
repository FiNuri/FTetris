import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Dimension dimension;
    private Game game;

    public Frame(String title){
        super(title);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimension.width - 336) / 2,(dimension.height - 359) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(336, 359);
        setIconImage(new ImageIcon(this.getClass().getResource("TetrisICO.png")).getImage());
        setVisible(true);
        setResizable(false);
        game = new Game();
        add(game);

    }
}
