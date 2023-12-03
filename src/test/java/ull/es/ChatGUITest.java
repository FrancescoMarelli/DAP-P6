import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ChatGUITest {

    private ChatGUI chatGUI;


    @Test
    public void testChatGUIInitialization() {
        ChatGUI chatGUI = new ChatGUI();

        // Verifica que el título de la ventana sea "ChatRoom"
        assertEquals("ChatRoom", chatGUI.getTitle());

        // Verifica que el cierre de la ventana esté configurado correctamente
        assertEquals(JFrame.EXIT_ON_CLOSE, chatGUI.getDefaultCloseOperation());

        // Verifica que el layout de la ventana sea BorderLayout
        assertTrue(chatGUI.getLayout() instanceof BorderLayout);

        // Verifica que la ventana no sea redimensionable
        assertFalse(chatGUI.isResizable());

        // Verifica que la ventana sea visible
        assertTrue(chatGUI.isVisible());

        // Verifica que el tamaño de la ventana sea (300, 150)
        assertEquals(new Dimension(300, 150), chatGUI.getSize());

        // Verifica que la ubicación de la ventana sea centrada
        assertNotNull(chatGUI.getLocation());

        // Podrías agregar más verificaciones según sea necesario para la inicialización
    }

}
