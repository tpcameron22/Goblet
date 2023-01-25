import java.util.Stack;
public class Player extends Main {


    public Stack<Piece>[] makePieces(PlayerNumber player) {
            Stack<Piece>[] pieces = new Stack[3];
            for (int i = 0; i < 3; i++) {
                pieces[i] = new Stack<>();
                pieces[i].push(new Piece(player, 1));
                pieces[i].push(new Piece(player, 2));
                pieces[i].push(new Piece(player, 3));
                pieces[i].push(new Piece(player, 4));
            }
            return pieces;
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
