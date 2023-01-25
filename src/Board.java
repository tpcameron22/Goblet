import java.util.Stack;
public class Board extends Main{
//colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String WHITE_BOLD = "\033[1;97m";   // WHITE
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String RESET = "\033[0m";  // Text Reset

    //make board
    public Stack<Piece>[][] GobGameBoard = new Stack[4][4];

    public Stack<Piece>[][] FillGobletBoard() {
        //fill board with squares
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //initialize each square to have 0
                Stack<Piece> Square = new Stack<>();
                Square.push(new Piece(PlayerNumber.EMPTY, 0));
                //put square on board
                GobGameBoard[i][j] = Square;
            }
        }
        return GobGameBoard;
    }

    public String GobtoString(Stack<Piece>[][] board){

        //create string
        StringBuilder FString = new StringBuilder();
        FString.append("\n      GOBLET  \n   1   2   3   4\n");

        for(int i = 0; i <  4; i++) {
            FString.append(i+1).append("| ");
            for (int j = 0; j < 4; j++) {
                //change color
                if(board[i][j].peek().player == PlayerNumber.TWO){
                    FString.append(BLACK);
                }

                //else turn white
                else if(board[i][j].peek().player == PlayerNumber.ONE){
                    FString.append(WHITE_BOLD);
                }
                else{
                    FString.append(WHITE);
                }
                //print number
                FString.append(board[i][j].peek().value);
                //if player two turn black
                FString.append(RESET + " | ");
            }
            FString.append("\n  ---+---+---+----\n");
        }
        return FString.toString();
    }


    //checkers
    public Piece[][] CheckersBoard = new Piece[8][8];
    public Piece[][] FillCheckersBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                    if (i < 3 && (i + j) % 2 == 0) {
                        CheckersBoard[i][j] = new Piece(PlayerNumber.ONE, 0);
                    }
                    else if ((i + j) % 2 == 0 && i > 4) {
                        CheckersBoard[i][j] = new Piece(PlayerNumber.TWO, 0);
                    }
                    else{
                        CheckersBoard[i][j] = new Piece(PlayerNumber.EMPTY, 0);
                    }
            }
        }
        return CheckersBoard;
    }


    //makes checkers board with no pieces on it. just black and white and the player value
    public String ChecktoString(Piece[][] board){
        //create string
        StringBuilder FString = new StringBuilder();
        FString.append("\n    Checkers    \n   1   2   3   4   5   6   7   8\n");

        for(int i = 0; i <  8; i++) {
            FString.append(i+1).append("| ");
            for (int j = 0; j < 8; j++) {
                //change color
                if(board[i][j].player == PlayerNumber.TWO){
                    FString.append(BLACK);
                } else if(board[i][j].player == PlayerNumber.ONE){
                    FString.append(WHITE_BOLD);
                }
                //else turn white
                else{
                    FString.append(WHITE);
                }
                //print number
                FString.append(board[i][j].value);
                //reset color for each number
                FString.append(RESET + " | ");
            }
            FString.append("\n  ---+---+---+---+---+---+---+---+\n");
        }
        return FString.toString();
    }
}





