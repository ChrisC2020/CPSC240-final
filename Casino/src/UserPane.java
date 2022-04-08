import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class UserPane implements ActionListener {

    private JLabel nameLabel;
    private JLabel balanceLabel;
    private JButton changeButton;
    private JButton newButton;
    private JPanel userPanel;
    private JScrollPane userPane;
    private JTextField bet;
    private JButton setBet;
    private JLabel betLabel;
    private double currentBet = 0;
    private double balance = 500;
    private String stringBalance = "";
    private FileOutputStream fw;
    private PrintWriter pw;
    private String fileName;
    private String userName = "testPlayer";

    public UserPane() {

        // create user scroll pane
        userPanel = new JPanel();
        nameLabel = new JLabel(userName);
        stringBalance = String.format("Balance: $%.2f", balance);
        balanceLabel = new JLabel(stringBalance);
        changeButton = new JButton("Change User");
        changeButton.addActionListener(this);
        newButton = new JButton("   New User   ");
        newButton.addActionListener(this);
        bet = new JTextField();
        bet.setMaximumSize(new Dimension(110,30));
        setBet = new JButton("      Set bet      ");
        setBet.addActionListener(this);
        betLabel = new JLabel(String.format("Current bet: $%.2f", currentBet));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bet.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBet.setAlignmentX(Component.CENTER_ALIGNMENT);
        betLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 75 )));
        userPanel.add(nameLabel);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(balanceLabel);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(changeButton);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(newButton);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 60 )));
        userPanel.add(bet);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(setBet);
        userPanel.add(Box.createRigidArea( new Dimension( 1 , 15 )));
        userPanel.add(betLabel);
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPane = new JScrollPane(userPanel);

    }

    // handles button presses
    public void actionPerformed(ActionEvent e) {

        Object button = e.getSource();
        if ( button == setBet ) {
            currentBet = Double.parseDouble(bet.getText());
            if ( currentBet > balance ) {
                currentBet = balance;
            } else if (currentBet < 0 ) {
                currentBet = 0;
            }
            betLabel.setText(String.format("Current bet: $%.2f", currentBet));
        } else if ( button == changeButton ) {
            JOptionPane.showMessageDialog(null, "changeButton");
        } else if ( button == newButton ) {
            JOptionPane.showMessageDialog(null, "newButton");
        } else {
            JOptionPane.showMessageDialog(null, "???");
        }

    }

    // returns the user pane
    public JScrollPane getUserPane() {

        return userPane;

    }

    // returns the current balance
    public double getBalance() {

        return balance;

    }

    // changes the current balance
    public void setBalance(double balance) {

        this.balance = balance;

    }

    // returns the current bet
    public double getCurrentBet() {

        return currentBet;

    }

    // save user info to a file
    // cannot change username yet
    public void saveUser() throws IOException {

        fileName = "CasinoUsers/testUser.save";

        fw = new FileOutputStream( fileName );
        pw = new PrintWriter(fw);
        pw.println(userName);
        pw.println(balance);
        pw.close();

    }

}
