public class TicTacToe {
    private Player lastPlaced;
    private Board board;

    public TicTacToe(Board board) {
        this.board = board;
    }

    public void place(Player player, HorizontalPosition horizontalPosition, VerticalPosition verticalPosition) {
        if(player.equals(Player.O) && lastPlaced == null){
            throw new PlayerXPlacesFirst();
        }
        if(board.isPositionTakenOn(horizontalPosition, verticalPosition)){
            throw new PlacedInSameBoardPositionException();
        }
        this.lastPlaced = player;
        board.mark(player, horizontalPosition, verticalPosition);

        if(board.isEndGame()){
            throw new EndGameException();
        }
    }
}
