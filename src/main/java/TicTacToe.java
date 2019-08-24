public class TicTacToe {
    public void place(Player player) {
        if(player.equals(Player.O)){
            throw new PlayerXPlacesFirst();
        }
    }
}
