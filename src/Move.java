import java.util.Stack;

public class Move extends Main {
    int moveX;
    int moveY;
    int piece;

    Player Player = new Player();

    public boolean isValidPlace(int moveX, int moveY, int piece, Stack<Piece>[][] Board, Stack<Piece>[] p1Pieces, Stack<Piece>[] p2Pieces) {

        //check out of bounds
        if (moveX > 3 || moveY > 3) {
            System.out.print("Move Out Of Bounds! Move must be a space from 1 to 4");
            return false;
        }

        //check to see if players have the piece?
        if (Player.getPlayer() == PlayerNumber.ONE) { //check what players turn is it
            //check to see if player1 Has given piece
            if (!Player.hasPiece(piece, p1Pieces)) {
                System.out.print("You don't have the piece!");
                return false;
            }
        }
        else if (Player.getPlayer() == PlayerNumber.TWO) {
            //check to see if player2 has given piece
            if (!Player.hasPiece(piece, p2Pieces)) {
                System.out.print("You don't have the piece!");
                return false;
            }
        }

        //check to see if piece is larger than piece on the square
        if (Board[moveY][moveX].peek().value >= piece) {
            System.out.print("The piece " + piece % 10 + " isn't large enough to be placed at " + (moveX+1) +"," + (moveY+1));
            return false;
        }

        return true;
    }

    public Stack<Piece>[][] takeMove(int pMove, Stack<Piece>[][] Board, Stack<Piece>[] p1Pieces, Stack<Piece>[] p2Pieces) {
       //make board object
        Board BoardObj = new Board();


        //get row and col
        moveX = Integer.parseInt(Integer.toString(pMove).substring(0, 1)) - 1;//first digit FUCK cant be zero for some reason which is why board must be 1 instead of 0
        moveY = Integer.parseInt(Integer.toString(pMove).substring(1, 2)) - 1;//second digit
        piece = Integer.parseInt(Integer.toString(pMove).substring(2, 3));//third digit


        //execute move
        if (isValidPlace(moveX, moveY, piece, Board, p1Pieces, p2Pieces)) {
            Board[moveY][moveX].push(new Piece(Player.getPlayer(),piece));//add piece to stack in array
            singleMove = false;

            //remove
            if (Player.getPlayer() == PlayerNumber.ONE) {
                Player.subPiece(piece, p1Pieces);
            } else {
                Player.subPiece(piece, p2Pieces);
            }
            System.out.print(BoardObj.toString(Board)); //print board
        }
        return Board;
    }

    public Stack<Piece>[][] movePiece(int start, int end, Stack<Piece>[][] Board) {
        //make board object
        Board BoardObj = new Board();

       //starting coordinates
        int startX = Integer.parseInt(Integer.toString(start).substring(0, 1)) - 1;//;
        int startY = Integer.parseInt(Integer.toString(start).substring(1, 2)) - 1;
        //ending coordinates
        int endX = Integer.parseInt(Integer.toString(end).substring(0, 1)) - 1;//;
        int endY = Integer.parseInt(Integer.toString(end).substring(1, 2)) - 1;

        //if move is valid, do move
        if(isValidMove(startX, startY, endX, endY, Board)) {
            Board[endY][endX].push(Board[startY][startX].pop());
            singleMove = false;
            System.out.print(BoardObj.toString(Board)); //print board
        }
        return Board;
    }


    public boolean isValidMove(int startX, int startY, int endX, int endY, Stack<Piece>[][] Board) {
        //need to check is the start position contains a piece that is the player.
        if(Board[startY][startX].peek().player != Player.getPlayer()){
            System.out.println("You cant move that piece");
            return false;
        }
        //need to check to see if the end position is a valid move
        if(Board[startY][startX].peek().value <= Board[endY][endX].peek().value){
            System.out.println("Piece cannot be placed there");
            return false;
        }

        return true;
    }
}