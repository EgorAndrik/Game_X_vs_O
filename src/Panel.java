import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
public class Panel extends JPanel {
    public static JButton[][] buttons = new JButton[3][3];
    private Font font = new Font("SanSerif", Font.BOLD, 30);
    private Font font2 = new Font("SanSerif", Font.BOLD, 20);
    private int x_count = 0;
    private int o_count = 0;
    private JLabel left = new JLabel("X: 0");
    private JLabel center = new JLabel("Press Start");
    private JLabel right = new JLabel("O: 0");
    private JButton start = new JButton("Start");
    private JButton next = new JButton("Next");
    private String curr_user;
    private String start_user;
    public static String winner;
    private boolean game_state = false;
    public Panel() {
        GridLayout layout = new GridLayout(5, 3, 5, 5);
        setLayout(layout);
        setBackground(new Color(150, 255, 20));

        left.setFont(font2);
        add(left);
        center.setFont(font2);
        add(center);
        center.setHorizontalAlignment(SwingConstants.CENTER);
        right.setFont(font2);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        add(right);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                buttons[i][j] = new JButton("");
                addButton(buttons[i][j]);
            }
        }

        start.setFont(font);
        start.setBackground(new Color(10, 150, 104));
        add(start);

        next.setFont(font);
        next.setBackground(new Color(70, 50, 204));
        add(next);

        ActionListener listner_START = (ActionEvent e) -> {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);
            if (randomNum == 1)
                curr_user = "X";
            else
                curr_user = "O";
            start_user = curr_user;
            center.setText("Movie - " + curr_user);
            for (int i = 0; i < 3; ++i)
                for (int j = 0; j < 3; ++j)
                    buttons[i][j].setText("");
            x_count = 0;
            o_count = 0;
            left.setText("X: " + x_count);
            right.setText("O: " + o_count);
            game_state = true;
        };
        start.addActionListener(listner_START);

        ActionListener listner_next = (ActionEvent e) -> {
            if (!start_user.equals("")) {
                if (start_user.contains("X"))
                    start_user = "O";
                else
                    start_user = "X";
                center.setText("Movie - " + start_user);
                for (int i = 0; i < 3; ++i)
                    for (int j = 0; j < 3; ++j)
                        buttons[i][j].setText("");
                game_state = true;
            }
        };
        next.addActionListener(listner_next);

        ActionListener listner = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            if (game_state && b.getText().equals("")) {
                b.setText(curr_user);
                if (curr_user.contains("O"))
                    curr_user = "X";
                else
                    curr_user = "O";
                center.setText("Movie - " + curr_user);
                if (EventExamination.check_diagonal() ||
                        EventExamination.check_vertical() ||
                        EventExamination.check_horizontal())
                    setWinner();
                if (EventExamination.check_nicha())
                    setWinner();
            }
        };
        for (JButton[] rows : buttons)
            for (JButton b : rows)
                if (b != null)
                    b.addActionListener(listner);
    }
    private void addButton(JButton b) {
        b.setFont(font);
        b.setBackground(new Color(150, 150, 104));
        add(b);
    }
    private void setWinner(){
        if (winner.contains("X") || winner.contains("O")) {
            center.setText("WIN - " + winner);
            if (winner.contains("X"))
                x_count += 1;
            else
                o_count += 1;
            left.setText("X: " + x_count);
            right.setText("O: " + o_count);
        }
        else
            center.setText(winner);
        game_state = false;
    }
}