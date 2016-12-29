package ir.org.acm.main;

import ir.org.acm.tictactoe.TicTacToe;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ben on 12/29/16.
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        HashMap<Integer,Character> map = new HashMap<Integer,Character>();
        map.put(0,'x');
        map.put(1,'o');

        TicTacToe ticTacToe = new TicTacToe();
        boolean validation;
        boolean flag = false;
        while(true) {
            int intFlag = (flag) ? 1 : 0;
            System.out.println("player " + intFlag + "'s turn:");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            while (!ticTacToe.isValid(row, col)) {
                System.out.println("you have entered an invalid element address.try again:");
                row = sc.nextInt() - 1;
                col = sc.nextInt() - 1;
            }
            ticTacToe.insertItem(row, col, map.get(intFlag));


            if(ticTacToe.determineWinner(row,col,map.get(intFlag)) == map.get(intFlag)){
                System.out.println("Player "+ map.get(intFlag) + " wins the Game !");
                break;
            }
            else if(ticTacToe.determineWinner(row,col,map.get(intFlag)) == 'f') {
                System.out.println("Game finishes equally...");
                break;
            }
            else {
                flag = !flag;
            }
        }
    }
}
