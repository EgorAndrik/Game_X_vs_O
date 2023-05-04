import javax.swing.*;
public class GameXO {
    public static void createGUI() {
        JFrame window = new JFrame("Крестики - Нолики");
        window.setSize(400, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Panel());
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
