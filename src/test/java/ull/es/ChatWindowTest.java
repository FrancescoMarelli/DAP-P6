import org.junit.jupiter.api.Test;


import java.util.ArrayList;


class ChatWindowTest {

    @Test
    void sendMessage() {
        // Mocking data for testing
        String sender = "User1";
        String recipient = "User2";
        ArrayList<ChatWindow> groupChatWindows = new ArrayList<>();

        // Creating ChatWindow instance
        ChatWindow chatWindow = new ChatWindow("Test Chat", sender, recipient, groupChatWindows);

        // Mocking user input
        chatWindow.messageField.setText("Hello, testing!");

    }

}
