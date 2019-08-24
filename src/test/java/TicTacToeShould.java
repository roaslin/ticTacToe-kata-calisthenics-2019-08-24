import org.junit.Before;
import org.junit.Test;

public class TicTacToeShould {
    private TicTacToe ticTacToe;

//    X always goes first.
//    Players alternate placing X’s and O’s on the board.
//    Players cannot play on a played position.
//    A player with three X’s or O’s in a row (horizontally, vertically, diagonally) wins.
//    If all nine squares are filled and neither player achieves three in a row, the game is a draw.

    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test(expected = PlayerXPlacesFirst.class)
    public void not_allow_that_player_O_places_first() {
        ticTacToe.place(Player.O);
    }

    @Test
    public void allow_player_X_place_first() {
        ticTacToe.place(Player.X);
    }

    @Test
    public void alternate_players() {
        ticTacToe.place(Player.X);
        ticTacToe.place(Player.O);
        ticTacToe.place(Player.X);
        ticTacToe.place(Player.O);
    }
}
