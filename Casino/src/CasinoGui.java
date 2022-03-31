import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasinoGui extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JLabel moneyLabel;
    private JButton changeButton;
    private JButton newButton;
    private JSplitPane sPane;
    private JPanel userPanel;
    private JTabbedPane gamePane;
    private JScrollPane userPane;
    private JTextField bet;
    private JButton setBet;
    private JLabel betLabel;
    private int currentBet = 0;
    private int money = 500;
    private String stringMoney = "";

    public CasinoGui() {

        // create user scroll pane
        userPanel = new JPanel();
        nameLabel = new JLabel("testPlayer");
        stringMoney = Integer.toString(money);
        moneyLabel = new JLabel("$"+stringMoney);
        changeButton = new JButton("Change User");
        changeButton.addActionListener(this);
        newButton = new JButton("New User");
        newButton.addActionListener(this);
        bet = new JTextField();
        bet.setMaximumSize(new Dimension(100,30));
        setBet = new JButton("Set bet");
        setBet.addActionListener(this);
        betLabel = new JLabel("Current bet: "+currentBet);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        moneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bet.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBet.setAlignmentX(Component.CENTER_ALIGNMENT);
        betLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 35 )));
        userPanel.add(nameLabel);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(moneyLabel);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(changeButton);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(newButton);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(bet);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(setBet);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(betLabel);
        userPane = new JScrollPane(userPanel);

        // create tabbed game pane
        gamePane = new JTabbedPane();

        // placeholder panel for slots
        JPanel game1 = new JPanel();
        JLabel game1text = new JLabel("game goes here");
        game1.add(game1text);
        gamePane.addTab("Slots", game1); // replace game1 with a JPanel returned from your class

        // placeholder panel for roulette
        JPanel game2 = new JPanel();
        JLabel game2text = new JLabel("game goes here");
        game2.add(game2text);
        gamePane.addTab("Roulette", game2); // replace game2 with a JPanel returned from your class

        // create split pane with user and game panes
        sPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, userPane, gamePane);
        sPane.setOneTouchExpandable(false);
        sPane.setDividerLocation(150);

        userPane.setMinimumSize(new Dimension(150, 150));
        sPane.setPreferredSize(new Dimension(800, 600));
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

        ShowGui();

    }

    // get the split pane to add to a JFrame
    protected JSplitPane getSPane() {

        return this.sPane;

    }

    public void actionPerformed(ActionEvent e) {

        Object button = e.getSource();
        if ( button == setBet ) {
            JOptionPane.showMessageDialog(null, "setBet");
        } else if ( button == changeButton ) {
            JOptionPane.showMessageDialog(null, "changeButton");
        } else if ( button == newButton ) {
            JOptionPane.showMessageDialog(null, "newButton");
        } else {
            JOptionPane.showMessageDialog(null, "???");
        }

    }

    private void ShowGui() {

        JFrame frame = new JFrame("Casino Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(getSPane());
        frame.setSize(800, 600);
        frame.setVisible(true);

    }

}