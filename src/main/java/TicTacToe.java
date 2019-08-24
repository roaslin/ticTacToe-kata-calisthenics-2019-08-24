public class TicTacToe {
    private Player lastPlaced;
    private Board board;

    public TicTacToe(Board board) {
        this.board = board;
    }

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

        if (board.hasAWinner()) {
            if (Player.X == player) {
                throw new PlayerXWinsException("Player " + player + "wins!");
            }

            if (Player.O == player) {
                throw new PlayerOWinsException("Player " + player + "wins!");
            }
        }

        if (board.isEndGame()) {
            throw new EndGameException();
        }
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
