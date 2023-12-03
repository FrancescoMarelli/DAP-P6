import org.junit.jupiter.api.Test;

import java.awt.BorderLayout;
import java.util.ArrayList;


import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
public class GroupChatFrameTest {
    @Test
    void testInitializeChat() {
        GroupChatFrame groupChatFrame = new GroupChatFrame();
        groupChatFrame.colleagues = new ArrayList<>();
        // Add participants to the chatroom
        groupChatFrame.colleagues.add(new ConcreteColleague("Pepe"));
        groupChatFrame.colleagues.add(new ConcreteColleague("Juan"));

        assertEquals(2, groupChatFrame.colleagues.size());
        assertEquals("Pepe", groupChatFrame.colleagues.get(0).getName());
        assertEquals("Juan", groupChatFrame.colleagues.get(1).getName());

    }

    @Test
    void testConstructor() {
        GroupChatFrame groupChatFrame = new GroupChatFrame();
        assertEquals("Group Chat", groupChatFrame.getTitle());
        assertEquals(3, groupChatFrame.getDefaultCloseOperation());
        assertEquals(BorderLayout.class, groupChatFrame.getLayout().getClass());
        assertFalse(groupChatFrame.isDisplayable());    // The window is not visible
        assertTrue(groupChatFrame.isResizable());       // The window is resizable

    }

    @Test
    void testInitializeChatWindows() {
        GroupChatFrame groupChatFrame = new GroupChatFrame();
        groupChatFrame.colleagues = new ArrayList<>();
        groupChatFrame.chatWindows = new ArrayList<>();
        // Add participants to the chatroom
        groupChatFrame.colleagues.add(new ConcreteColleague("Pepe"));
        groupChatFrame.colleagues.add(new ConcreteColleague("Juan"));
        groupChatFrame.colleagues.add(new ConcreteColleague("Maria"));
        groupChatFrame.colleagues.add(new ConcreteColleague("Ana"));
        groupChatFrame.colleagues.add(new ConcreteColleague("Luis"));

        // Create a new chat window for each participant
        for (Colleague c : groupChatFrame.colleagues) {
            ChatWindow chatWindow = new ChatWindow("Group Chat: " + c.getName(), c.getName(), "Group Chat", groupChatFrame.chatWindows);
            groupChatFrame.chatWindows.add(chatWindow);
            chatWindow.isGroupChat = true;  // Set the chat window as a group chat
        }

        assertEquals(5, groupChatFrame.chatWindows.size());
        assertEquals("Group Chat: Pepe", groupChatFrame.chatWindows.get(0).getTitle());
        assertEquals("Group Chat: Juan", groupChatFrame.chatWindows.get(1).getTitle());
        assertEquals("Group Chat: Maria", groupChatFrame.chatWindows.get(2).getTitle());
        assertEquals("Group Chat: Ana", groupChatFrame.chatWindows.get(3).getTitle());
        assertEquals("Group Chat: Luis", groupChatFrame.chatWindows.get(4).getTitle());
    }

    @Test
    void testWindowConstants() {
        GroupChatFrame groupChatFrame = new GroupChatFrame();
        assertEquals(3, groupChatFrame.getDefaultCloseOperation());
        assertTrue(groupChatFrame.isResizable());
    }


}
