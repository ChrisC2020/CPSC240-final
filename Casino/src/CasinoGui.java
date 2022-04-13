import javax.swing.*;
import java.awt.*;

public class CasinoGui extends JPanel {

    public CasinoGui() {

        UserPane up = new UserPane();
        JScrollPane userPane = up.getUserPane();

        // create tabbed game pane
        JTabbedPane gamePane = new JTabbedPane();

        // placeholder panel for slots
        JPanel game1 = new JPanel();
        JLabel game1text = new JLabel("game goes here");
        game1.add(game1text);
        gamePane.addTab("Slots", game1); // replace game1 with a JPanel returned from your class


        Roulette roulette = new Roulette();
        gamePane.addTab("Roulette", roulette.gamePanel); // replace game2 with a JPanel returned from your class

        // create split pane with user and game panes
        JSplitPane sPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, userPane, gamePane);
        sPane.setOneTouchExpandable(false);
        sPane.setDividerLocation(150);

        userPane.setMinimumSize(new Dimension(150, 150));
        sPane.setPreferredSize(new Dimension(800, 600));

        JFrame frame = new JFrame("Casino Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(sPane);
        frame.setSize(800, 600);
        frame.setVisible(true);

    }

}