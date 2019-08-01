import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Shape.*;

public class Game extends JPanel implements ActionListener {

    private Image dot, b, g, o, r, y;
    private int[] x, shapeX, shapeY;
    private ShapeFactory shapeFactory;
    private Timer timer;
    private int gameSpeed, score, shapeColor = 0;
    private boolean inGame, left, right;
    private AbstractShape shape;
    private int[][] screen;

    public Game() {

        loadImage();
        setSize(320, 320);
        setBackground(Color.lightGray);
        x = new int[20];
        shapeFactory = new ShapeFactory();
        gameSpeed = 500;
        score = 0;
        inGame = true;
        left = false;
        right = false;
        screen = new int[400][3];
        initScreen();
        addKeyListener(new KeyListner());
        setFocusable(true);
        startGame();

    }

    private void returnColor(int colorName) {
        switch (colorName) {
            case 1:
                dot = b;
                break;
            case 2:
                dot = g;
                break;
            case 3:
                dot = o;
                break;
            case 4:
                dot = r;
                break;
            case 5:
                dot = y;
                break;
        }

    }

    private void initScreen() {
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < 3; j++) {
                screen[i][j] = -1;
            }
        }
        int s = 19;
        for (int j = 0; j < x.length; j++) {
            x[j] = s;
            s += 20;
        }
    }

    private void startGame() {
        newShape();
        timer = new Timer(gameSpeed, this);
        timer.start();
    }

    private void addtofield() {
        int tX, tY;
        boolean b = false;
        if (inGame) {
            for (int i = 0; i < screen.length; i++) {
                for (int j = 0; j < shapeY.length; j++) {
                    if (shapeY[j] == screen[i][1] && shapeX[j] == screen[i][0]) {
                        for (int k = 0; k < shapeX.length; k++) {
                            tX = shapeX[k] / 16;
                            tY = (shapeY[k] - 16) / 16;
                            screen[(tY * 20) + tX][0] = shapeX[k];
                            screen[(tY * 20) + tX][1] = shapeY[k] - 16;
                            screen[(tY * 20) + tX][2] = shapeColor;
                            b = true;
                        }
                    }
                }
            }
            for (int j = 0; j < shapeY.length; j++) {
                if (shapeY[j] == 320) {
                    for (int g = 0; g < shapeY.length; g++) {
                        tX = shapeX[g] / 16;
                        tY = (shapeY[g] - 16) / 16;
                        screen[(tY * 20) + tX][0] = shapeX[g];
                        screen[(tY * 20) + tX][1] = shapeY[g] - 16;
                        screen[(tY * 20) + tX][2] = shapeColor;
                    }
                    newShape();
                    break;
                }
            }
            if (b) {
                newShape();
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            for (int i = 0; i < screen.length; i++) {
                if (screen[i][0] != -1 && screen[i][1] != -1) {
                    returnColor(screen[i][2]);
                    g.drawImage(dot, screen[i][0], screen[i][1], this);
                }
            }
            for (int j = 0; j < shapeX.length; j++) {
                returnColor(shapeColor);
                g.drawImage(dot, shapeX[j], shapeY[j], this);
            }
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(score), 15, 10);
        } else {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", getSize().width / 2 - 38, getSize().height / 2 - 10);
            g.setColor(Color.BLACK);
            g.drawString("Score:", getSize().width / 2 - 24, getSize().height / 2 + 20);
            g.drawString(String.valueOf(score).toUpperCase(), getSize().width / 2 + 11, getSize().height / 2 + 20);
        }

    }

    private void loadImage() {
        dot = new ImageIcon(getClass().getResource("dot.png")).getImage();
        b = new ImageIcon(getClass().getResource("b.png")).getImage();
        g = new ImageIcon(getClass().getResource("g.png")).getImage();
        o = new ImageIcon(getClass().getResource("o.png")).getImage();
        r = new ImageIcon(getClass().getResource("r.png")).getImage();
        y = new ImageIcon(getClass().getResource("y.png")).getImage();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        addtofield();
        checkcore();
        repaint();
    }

    private void checkcore() {

        int k = 0, l;

        for (int i = 0; i < x.length; i++) {
            l = 0;
            for (int j = k + 1; j <= x[i]; j++) {
                if (screen[j][0] != -1 && screen[j][1] != -1) {
                    l++;
                }
            }
            for (int s = 0; s < x[0]; s++) {
                if (screen[s][1] != -1) {
                    inGame = false;
                }
            }
            if (l == 20) {
                for (int b = k + 1; b <= x[i]; b++) {
                    screen[b][0] = -1;
                    screen[b][1] = -1;
                    score++;
                }
                if (gameSpeed > 10){
                    gameSpeed -= 10;
                    timer.setDelay(gameSpeed);
                }
                for (int t = x[i] - 20; t >= 0; t--) {
                    if (screen[t][0] != -1 && screen[t][1] != -1) {
                        screen[t + 20][0] = screen[t][0];
                        screen[t + 20][1] = screen[t][1] + 16;
                        screen[t][0] = -1;
                        screen[t][1] = -1;
                    }
                }
            }
            k = x[i];
        }
    }


    private void tornTo() {
        int l = 0, r = 0;
        boolean rr = false, ll = false;

        if (left && !right) {
            for (int i = 0; i < shapeX.length; i++) {
                if (shapeX[i] > 0) {
                    l++;
                }
            }
            if (l == shapeX.length) {
                for (int j = 0; j < shapeX.length; j++) {
                    shapeX[j] -= 16;
                }
                ll = true;
            }
        } else if (right && !left) {
            for (int i = 0; i < shapeX.length; i++) {
                if (shapeX[i] < 304) {
                    r++;
                }
            }
            if (r == shapeX.length) {
                for (int j = 0; j < shapeX.length; j++) {
                    shapeX[j] += 16;
                }
                rr = true;
            }
        }

        for (int k = 0; k < screen.length; k++) {
            for (int kk = 0; kk < shapeX.length; kk++) {
                if (shapeX[kk] == screen[k][0] && shapeY[kk] == screen[k][1]) {
                    for (int jk = 0; jk < shapeY.length; jk++) {
                        if (ll) {
                            shapeX[jk] += 16;
                        } else if (rr) {
                            shapeX[jk] -= 16;
                        }
                    }
                }
            }
        }
        left = false;
        right = false;
    }

    private void move() {

        for (int i = 0; i < shapeY.length; i++) {
            shapeY[i] += 16;
        }


    }

    private void newShape() {
        shape = shapeFactory.getShape();
        shapeX = shape.getX();
        shapeY = shape.getY();
        shapeColor = shape.getColor();
    }

    class KeyListner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyReleased(e);
            int keyCod = e.getKeyCode();
            if (keyCod == KeyEvent.VK_LEFT) {
                left = true;
                tornTo();
                repaint();
            } else if (keyCod == KeyEvent.VK_RIGHT) {
                right = true;
                tornTo();
                repaint();
            } else if (keyCod == KeyEvent.VK_SPACE) {
                shape.tornShape();
                repaint();
            } else if (keyCod == KeyEvent.VK_DOWN) {
                move();
                addtofield();
                repaint();
            }
        }
    }
}
