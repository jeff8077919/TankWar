import javax.swing.*;
import java.awt.*;

public class Tank extends GameObject{
//    private int x;
//    private int y;
    private Direction direction;
    private int speed;
    private boolean[] dirs =new boolean[4];
    private boolean enemy;

    public Tank(int x,int y,Direction direction,Image[] image){
        this(x,y,direction,false,image);
    }

    public Tank(int x, int y, Direction direction,boolean enemy,Image[] image) {
        super(x,y,image);
        this.x=x;
        this.y=y;
        this.direction = direction;
        speed = 5;
        this.enemy = enemy;
    }

    public Image getImage() {

//        String name = enemy ? "etank" : "itank";
        return image[direction.ordinal()];

 /*       if (direction == Direction.up)
   //         return new ImageIcon("assets/images/itankU.png").getImage();
            return new ImageIcon("assets/images/" + name + "U.png").getImage();
        if (direction == Direction.down)
   //         return new ImageIcon("assets/images/itankD.png").getImage();
            return new ImageIcon("assets/images/" + name + "D.png").getImage();
        if (direction == Direction.left)
    //        return new ImageIcon("assets/images/itankL.png").getImage();
            return new ImageIcon("assets/images/" + name + "L.png").getImage();
        if (direction == Direction.right)
  //          return new ImageIcon("assets/images/itankR.png").getImage();
             return new ImageIcon("assets/images/" + name + "R.png").getImage();
        if (direction == Direction.up_right)
   //         return new ImageIcon("assets/images/itankRU.png").getImage();
             return new ImageIcon("assets/images/" + name + "RU.png").getImage();
        if (direction == Direction.up_left)
   //         return new ImageIcon("assets/images/itankLU.png").getImage();
             return new ImageIcon("assets/images/" + name + "LU.png").getImage();
        if (direction == Direction.down_right)
    //        return new ImageIcon("assets/images/itankRD.png").getImage();
            return new ImageIcon("assets/images/" + name + "RD.png").getImage();
        if (direction == Direction.down_left)
    //        return new ImageIcon("assets/images/itankLD.png").getImage();
            return new ImageIcon("assets/images/" + name + "LD.png").getImage();

        return null;
*/    }


    public void move(){
        switch (direction){
            case up:
                y-=speed;
                break;
            case down:
                y+=speed;
                break;
            case left:
                x-=speed;
                break;
            case up_left:
                x-=speed;
                y-=speed;
                break;
            case up_right:
                x+=speed;
                y-=speed;
                break;
            case down_left:
                x-=speed;
                y+=speed;
                break;
            case down_right:
                x+=speed;
                y+=speed;
                break;
            case right:
                x+=speed;
                break;
        }
    }

    private void determineDirection(){
        if (dirs[0]&&!dirs[1]&&dirs[2]&&!dirs[3])direction=Direction.up_left;
        else if (dirs[0]&&!dirs[1]&&!dirs[2]&&dirs[3])direction=Direction.up_right;
        else if (!dirs[0]&&dirs[1]&&dirs[2]&&!dirs[3])direction=Direction.down_left;
        else if (!dirs[0]&&dirs[1]&&!dirs[2]&&dirs[3])direction=Direction.down_right;
        else if (dirs[0]&&!dirs[1]&&!dirs[2]&&!dirs[3])direction=Direction.up;
        else if (!dirs[0]&&dirs[1]&&!dirs[2]&&!dirs[3])direction=Direction.down;
        else if (!dirs[0]&&!dirs[1]&&dirs[2]&&!dirs[3])direction=Direction.left;
        else if (!dirs[0]&&!dirs[1]&&!dirs[2]&&dirs[3])direction=Direction.right;
    }

    public void draw(Graphics g){
        if (!isStop()) {
            determineDirection();
            move();
        }
        g.drawImage(image[direction.ordinal()],x,y,null);
    }
    public boolean isStop(){
        for (int i=0;i<dirs.length;i++){
            if (dirs[i])return false;
        }
        return true;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean[] getDirs() {
        return dirs;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
