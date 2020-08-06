import com.sun.istack.internal.localization.NullLocalizable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;


public class GameClient extends JComponent {
    private int screenWidth;
    private int screenHeight;
    private Tank playerTank;
    private List<Tank> enemyTanks = new ArrayList<>();
    private List<Wall> walls = new ArrayList<>();


    public boolean stop;
    GameClient(){
        this(800,600);
    }

    public GameClient(int screenWidth, int screenHeight){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        init();

        new Thread(()->{
            while (!stop) {
                repaint();
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void init(){

        playerTank = new Tank(500,100,Direction.down);
        for (int i=0;i<3;i++){
            for (int j=0;j<4;j++){
                enemyTanks.add(new Tank(350+j*80,500+i*80,Direction.up,true));
            }
        }

        Wall[] walls={
                new Wall(250,150,true,15),
                new Wall(150,200,false,15),
                new Wall(800,200,false,15)
        };
        this.walls.addAll(Arrays.asList(walls));
    }



    public int getScreenWidth(){
        return screenWidth;
    }

    public int getScreenHeight(){
        return screenHeight;
    }

    @Override
    public void paintComponent(Graphics g){
       playerTank.draw(g);
        for (Tank tank: enemyTanks){
            tank.draw(g);
        }
        for (Wall wall: walls){
            wall.draw(g);
        }

    }

    public void keyPressed(KeyEvent e){
        boolean[] dirs =playerTank.getDirs();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                dirs[0]=true;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=true;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=true;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=true;
                break;

        }
    }

    public void keyReleased(KeyEvent e){
        boolean[] dirs =playerTank.getDirs();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                dirs[0]=false;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=false;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=false;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=false;
                break;

        }

    }
}


