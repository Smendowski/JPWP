package game;

import game.pieces.Color;
import game.pieces.Piece;

public class Game {
    private final Board board = new Board();

    public Board getBoard() {
        return this.board;
    }

    public boolean move(Movement movement) {
        if (!isValidMovement(movement)) {
            return false;
        }

        Piece piece = board.at(movement.getOrigin());
        piece.setMoved();
        board.move(movement);


        // Zmiana ruchu
        if (turn == Color.WHITE) {
            turn = Color.BLACK;
        } else {
            turn = Color.WHITE;
        }

        return true;
    }

    public boolean isValidMovement(Movement movement) {
        if (!movement.valid()) {
            return false;
        }

        // jeśli cel to miejsce gdzie jakiś pionek się znajduje...  lub de facto brak ruchu
        if (board.at(movement.getOrigin()).getColor() == board.at(movement.getTarget()).getColor()) {
            return false;
        }

        return board.at(movement.getOrigin()).isValidMovement(this, movement);  //zwraca czy pionek pod wskazana pozycja moze sie ruszyc
    }
}
