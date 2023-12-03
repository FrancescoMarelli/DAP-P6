import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testDisplayMessage() {
        // Mocking data for testing
        String sender = "User1";
        String recipient = "User2";
        ArrayList<ChatWindow> groupChatWindows = new ArrayList<>();

        // Creating ChatWindow instance
        ChatWindow chatWindow = new ChatWindow("Test Chat", sender, recipient, groupChatWindows);

        // Mocking user input
        chatWindow.messageField.setText("Hello, testing!");

        // Mocking user input
        chatWindow.displayMessage(sender, "Hello, testing!");
    }

    @Test
    void testWindowConstants(){
        ChatWindow chatWindow = new ChatWindow("Test Chat", "User1", "User2", null);
        assertEquals("Test Chat", chatWindow.getTitle());
        assertEquals(2, chatWindow.getDefaultCloseOperation());

    }
}
