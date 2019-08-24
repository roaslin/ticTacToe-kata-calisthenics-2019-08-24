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
        Board board = new Board(new Player[3][3]);
        ticTacToe = new TicTacToe(board);
    }

    @Test(expected = PlayerXPlacesFirst.class)
    public void not_allow_that_player_O_places_first() {
        ticTacToe.place(Player.O, new HorizontalPosition(0), new VerticalPosition(0));
    }

    @Test
    public void allow_player_X_place_first() {
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(0));
    }

    @Test(expected = AlternatePlayerException.class)
    public void not_allow_player_placing_twice_in_a_row() {
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(0));
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(0));
    }

    @Test
    public void alternate_players() {
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(0));
        ticTacToe.place(Player.O, new HorizontalPosition(0), new VerticalPosition(1));
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(2));
        ticTacToe.place(Player.O, new HorizontalPosition(1), new VerticalPosition(0));
    }

    @Test(expected = PlacedInSameBoardPositionException.class)
    public void not_allow_players_to_place_on_a_played_position() {
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(0));
        ticTacToe.place(Player.O, new HorizontalPosition(0), new VerticalPosition(0));
    }

    @Test(expected = EndGameException.class)
    public void end_game_when_all_position_are_placed() {
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(0));
        ticTacToe.place(Player.O, new HorizontalPosition(0), new VerticalPosition(1));
        ticTacToe.place(Player.X, new HorizontalPosition(0), new VerticalPosition(2));
        ticTacToe.place(Player.O, new HorizontalPosition(1), new VerticalPosition(0));
        ticTacToe.place(Player.X, new HorizontalPosition(1), new VerticalPosition(1));
        ticTacToe.place(Player.O, new HorizontalPosition(2), new VerticalPosition(0));
        ticTacToe.place(Player.X, new HorizontalPosition(2), new VerticalPosition(1));
        ticTacToe.place(Player.O, new HorizontalPosition(2), new VerticalPosition(2));
        ticTacToe.place(Player.X, new HorizontalPosition(1), new VerticalPosition(2));
    }
}
