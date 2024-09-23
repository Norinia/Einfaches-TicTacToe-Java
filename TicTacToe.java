package TicTacToe;

import java.util.Scanner;
// vorerst beendet 18.7.24
// weiter bearbeitet:
public class TicTacToe {
    public static String[][] board;
    public static String eingabe;
    public static boolean test=false;
    public static Scanner s = new Scanner(System.in);
    public static String player;
    public static int auswahl;


        public static void ausgabe(){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
            
        public static void setzten(){
            System.out.print("Zahl angeben an der X gesetzt werden soll:");
            eingabe = s.nextLine();
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[i].length;j++){
                    if(board[i][j].equals(eingabe)){
                        board[i][j] = player;
                    }
                }
            }

        }

        public static void switchPlayer(){
            if(player.equals("X")){
                player = "O";

            }else  {
                player = "X";

            }
        }

        public static String[][] player2(){
            int randomZahl = (int) (Math.random()*9)+1;
            String zahl = Integer.toString(randomZahl);
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[i].length;j++){
                    if(board[i][j].equals(zahl)){
                        board[i][j] = "O";
                    }
                }
            }

            return board;
        }



        /*public static int checkWinner() {
                System.out.println("Winner?");
            if (winner > 0) {
                System.out.print("X?");
                winnerTrue = 1;
                return winnerTrue;
            }else if (winner > 8) {
                System.out.print("O?");
                winnerTrue=2;
                return winnerTrue;
                 }
            else return winnerTrue;
        }
         */
        public static boolean gewonnen(){ // mit dem Methoden aufruf wird t in der hatGewonnen Methode ein wert gegeben
            return hatGewonnen("X") || hatGewonnen("O");
        }

        public static boolean hatGewonnen(String t){ // t bekommt hier den Wert von dem Methoden aufruf
            // 0. Zeile horizontal
            if(board[0][0].equals(t) && board[0][1].equals(t) && board[0][2].equals(t))
                return true;
            //1. zeile horizontal
            if (board[1][0].equals(t) && board[1][1].equals(t)&& board[1][2].equals(t))
                return true;
            // 2. zeile horizontal
            if(board[2][0].equals(t)&& board[2][1].equals(t) && board[2][2].equals(t))
                return true;
            // 0. Zeile vertikal
            if(board[0][0].equals(t)&& board[1][0].equals(t) && board[2][0].equals(t))
                return true;
            // 1. Zeile vertikal
            if(board[0][1].equals(t)&& board[1][1].equals(t) && board[2][1].equals(t))
                return true;
            // 2. Zeile vertikal
            if(board[0][2].equals(t)&& board[1][2].equals(t) && board[2][2].equals(t))
                return true;
            // 1. Diagonal von links oben nach rechts unten
            if(board[0][0].equals(t)&& board[1][1].equals(t) && board[2][2].equals(t))
                return true;
            //2. Diagonal von rechts oben nach links unten
            if(board[0][2].equals(t)&& board[1][1].equals(t) && board[2][0].equals(t))
                return true;

            return false;
        }

        public static void main(String[] args) {
            player = "X";
            board = new String[][] {{"1","2","3"}, {"4","5","7"}, {"6","8","9"}};
            System.out.println("Willkommen beim unübersichtlichten TicTacToe");

                while (!gewonnen()) {
                    ausgabe();
                    if (player.equals("X")) {
                        setzten();
                    } else {
                        player2();
                    }
                    switchPlayer();
                }
                ausgabe();

            if(hatGewonnen("X")) System.out.println("X hat gewonnen!");
            if(hatGewonnen("O")) System.out.println("O hat gewonnen!");
        }






}

