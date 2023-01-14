import java.util.Stack;
public class Player extends Main {

    //make two sets of pieces. this is required because if I assign both to one function, the edits of one will affect the other.
    Stack<Piece>[] pieces = new Stack[3];
    Stack<Piece>[] pieces2 = new Stack[3];

    public Stack<Piece>[] makePieces() {
        for (int i = 0; i < 3; i++) {
            pieces[i] = new Stack<>();
            pieces[i].push(new Piece(PlayerNumber.ONE, 1));
            pieces[i].push(new Piece(PlayerNumber.ONE, 2));
            pieces[i].push(new Piece(PlayerNumber.ONE, 3));
            pieces[i].push(new Piece(PlayerNumber.ONE, 4));

        }
        return pieces;
    }
    public Stack<Piece>[] makePieces2() {
        for (int i = 0; i < 3; i++) {
            pieces2[i] = new Stack<>();
            pieces2[i].push(new Piece(PlayerNumber.TWO, 1));
            pieces2[i].push(new Piece(PlayerNumber.TWO, 2));
            pieces2[i].push(new Piece(PlayerNumber.TWO, 3));
            pieces2[i].push(new Piece(PlayerNumber.TWO, 4));

        }
        return pieces2;
    }

    //checks to see if the player has the given piece. inverted because it's quicker. It'll stop after finding it.
    public boolean hasPiece(int piece, Stack<Piece>[] playerPieces) {
        for (int i = 0; i < 3; i++) {
            if(!playerPieces[i].empty()) {
                if (playerPieces[i].peek().value == piece) {
                    return true;
                }
            }
        }
        return false;
    }

    //removes piece from playerPieces set
    public void subPiece(int piece, Stack<Piece>[] playerPieces) {
        for (int i = 0; i < 3; i++) {
            if (!playerPieces[i].empty() && playerPieces[i].peek().value == piece) {
                playerPieces[i].pop();
                break;
            }
        }
    }

    //returns the player number whose turn it is
    public PlayerNumber getPlayer() {
        return count % 2 == 0 ? PlayerNumber.ONE : PlayerNumber.TWO;
    }


    public String toString(Stack<Piece>[] pieces) {
        StringBuilder FString = new StringBuilder("\n" + "playable pieces:  | ");

        for (int i = 0; i < 3; i++) {
            if(!pieces[i].empty()) {
                FString.append(pieces[i].peek().value);
            }else{
                FString.append(" ");
            }
                FString.append(" | ");
            }

        return FString.toString();
    }
}
