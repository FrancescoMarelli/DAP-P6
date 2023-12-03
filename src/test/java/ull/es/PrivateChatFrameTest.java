import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Component;


import static org.junit.jupiter.api.Assertions.*;
public class PrivateChatFrameTest {

    @Test
    public void testInitializeChat() {
        PrivateChatFrame privateChatFrame = new PrivateChatFrame();
        privateChatFrame.colleagues = new ArrayList<>();
        // Add participants to the chatroom
        privateChatFrame.colleagues.add(new ConcreteColleague("Pepe"));
        privateChatFrame.colleagues.add(new ConcreteColleague("Juan"));

        assertEquals(2, privateChatFrame.colleagues.size());
        assertEquals("Pepe", privateChatFrame.colleagues.get(0).getName());
        assertEquals("Juan", privateChatFrame.colleagues.get(1).getName());

    }
    @Test
    public void testSetComboBox() {
        // Arrange
        PrivateChatFrame privateChatFrame = new PrivateChatFrame();
        privateChatFrame.colleagues = new ArrayList<>();
        privateChatFrame.colleagues.add(new ConcreteColleague("Alice"));
        privateChatFrame.colleagues.add(new ConcreteColleague("Bob"));

        // Act
        privateChatFrame.setComboBox();

        // Assert
        assertNotNull(privateChatFrame.senders);
        assertNotNull(privateChatFrame.recipients);

        assertEquals(2, privateChatFrame.senders.getItemCount());
        assertEquals(2, privateChatFrame.recipients.getItemCount());
        assertEquals("Alice", privateChatFrame.senders.getItemAt(0));
        assertEquals("Bob", privateChatFrame.senders.getItemAt(1));
        assertEquals("Alice", privateChatFrame.recipients.getItemAt(0));
        assertEquals("Bob", privateChatFrame.recipients.getItemAt(1));
    }

    @Test
    public void testSetStartButtonActionPerformed() {
        // Arrange
        PrivateChatFrame privateChatFrame = new PrivateChatFrame();
        privateChatFrame.colleagues = new ArrayList<>();
        privateChatFrame.colleagues.add(new ConcreteColleague("User1"));
        privateChatFrame.colleagues.add(new ConcreteColleague("User2"));

        privateChatFrame.setComboBox();  // Ensure the combo boxes are initialized

        // Act
        privateChatFrame.senders.setSelectedItem("User1");
        privateChatFrame.recipients.setSelectedItem("User2");

        // Find the Start Chat button directly in the container
        JButton startButton = null;
        for (Component component : privateChatFrame.getContentPane().getComponents()) {
            if (component instanceof JButton && "Start Chat".equals(((JButton) component).getText())) {
                startButton = (JButton) component;
                break;
            }
        }

        assertNotNull(startButton);
        ActionEvent actionEvent = new ActionEvent(startButton, ActionEvent.ACTION_PERFORMED, "");
        startButton.getActionListeners()[0].actionPerformed(actionEvent);

        // Assert
        assertFalse(privateChatFrame.isVisible());
        // You may want to add assertions for the opened ChatWindow instances or other expected behavior.
    }
}
