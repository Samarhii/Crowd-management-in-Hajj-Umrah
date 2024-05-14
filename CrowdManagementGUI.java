
package ds_projj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrowdManagementGUI extends JFrame {
      private CrowdManagementSystem cms;
    private JLabel visitorCountLabel;
    private JTextArea messageTextArea;

    public CrowdManagementGUI() {
        cms = new CrowdManagementSystem();

        // Set up the JFrame
        setTitle("Crowd Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the window

        // Create components
        JButton enterButton = new JButton("Enter Mosque");
        JButton exitButton = new JButton("Exit Mosque");
        JButton searchButton = new JButton("Search Visitor");
        visitorCountLabel = new JLabel("Current number of visitors: 0");
        messageTextArea = new JTextArea();
        
        // Set properties for messageTextArea
        messageTextArea.setEditable(false);
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);

        // Add action listeners to buttons
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = JOptionPane.showInputDialog("Enter visitor code:");
                String name = JOptionPane.showInputDialog("Enter visitor name:");
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss").format(new Date());
                if (code != null && !code.isEmpty()) {
                    cms.enterMosque(name,code);
                    updateVisitorCountLabel();
                    messageTextArea.append("\nVisitor entered: " + name + " (" + code + ") at "+timeStamp);
                }
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = JOptionPane.showInputDialog("Enter visitor code to search:");
                if (code != null && !code.isEmpty()) {
                    String name = cms.searchVisitor(code);
                    if (name != null) {
                        messageTextArea.append("\nVisitor found: " + name + " (" + code + ")");
                    } else {
                        messageTextArea.append("\nVisitor  with code: (" + code + ") not found");
                    }
                }
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = JOptionPane.showInputDialog("Enter visitor code to exit:");
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss").format(new Date());
                if (code != null && !code.isEmpty()) {
                    boolean deleted = cms.exitVisitor(code);
                    if (deleted) {
                        updateVisitorCountLabel();
                        messageTextArea.append("\nVisitor with code: (" + code + ") left" + " at "+timeStamp);
                    } else {
                        messageTextArea.append("\nVisitor with code: (" + code + ") not found");
                    }
                }
            }
        });


        // Create layout
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(enterButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(searchButton);
        add(buttonPanel, BorderLayout.CENTER);
        add(visitorCountLabel, BorderLayout.NORTH);
        add(new JScrollPane(messageTextArea), BorderLayout.SOUTH);
    }

    private void updateVisitorCountLabel() {
        int visitorCount = cms.getCurrentVisitorsCount();
        visitorCountLabel.setText("Current number of visitors: " + visitorCount);
    }

   
    

}
