package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChatWindow extends JFrame implements Mediator {

    private JTextArea chatArea;
    private JTextField messageField;
    private String sender;
    private String recipient;
    private ChatWindow recipientWindow; // For private chat
    private ArrayList<ChatWindow> groupChatWindows;
    public boolean isGroupChat = false;

    public ChatWindow(String title, String sender, String recipient, ArrayList<ChatWindow> groupChatWindows) {
        super(title);
        this.sender = sender;
        this.recipient = recipient;
        this.groupChatWindows = groupChatWindows;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);  //
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Adjust the window size and make it visible
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


    public void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            if (isGroupChat) {
                // Broadcast the message to all participants
                for (ChatWindow recipientWindow : groupChatWindows) {
                    if (!recipientWindow.sender.equals(sender)) {
                        recipientWindow.displayMessage(sender, message); // Display the message in the recipient's window
                    }
                }
            } else {
                // Send the message to the recipient through the mediator
                if (recipientWindow != null) {
                    recipientWindow.displayMessage(sender, message);  // Display the message in the recipient's window
                }
            }

            // Display the message in the current window
            displayMessage("Yo", message);

            // Clear the message field
            messageField.setText("");
        }
    }

    /**
     *
     * @param recipientWindow
     */
    public void setRecipientWindow(ChatWindow recipientWindow) {
        this.recipientWindow = recipientWindow;
    }

    /**
     *
     * @param sender
     * @param message
     */
    public void displayMessage(String sender, String message) {
        chatArea.append(sender + ": " + message + "\n");
    }
}
