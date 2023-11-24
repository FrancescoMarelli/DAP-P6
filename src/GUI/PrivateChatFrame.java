package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrivateChatFrame extends JFrame {

    private JComboBox<String> senders;
    private JComboBox<String> recipients;
    private ArrayList<Colleague> colleagues;


    public PrivateChatFrame() {
        super("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeChat();
        setComboBox();
        setFonts();
        setStartButton();
        setPanels();

        // Adjust the window size and make it visible
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeChat() {
        // Create a new Chatroom object
        colleagues = new ArrayList<>();

        // Add participants to the chatroom
        colleagues.add(new ConcreteColleague("Pepe"));
        colleagues.add(new ConcreteColleague("Juan"));
        colleagues.add(new ConcreteColleague("Maria"));
        colleagues.add(new ConcreteColleague("Ana"));
        colleagues.add(new ConcreteColleague("Luis"));

    }

    private void setComboBox() {
        // Create a dropdown list for selecting senders
        senders = new JComboBox<>();
        for (Colleague c : colleagues)
            senders.addItem(c.getName());

        // Create a dropdown list for selecting recipients
        recipients = new JComboBox<>();
        for (Colleague c : colleagues)
            recipients.addItem(c.getName());
    }

    private void setFonts() {
        // Set a consistent font and text size
        Font font = new Font("Arial", Font.PLAIN, 14);
        UIManager.put("Label.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
    }

    private void setStartButton() {
        JButton startButton = new JButton("Start Chat");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sender = (String) senders.getSelectedItem();
                String recipient = (String) recipients.getSelectedItem();
                    // Open private chat windows
                    openPrivateChatWindows(sender, recipient);

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openPrivateChatWindows(String sender, String recipient) {
        ChatWindow senderWindow = new ChatWindow("Private Chat: " + sender + " to " + recipient, sender, recipient, null);
        ChatWindow recipientWindow = new ChatWindow("Private Chat: " + recipient + " to " + sender, recipient, sender, null);

        // Establece la referencia cruzada entre las ventanas de chat
        senderWindow.setRecipientWindow(recipientWindow);
        recipientWindow.setRecipientWindow(senderWindow);


        dispose();
    }


    private void setPanels() {
        // Create a panel for the center layout
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));
        centerPanel.add(new JLabel("Select Sender:"));
        centerPanel.add(senders);
        centerPanel.add(new JLabel("Select Recipient:"));
        centerPanel.add(recipients);

        add(centerPanel, BorderLayout.CENTER);
    }
}
