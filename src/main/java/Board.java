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

    public boolean isEndGame() {
        for (int horizontal = 0; horizontal < values.length; horizontal++) {
            for (int vertical = 0; vertical < values[0].length; vertical++) {
                if (values[horizontal][vertical] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasAWinner() {
        if(Player.X == values[0][0]
                && Player.X == values[0][1]
                && Player.X == values[0][2]){

            return true;
        }

        if(Player.O == values[0][0]
                && Player.O == values[0][1]
                && Player.O == values[0][2]){

            return true;
        }
        return false;
    }
}
