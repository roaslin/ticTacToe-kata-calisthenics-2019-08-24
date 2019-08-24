public class TicTacToe {
    private Player lastPlaced;

    public void place(Player player) {
        if(player.equals(Player.O) && lastPlaced == null){
            throw new PlayerXPlacesFirst();
        }
        this.lastPlaced = player;
    }
}
