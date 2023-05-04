public class EventExamination {

    public static boolean check_horizontal() {
        for (int i = 0; i < 3; ++i) {
            int c = 0;
            for (int j = 0; j < 3; ++j) {
                String txt = Panel.buttons[i][j].getText();
                if (txt.contains("X"))
                    c++;
                if (txt.contains("O"))
                    c--;
            }
            if (c == 3) {
                Panel.winner = "X";
                return true;
            }
            if (c == -3) {
                Panel.winner = "O";
                return true;
            }
        }
        return false;
    }

    public static boolean check_vertical() {
        for (int i = 0; i < 3; ++i) {
            int c = 0;
            for (int j = 0; j < 3; ++j) {
                String txt = Panel.buttons[j][i].getText();
                if (txt.contains("X")) c++;
                if (txt.contains("O")) c--;
            }
            if (c == 3) {
                Panel.winner = "X";
                return true;
            }
            if (c == -3) {
                Panel.winner = "O";
                return true;
            }
        }
        return false;
    }

    public static boolean check_diagonal() {
        int c = 0;
        for (int i = 0; i < 3; ++i) {
            String txt = Panel.buttons[i][i].getText();
            if (txt.contains("X")) c++;
            if (txt.contains("O")) c--;
        }
        if (c == 3) {
            Panel.winner = "X";
            return true;
        }
        if (c == -3) {
            Panel.winner = "O";
            return true;
        }
        c = 0;
        int a = 2;
        for (int i = 0; 3 > i; i++){
            String txt = Panel.buttons[i][a].getText();
            if (txt.contains("X")) c++;
            if (txt.contains("O")) c--;
            a--;
        }
        if (c == 3) {
            Panel.winner = "X";
            return true;
        }
        if (c == -3) {
            Panel.winner = "O";
            return true;
        }
        return false;
    }

    public static boolean check_nicha(){
        int cnt_fullPlane = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!(Panel.buttons[i][j].getText() + "").contains(""))
                    cnt_fullPlane++;
        if (cnt_fullPlane == 9) {
            Panel.winner = "Draw";
            return true;
        }
        return false;
    }
}
