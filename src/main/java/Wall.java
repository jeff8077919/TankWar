import javax.swing.*;
import java.awt.*;

public class Wall extends GameObject{
//    private int x;
//    private int y;
    private boolean horizontal;
    private  int brick;

//    private Image image;

    Wall(int x, int y, boolean horizontal, int brick,Image[] image) {
        super(x, y, image);
        this.horizontal = horizontal;
        this.brick = brick;
    }

    @Override
    public void draw(Graphics g){
        if (horizontal){
            for(int i=0;i<brick;i++){
                g.drawImage(image[0],x+i*width,y,null);
            }
        }else {
            for (int i=0;i<brick;i++){
                g.drawImage(image[0],x,y+i*height,null);
            }
        }
    }
}
