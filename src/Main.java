/*

Design a TICTACTOE Game that two users could play and catch exceptions and errors if the user inputs wrongly. The game should also decide
if there is a winner, a draw, e.t.c


 */
import java.util.*;

public class Main {
    private Scanner scanner;
    String tools;

    public Main() {
        scanner = new Scanner(System.in);
        tools = new String(" ");

    }

    public static void main(String[] args) {
        Main ticTacToe = new Main();
        // Scanner scanner = new Scanner(System.in);
        // String enter = scanner.next();


        char[][] chat ={{'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
    };

        ticTacToe.placeGameBoard(chat);
        //ticTacToe.playDefault(chat);
        ticTacToe.mainThing(chat);
    }

    public void placeGameBoard(char[][] yah) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(yah[i][j]);
            }
            System.out.println();
        }
    }

    public void mainThing(char[][] yah){
        while(true){
            XinputUser(yah);
            OinputUser(yah);
        }
    }



    public void playDefault(char[][] yah) {
        String tools;
        System.out.print("Enter cells: ");
        tools = scanner.next();
        yah[1][2] = tools.charAt(0);
        yah[1][4] = tools.charAt(1);
        yah[1][6] = tools.charAt(2);
        yah[2][2] = tools.charAt(3);
        yah[2][4] = tools.charAt(4);
        yah[2][6] = tools.charAt(5);
        yah[3][2] = tools.charAt(6);
        yah[3][4] = tools.charAt(7);
        yah[3][6] = tools.charAt(8);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(yah[i][j]);
            }
            System.out.println();
        }
        scanner.nextLine();
    }

    public void XinputUser(char[][] yah) {
        int r;
        int t;
        String rt;
    while(true) {
    System.out.print("Enter Coordinates: ");
    rt = scanner.nextLine();

    try {
        r = Integer.parseInt(rt.substring(0, 1));
        t = Integer.parseInt(rt.substring(2, 3));

    } catch (Exception d) {
        System.out.println("You should enter numbers!");
       continue;
    }

        if((r>3||r<1)||(t>3||t<1)){
            System.out.println("Coordinates should be from 1 to 3!");

        }else if (t==1) {
            if(yah[r][t+1] == 'X' || yah[r][t+1] == 'O'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            yah[r][t+1] = 'X';
            break;
        }else if (t==2) {
            if(yah[r][t+2] == 'X' || yah[r][t+2] == 'O'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            yah[r][t+2] = 'X';
            break;
        }else {
            if(yah[r][t+3] == 'X' || yah[r][t+3] == 'O'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            yah[r][t+3] = 'X';
            break;
        }

}
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(yah[i][j]);
            }
            System.out.println();
        }

        gameCheck(yah);
    }

    public void dImpossible(char[][] yah){
        int xct = XXCount();
        int yct = OOCount() ;
        if((testX(yah)==true && testY(yah)==true)||(testY(yah)==true && testX(yah)==true)||
                ( xct - yct >1)||(yct - xct >1)){
            System.out.println("Impossible");
            System.exit(0);
        }
    }

    public void OinputUser(char[][] yah) {
        int r;
        int t;
        String rt;
        while(true) {
            System.out.print("Enter Coordinates: ");
            rt = scanner.nextLine();

            try {
                r = Integer.parseInt(rt.substring(0, 1));
                t = Integer.parseInt(rt.substring(2, 3));

            } catch (Exception d) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if((r>3||r<1)||(t>3||t<1)){
                System.out.println("Coordinates should be from 1 to 3!");

            }else if (t==1) {
                if(yah[r][t+1] == 'X' || yah[r][t+1] == 'O'){
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                yah[r][t+1] = 'O';
                break;
            }else if (t==2) {
                if(yah[r][t+2] == 'X' || yah[r][t+2] == 'O'){
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                yah[r][t+2] = 'O';
                break;
            }else {
                if(yah[r][t+3] == 'X' || yah[r][t+3] == 'O'){
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                yah[r][t+3] = 'O';
                break;
            }

        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(yah[i][j]);
            }
            System.out.println();
        }

        gameCheck(yah);
    }

    public void dWin(char[][] yah){
        if((testX(yah)==true && testY(yah)==false)){
            System.out.println("X wins");
            System.exit(0);
        }
        if((testY(yah)==true && testX(yah)==false)){
            System.out.println("O wins");
            System.exit(0);
        }
    }

    public void dSpace(char[][] yah){
        if (yah[1][2] == '_' ||yah[1][4] == '_' ||
                yah[1][6] =='_' || yah[2][2] =='_'|| yah[2][4] =='_'|| yah[2][6] =='_'
                ||yah[3][2] =='_'|| yah[3][4] =='_' || yah[3][6] == '_'){

            System.out.println("Game not finished");
        }

    }

    public void dDraw(char[][] yah){
        if (   (yah[1][2] == 'X' || yah[1][2] =='O') &&
                (yah[1][4] == 'X' || yah[1][4]=='O') &&
                (yah[1][6] == 'X' || yah[1][6]=='O') &&
                (yah[2][2] == 'X' || yah[2][2]=='O') &&
                (yah[2][4] == 'X' || yah[2][4]=='O') &&
                (yah[2][6] == 'X' || yah[2][6]=='O') &&
                (yah[3][2] == 'X' || yah[3][2]=='O') &&
                (yah[3][4] == 'X' || yah[3][4]=='O') &&
                (yah[3][6] == 'X' || yah[3][6]=='O')   ){
            System.out.println("Draw");
            System.exit(0);
        }

    }

    public void gameCheck(char[][] yah){
        dImpossible(yah); //PASSED
        dWin(yah);        //PASSED
        dDraw(yah);
        dSpace(yah);
    }

    public boolean testY(char[][] yah){
        Boolean situation = false;
        if( yah[1][2] == 'O' && yah[1][4] =='O' && yah[1][6] =='O'){
            //  System.out.println("O wins");
            situation = true;
        }
        if( yah[2][2] == 'O' && yah[2][4] =='O' && yah[2][6] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        if( yah[3][2] == 'O' && yah[3][4] =='O' && yah[3][6] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        // Vertical
        if( yah[1][2] == 'O' && yah[2][2] =='O' && yah[3][2] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        if( yah[1][4] == 'O' && yah[2][4] =='O' && yah[3][4] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        if( yah[1][6] == 'O' && yah[2][6] =='O' && yah[3][6] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        //Diagonal
        if( yah[1][2] == 'O' && yah[2][4] =='O' && yah[3][6] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        if( yah[1][6] == 'O' && yah[2][4] =='O' && yah[3][2] =='O'){
            //System.out.println("O wins");
            situation = true;
        }
        return situation;
    }

    public Boolean testX(char[][] yah){
        Boolean present = false;
        // Ist Horizontal win
        if( yah[1][2] == 'X' && yah[1][4] =='X' && yah[1][6] =='X'){
            // System.out.println("X wins");
            present = true;
        }
        // 2nd Horizontal Win
        if( yah[2][2] == 'X' && yah[2][4] =='X' && yah[2][6] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        //3rd Horizontal Win
        if( yah[3][2] == 'X' && yah[3][4] =='X' && yah[3][6] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        //Ist Vertical Win
        if( yah[1][2] == 'X' && yah[2][2] =='X' && yah[3][2] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        //2nd Vertical Win
        if( yah[1][4] == 'X' && yah[2][4] =='X' && yah[3][4] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        //3rd Vertical Win
        if( yah[1][6] == 'X' && yah[2][6] =='X' && yah[3][6] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        //Ist Zone
        if( yah[1][2] == 'X' && yah[2][4] =='X' && yah[3][6] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        //2nd Zone
        if( yah[1][6] == 'X' && yah[2][4] =='X' && yah[3][2] =='X'){
            //System.out.println("X wins");
            present = true;
        }
        return present;
    }

    //{------------------------------------------------------------------------------------------------
// {------------------------------------------------------------------------------------------------
    private int XXCount(){
        int length = tools.length();
        int xCount = 0;
        int c = 0;
        while (c<length){
            if (tools.charAt(c) == 'X'){
                xCount++;
            }
            c++;
        }
        return xCount;
    }

    private int OOCount(){
        int length = tools.length();
        int Ocount = 0;
        int d = 0;
        while (d<length){
            if (tools.charAt(d) == 'O'){
                Ocount++;
            }
            d++;
        }
        return Ocount;
    }

}
