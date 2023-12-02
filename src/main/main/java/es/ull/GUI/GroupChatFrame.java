// GroupChatFrame.java
package java.es.ull.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GroupChatFrame extends JFrame {

    private ArrayList<ChatWindow> chatWindows; // List to store all chat windows
    private ArrayList<Colleague> colleagues;

    public GroupChatFrame() {
        super("Group Chat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeChat();
    }

    private void initializeChat() {
        colleagues = new ArrayList<>();
        chatWindows = new ArrayList<>();

        // Add participants to the chatroom
        colleagues.add(new ConcreteColleague("Pepe"));
        colleagues.add(new ConcreteColleague("Juan"));
        colleagues.add(new ConcreteColleague("Maria"));
        colleagues.add(new ConcreteColleague("Ana"));
        colleagues.add(new ConcreteColleague("Luis"));

        // Create a new chat window for each participant
        for (Colleague c : colleagues) {
            ChatWindow chatWindow = new ChatWindow("Group Chat: " + c.getName(), c.getName(), "Group Chat", chatWindows);
            chatWindows.add(chatWindow);
            chatWindow.isGroupChat = true;  // Set the chat window as a group chat
        }

        // Close the current window after opening the chat windows
        dispose();
    }

}
