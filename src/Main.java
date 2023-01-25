import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //prepare scanner
        Scanner scan = new Scanner(System.in);
        //choose game
        System.out.println("Type the number of the game you wish to play \n 1. GOBLET \n 2. CHECKERS \n 3. Chess");
        int choice = scan.nextInt();
        if(choice == 1){
            runGoblet();
        }else if(choice == 2) {
            runCheckers();
        }else if(choice == 3) {
            runChess();
        }
        else{
            System.out.println("GOBLET is the only game at the moment, please rerun the program");
        }
    }


    //for keeping track of turn moves and what player it is for
    public static int count = 0;
    public static boolean singleMove = true;
    public static boolean game = true;


//GOBLET

    public static void runGoblet(){

        //make board class object.
        Board BoardObj = new Board();

        //Make new Move Obj
        Move moveObj;
        moveObj = new Move();

        //make gameStatus object
        GameStatus GameStatusObj;
        GameStatusObj = new GameStatus();

        //fill the object to make the board
        Stack<Piece>[][] Board = BoardObj.FillGobletBoard();
        System.out.print(BoardObj.GobtoString(Board));

        //make player object and initialize pieces.
        Player playerObj;
        playerObj = new Player();
        Stack<Piece>[] p1Pieces = playerObj.makePieces(PlayerNumber.ONE);
        //make a new list for p2
        Stack<Piece>[] p2Pieces = playerObj.makePieces(PlayerNumber.TWO);



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
                if(count > 2) {
                    System.out.println("\n" + "Type place to place a new piece");
                }else{
                    System.out.println("\n" + "Type place to place a new piece or move to move an existing piece");
                }
                String ask = scan.next();
                if(ask.equals("place")) {
                    System.out.println("\n" + "enter move in the form of int(X) int(Y) int(Piece Size) to place a new coordinate. For Example: 123");
                    int pMove = scan.nextInt();

                    //execute move
                    Board = moveObj.placePiece(pMove, Board, p1Pieces, p2Pieces);

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

    //CHECKERS

    public static void runCheckers() {
        //temp message
        System.out.print("Checkers hasn't been implemented yet, come back later! \n");
        //make objects
        Board BoardObj = new Board();

        //Make new Move Obj
        Move moveObj;
        moveObj = new Move();

        //make gameStatus object
        GameStatus GameStatusObj;
        GameStatusObj = new GameStatus();

        //make and initialize board
        Piece[][] Board = BoardObj.FillCheckersBoard();
        System.out.print(BoardObj.ChecktoString(Board));

        //make player object and initialize pieces.
        Player playerObj;
        playerObj = new Player();

        //prepare scanner
        Scanner scan = new Scanner(System.in);

        while (game) {
            //state whose turn it is
            if (playerObj.getPlayer() == PlayerNumber.ONE) {
                System.out.print("Player Ones Turn \n ");
            } else {
                System.out.print("Player Twos Turn \n ");
            }

            //execute turn
            while (singleMove) {

                if(count > 2) {
                    System.out.println("\n" + "Type move to move a piece");
                }else{
                    System.out.println("\n" + "Type  move to move a piece or jump to jump a piece");
                }
                String ask = scan.next();
                if(ask.equals("move")) {
                    //set up move
                    System.out.println("Type the coordinate of the piece you wish to move");
                    int start = scan.nextInt();

                    System.out.println("Type the coordinate you wish to move that piece to");
                    int end = scan.nextInt();

                    //execute move
                    Board = moveObj.CheckmovePiece(start, end, Board);
                }
                else if(ask.equals("jump")){
                    //set up move
                    System.out.println("Type the coordinate of the piece you wish to jump with");
                    int start = scan.nextInt();

                    System.out.println("Type the coordinate you wish to land after the jump");
                    int end = scan.nextInt();

                    //execute move
                    Board = moveObj.CheckjumpPiece(start, end, Board);

                }
                else{
                    System.out.println("Invalid Input: please type either move or jump, all lowercase"); //print board
                }


                //check for gameStatus

            }
            count += 1;// update counter saying a move has been completed
            singleMove = true; //reset singleMove

        }
    }

    //CHESS

    public static void runChess(){//temp message
        System.out.print("Chess hasn't been implemented yet, come back later!");
    }
}

/*
current errors: NONE
//At the end, after creation of multiple games, i will refactor names so gobtostring is just tostring.
 */
