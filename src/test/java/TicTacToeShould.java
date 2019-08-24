import org.junit.Test;

public class TicTacToeShould {

//    X always goes first.
//    Players alternate placing X’s and O’s on the board.
//    Players cannot play on a played position.
//    A player with three X’s or O’s in a row (horizontally, vertically, diagonally) wins.
//    If all nine squares are filled and neither player achieves three in a row, the game is a draw.

    @Test(expected = PlayerXPlacesFirst.class)
    public void not_allow_that_player_O_places_first() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.place(Player.O);
    }

    @Test
    public void allow_player_X_place_first() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.place(Player.X);
    }
}
