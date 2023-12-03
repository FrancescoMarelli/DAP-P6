import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;

public class ChatGUITest {

    private ChatGUI chatGUI;

    @Before
    public void setUp() {
        chatGUI = new ChatGUI();
    }

    @Test
    public void testStartPrivateChat() {
        // Simula hacer clic en el botón de inicio
        chatGUI.startButton.doClick();

        // Verifica que la ventana sea invisible después de iniciar un chat privado
        assertFalse(chatGUI.isVisible());
    }

    @Test
    public void testStartGroupChat() {
        // Simula seleccionar "Group" en el JComboBox y hacer clic en el botón de inicio
        chatGUI.conversationType.setSelectedItem("Group");
        chatGUI.startButton.doClick();

        // Verifica que la ventana sea invisible después de iniciar un chat de grupo
        assertFalse(chatGUI.isVisible());
    }

    // Agrega más pruebas según sea necesario para cubrir diferentes escenarios

}
