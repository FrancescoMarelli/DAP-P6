import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatGUI extends JFrame {

    private JButton startButton;
    private JComboBox<String> conversationType;

    public ChatGUI() {
        super("ChatRoom");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        setStartPanel();

        // Adjust the window size and make it visible
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setStartPanel() {
        JPanel startPanel = new JPanel(new BorderLayout());
        startButton = new JButton("Start Chat");
        conversationType = new JComboBox<>(new String[]{"Private", "Group"});
        startPanel.add(conversationType, BorderLayout.CENTER);
        startPanel.add(startButton, BorderLayout.SOUTH);
        add(startPanel, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) conversationType.getSelectedItem();
                if ("Private".equals(selectedType)) {
                    startPrivateChat();
                } else if ("Group".equals(selectedType)) {
                    startGroupChat();
                }
            }
        });
    }

    private void startPrivateChat() {
        setVisible(false);
        dispose();

        new PrivateChatFrame();
    }

    private void startGroupChat() {
        setVisible(false);
        dispose();

        new GroupChatFrame();
    }
}

