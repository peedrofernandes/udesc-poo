import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
  final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);

  JTextField tfFirstName, tfLastName;
  JLabel lbFirstName, lbLastName, lbWelcome;
  JPanel formPanel, firstLabelPanel, secondLabelPanel;
  JButton btnOK, btnClear;
  JPanel mainPanel, buttonsPanel;

  public void initialize() {
    // formPanel
    lbFirstName = new JLabel("First Name");
    lbFirstName.setFont(mainFont);

    lbLastName = new JLabel("Last Name");
    lbLastName.setFont(mainFont);

    tfFirstName = new JTextField();
    tfFirstName.setFont(mainFont);
    firstLabelPanel = new JPanel();
    firstLabelPanel.setLayout(new GridLayout(1, 1, 1, 1));
    firstLabelPanel.add(tfFirstName);

    tfLastName = new JTextField();
    tfLastName.setFont(mainFont);

    formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(4, 1, 5, 5));
    formPanel.setOpaque(false);
    formPanel.add(lbFirstName);
    formPanel.add(firstLabelPanel);
    formPanel.add(lbLastName);
    formPanel.add(tfLastName);

    lbWelcome = new JLabel();
    lbWelcome.setFont(mainFont);

    btnOK = new JButton("OK");
    btnOK.setFont(mainFont);
    btnOK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        lbWelcome.setText("Hello, " + firstName + " " + lastName + "!");
      }
    });

    btnClear = new JButton("Clear");
    btnClear.setFont(mainFont);
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tfFirstName.setText("");
        tfLastName.setText("");
        lbWelcome.setText("");
      }
    });

    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
    buttonsPanel.setOpaque(false);
    buttonsPanel.add(btnOK);
    buttonsPanel.add(btnClear);

    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBackground(new Color(128, 128, 255));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    mainPanel.add(formPanel, BorderLayout.NORTH);
    mainPanel.add(lbWelcome, BorderLayout.CENTER);
    mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

    add(mainPanel);

    setTitle("Welcome");
    setSize(500, 600);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) {
    MainFrame myFrame = new MainFrame();
    myFrame.initialize();
  }
}