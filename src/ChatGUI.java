import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class ChatGUI extends JFrame {

    JButton sendButton;
    JTextArea messageField;
    JCheckBox sendToAllCheckBox;
    JComboBox<String> senders;
    JComboBox<String> recipients;
    Chatroom chatroom;
    MessageGUI messageGUI;



    public ChatGUI() {
        super("ChatRoom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeChat();
        setComboBox();
        // Create a text area for composing messages
        messageField = new JTextArea();
        messageField.setPreferredSize(new Dimension(500, 100));

        setDesign();

        // Create a checkbox for sending to all participants
        sendToAllCheckBox = new JCheckBox("Send to all");

        // Create and add the send button
        sendButton = new JButton("Send");

        // Create a panel for the south layout
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(sendToAllCheckBox, BorderLayout.WEST);
        southPanel.add(sendButton, BorderLayout.EAST);
        messageGUI = new MessageGUI();

        sendButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String messageText = messageField.getText();
            if (!messageText.isEmpty()) {
                String sender = (String) senders.getSelectedItem();
                String recipient = (String) recipients.getSelectedItem();

                // Handle sending based on sender and recipient selection and checkbox state
                if (!sendToAllCheckBox.isSelected()) {
                    if (sender.equals("Select sender") || recipient.equals("Select recipient")) {
                        // Prompt user to select both sender and recipient
                        JOptionPane.showMessageDialog(ChatGUI.this, "Please select both sender and recipient.", "Missing Sender or Recipient", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Send the message to the selected recipient
                        ConcreteColleague senderColleague = new ConcreteColleague(sender, chatroom);
                        ConcreteColleague recipientColleague = new ConcreteColleague(recipient, chatroom);
                        chatroom.send(senderColleague, messageText, recipientColleague);
                        messageGUI.addMessage(sender, messageText, recipient);
                    }
                } else {
                    if (sender.equals("Select sender")) {
                        // Prompt user to select a sender
                        JOptionPane.showMessageDialog(ChatGUI.this, "Please select a sender.", "Missing Sender", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Send the message to all participants
                        for (Colleague c : chatroom.getColleagues()) {
                            if (!c.getName().equals(sender)) {
                                ConcreteColleague senderColleague = new ConcreteColleague(sender, chatroom);
                                chatroom.send(senderColleague, messageText, c);

                            }
                        }
                        messageGUI.addMessage(sender, messageText, "All");
                    }
                }

                // Clear the message field
                messageField.setText("");
            }
        }
    });

        // Add components to the layout
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JScrollPane(messageField), BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(senders, BorderLayout.WEST);
        topPanel.add(recipients, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        // Adjust the window size and make it visible
        setSize(600, 400);
        setMinimumSize(new Dimension(300, 200));
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initializeChat() {
        // Create a new Chatroom object
        chatroom = new Chatroom();

        // Add participants to the chatroom
        chatroom.addColleague(new ConcreteColleague("Pepe", chatroom));
        chatroom.addColleague(new ConcreteColleague("Juan", chatroom));
        chatroom.addColleague(new ConcreteColleague("Maria", chatroom));
        chatroom.addColleague(new ConcreteColleague("Ana", chatroom));
        chatroom.addColleague(new ConcreteColleague("Luis", chatroom));
    }

    public void setComboBox() {
        // Create a dropdown list for selecting senders
        senders = new JComboBox<>();
        senders.addItem("Select sender"); // Add a default option
        for (Colleague c : chatroom.getColleagues())
            senders.addItem(c.getName());

        // Create a dropdown list for selecting recipients
        recipients = new JComboBox<>();
        recipients.addItem("Select recipient"); // Add a default option
        for (Colleague c : chatroom.getColleagues())
            recipients.addItem(c.getName());
    }

    public void setDesign() {
        // Set a consistent font and text size
        Font font = new Font("Arial", Font.PLAIN, 14);
        UIManager.put("Label.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));

        // Set text color for labels
        UIManager.put("Label.foreground", new Color(50, 50, 50));

        // Set background and foreground color for JTextArea
        messageField.setBackground(new Color(240, 240, 240));
        messageField.setForeground(Color.BLACK);
    }
}
