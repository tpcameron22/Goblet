import java.util.Scanner;
import java.util.Stack;

public class Main {

    //for keeping track of turn moves and what player it is
    public static int count = 0;
    public static boolean singleMove = true;
    public static boolean game = true;

    public static void main(String[] args) {

        //make board class object.
        Board BoardObj = new Board();

        //Make new Move Obj
        Move moveObj;
        moveObj = new Move();

        //make gameStatus object
        GameStatus GameStatusObj;
        GameStatusObj = new GameStatus();

        //fill the object to make the board
        Stack<Piece>[][] Board = BoardObj.FillBoard();
        System.out.print(BoardObj.toString(Board));

        //make player object and initialize pieces.
        Player playerObj;
        playerObj = new Player();
        Stack<Piece>[] p1Pieces = playerObj.makePieces();
        //make a new list for p2
        Stack<Piece>[] p2Pieces = playerObj.makePieces2();



        //prepare scanner
        Scanner scan = new Scanner(System.in);

        //input a move
        while(game) {
            //turn checker
            boolean player1 = playerObj.getPlayer() == PlayerNumber.ONE;
            //state whose turn it is and print their available pieces
            if (player1) {
                System.out.print("Player Ones Turn");
                System.out.print(playerObj.toString(p1Pieces));
            } else {
                System.out.print("Player Twos Turn");
                System.out.print(playerObj.toString(p2Pieces));
            }

            //ask for move
            while (singleMove) {
                System.out.println("\n" +"Type place to place a new piece or move to move an existing piece");
                String ask = scan.next();
                if(ask.equals("place")) {
                    System.out.println("\n" + "enter move in the form of int(X) int(Y) int(Piece Size) to place a new coordinate. For Example: 123");
                    int pMove = scan.nextInt();

                    //execute move
                    Board = moveObj.takeMove(pMove, Board, p1Pieces, p2Pieces);

                }
                else if(ask.equals("move")){
                    //set up move
                    System.out.println("Type the coordinate of the piece you wish to move");
                    int start = scan.nextInt();

                    System.out.println("Type the coordinate you wish to move that piece to");
                    int end = scan.nextInt();

                    //execute move
                    Board = moveObj.movePiece(start, end, Board);
                }
                else{
                    System.out.println("Invalid Input: please type either place or move, all lowercase"); //print board
                }

                //check for gameStatus
                if (GameStatusObj.winCheck(Board) != whoWon.InProgress) {
                    System.out.println(GameStatusObj.winCheck(Board) + " Won the game!");
                    game = false;//end game cycle
                }
            }
            count += 1;// update counter saying a move has been completed
            singleMove = true; //reset singleMove

        }
    }
}


/*
current errors: NONE
 */
