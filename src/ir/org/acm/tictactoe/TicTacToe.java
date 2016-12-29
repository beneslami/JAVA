package ir.org.acm.tictactoe;

/**
 * Created by ben on 12/29/16.
 */
public class TicTacToe {

    private char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        System.out.println("-----------------");
    }

    public void insertItem(int row, int col, char item) {
            board[row][col] = item;
            determineWinner(row, col, item);
            showBoard();
    }

    public boolean isValid(int i, int j) {
        boolean flag;
        if (board[i][j] == 'x' || board[i][j] == 'o') {
            flag = false;
        } else
            flag = true;
        return flag;
    }

    public void showBoard() {
        System.out.println("   " + 1 + "   " + 2 + "   " + 3);
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + "  " + board[i][0] + "   " + board[i][1] + "   " + board[i][2] + "\n");
        }
    }

    public char determineWinner(int row, int col,char item) {
        char c = ' ';

            // todo checking if the array is full
            if((board[0][0] !=' ') && (board[0][1] !=' ') && (board[0][2] !=' ') && (board[1][0] !=' ') && (board[1][1] !=' ') &&
                    (board[1][2] !=' ') && (board[2][0] !=' ') && (board[2][1] !=' ') && (board[2][2] !=' ') ){
                c = 'f';
            }

            //todo checking row
            else if ( (board[row][0] == item) && (board[row][1] == item) && (board[row][1] == item) && (board[row][2] == item)) {
                c = item;
            }
            //todo checing column
            else if ( (board[0][col] == item) && (board[1][col] == item) && (board[1][col] == item) && (board[2][col] == item) ) {
                c = item;
            }
            //todo checking right diagonal
            else if ( (board[0][0] == item) && (board[1][1] == item)  && (board[2][2] == item) ){
                c = item;
            }
            //todo checking left diagonal
            else if ( (board[0][2] == item) && (board[1][1] == item) && (board[2][0] == item) ){
                c = item;
            }
            else
                c = ' ';

        return c;
    }
}

