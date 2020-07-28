import javax.swing.*;

public class TankGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        GameClient gameClient = new GameClient(800,600);
        GameClient gameClient1 = new GameClient(1024,768);

        frame.add(new GameClient(800,600));
        frame.setTitle("坦克大戰!");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        gameClient.repaint();
    }
}
