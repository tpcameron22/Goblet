import java.util.Stack;
public class GameStatus {

    public whoWon winCheck(Stack<Piece>[][] Board) {

        int i, j;
        int counter = 0;
        //player object to get whose turn it is
        Player playerObj;
        playerObj = new Player();
        PlayerNumber playerTurn = playerObj.getPlayer();
        //iterate through board
        //row
        for (i = 0; i < Board.length; i++) {
            for (j = 0; j < Board[0].length; j++) {
                //check to see if number is whose turn it is
                if (Board[i][j].peek().player != playerTurn) {
                    counter = 0;
                    break;
                }
                counter +=1;
                //check to see if there was a full iteration
                if(counter == 4){
                    return  playerObj.getPlayer() == PlayerNumber.ONE ? whoWon.PlayerOne : whoWon.PlayerTwo;
                }
            }
        }
        //column
        for (j = 0; j < Board[0].length; j++) {
            for (i = 0; i < Board.length; i++) {
                //check to see if number is whose turn it is
                if (Board[i][j].peek().player != playerTurn) {
                    counter = 0;
                    break;
                }
                counter +=1;
                //check to see if there was a full iteration
                if(counter == 4){
                    return  playerObj.getPlayer() == PlayerNumber.ONE ? whoWon.PlayerOne : whoWon.PlayerTwo;

                }
            }
        }
        //diagonal

            for (i = 0; i < Board.length; i++) {
                if (Board[i][i].peek().player != playerTurn) {
                    counter = 0;
                    break;
                }
                counter += 1;
                if (counter == 4) {
                    return  playerObj.getPlayer() == PlayerNumber.ONE ? whoWon.PlayerOne : whoWon.PlayerTwo;
                }
            }

        //diagonal2
            for (i = 0; i < Board.length; i++) {
                if (Board[i][Board.length - 1 - i].peek().player != playerTurn) {
                    //don't need to reset counter here because it is the last iteration. it'll reset at the top of function. but in case it doesn't work, counter = 0;
                    break;
                }
                counter += 1;
                if (counter == 4) {
                    return  playerObj.getPlayer() == PlayerNumber.ONE ? whoWon.PlayerOne : whoWon.PlayerTwo;
                }
            }

        //return win
        return whoWon.InProgress;
    }
}

enum whoWon{
    PlayerOne,
    PlayerTwo,
    InProgress,
}