import javax.swing.*;
import java.util.ArrayList;

public class MessageGUI extends JFrame {

    private JPanel messagePanel;
    private ArrayList<String> messageHistory;

    public MessageGUI() {
        // Configurar el JFrame
        setTitle("Message");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el historial de mensajes
        messageHistory = new ArrayList<>();

        // Crear un panel con un layout que permita mostrar varios mensajes
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        // Agregar el panel al JFrame
        add(messagePanel);


        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para agregar un nuevo mensaje al historial
    public void addMessage(String sender, String recipient, String newMessage) {
        // Agregar el nuevo mensaje al historial
        messageHistory.add(sender + " to " + recipient + ": " + newMessage);

        // Actualizar el texto del JLabel mostrando todos los mensajes en el historial
        updateMessageLabel(sender, newMessage, recipient);
    }

    // Método para actualizar el texto del JLabel con todos los mensajes en el historial
    void updateMessageLabel(String sender, String messageText, String recipient) {
        // Limpiar el panel antes de agregar los mensajes actualizados
        messagePanel.removeAll();

        // Agregar cada mensaje al panel
        for (String message : messageHistory) {
            JLabel messageLabel = new JLabel(message);
            messagePanel.add(messageLabel);
        }

        // Hacer visible el JFrame después de la actualización
        revalidate();
        repaint();
    }
}
