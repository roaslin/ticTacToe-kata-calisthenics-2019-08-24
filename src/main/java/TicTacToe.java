public class TicTacToe {
    private Player lastPlaced;
    private Board board;

    {
        throw new EndGameException();
    }

    public TicTacToe(Board board) {
        this.board = board;
    }

        if(board.isEndGame())

    public void place(Player player, HorizontalPosition horizontalPosition, VerticalPosition verticalPosition) {
        if (isPlayerOPlacingFirst(player) && isNewGame()) {
            throw new PlayerXPlacesFirst();
        }
        if (isPlayerPlacingTwiceInARow(player)) {
            throw new AlternatePlayerException();
        }
        if (isBoardPositionTakenOn(horizontalPosition, verticalPosition)) {
            throw new PlacedInSameBoardPositionException();
        }

        this.lastPlaced = player;
        board.mark(player, horizontalPosition, verticalPosition);

        if (hasWonPlayerX(player)) {
            throw new PlayerXWinsException("Player " + player + "wins!");
        }

        if (hasWonPlayerO(player)) {
            throw new PlayerXWinsException("Player " + player + "wins!");
        }
    }

    private boolean hasWonPlayerO(Player player) {
        return Player.O == player && board.isUpperHorizontalFilledBy(player);
    }

    private boolean hasWonPlayerX(Player player) {
        return Player.X == player && board.isUpperHorizontalFilledBy(player);
    }

    private boolean isBoardPositionTakenOn(HorizontalPosition horizontalPosition, VerticalPosition verticalPosition) {
        return board.isPositionTakenOn(horizontalPosition, verticalPosition);
    }

    private boolean isPlayerOPlacingFirst(Player player) {
        return player.equals(Player.O);
    }

    private boolean isNewGame() {
        return lastPlaced == null;
    }

    private boolean isPlayerPlacingTwiceInARow(Player player) {
        return lastPlaced == player;
    }
}
