public class Board {
    private final Player[][] values;

    public Board(Player[][] values) {
        this.values = values;
    }

    public boolean isPositionTakenOn(HorizontalPosition horizontalPosition, VerticalPosition verticalPosition) {
        return values[horizontalPosition.getValue()][verticalPosition.getValue()] != null;
    }

    public void mark(Player player, HorizontalPosition horizontalPosition, VerticalPosition verticalPosition) {
        this.values[horizontalPosition.getValue()][verticalPosition.getValue()] = player;
    }
}
