package game.pieces;

import game.Board;
import game.Game;
import game.Movement;
import game.Position;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, "bishop");
    }

    @Override
    public boolean isValidMovement(Game game, Movement movement) {
        if (Math.abs(movement.getRowOffset()) == Math.abs(movement.getColOffset())) {
            // Zmiana na false, to cała metdoa bo isValid, gdy zarejestruje poprawny ruch powinna zwrócić true
            return false;
        }

        // O ile mam się przesunąć, sprawdzaj każdy ruch jednostkowy
        for (int i = 1; i < Math.abs(movement.getRowOffset()); i++) {
            int rowOffset;
            int colOffset;
            if (movement.getRowOffset() < 0){
                rowOffset = -i;
            } else {
                rowOffset = i;
            }

            if (movement.getColOffset() < 0){
                colOffset = -i;
            } else {
                colOffset = i;
            }
            Position current = new Position(movement.getOriginRow() + rowOffset, movement.getOriginCol() + colOffset);
        }

        Board board = game.getBoard();
        return true;
    }

}