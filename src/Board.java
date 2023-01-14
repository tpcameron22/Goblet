import java.util.Stack;
public class Board extends Main{
//colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String WHITE_BOLD = "\033[1;97m";   // WHITE
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String RESET = "\033[0m";  // Text Reset

    //make board
    public Stack<Piece>[][] GameBoard = new Stack[4][4];

    public Stack<Piece>[][] FillBoard() {
        //fill board with squares
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //initialize each square to have 0
                Stack<Piece> Square = new Stack<>();
                Square.push(new Piece(PlayerNumber.EMPTY, 0));
                //put square on board
                GameBoard[i][j] = Square;
            }
        }
        return GameBoard;
    }
//Integer.parseInt(Integer.toString(Board[i][j].peek()).substring(0, 1))
    public String toString(Stack<Piece>[][] board){

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
}



