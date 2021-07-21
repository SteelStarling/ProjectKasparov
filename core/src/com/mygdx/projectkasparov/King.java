package com.mygdx.projectkasparov;

public class King extends Piece {

    /**
     * Default King piece constructor
     * @param color  Color of the piece
     * @param x      x position of the piece
     * @param y      y position of the piece
     */
    public King(PieceColor color, int x, int y) {
        super(PieceType.KING, PieceState.UNMOVED, color, x, y);
    }

    /**
     * King piece constructor for Kings of unknown state
     * @param state  State of the piece
     * @param color  Color of the piece
     * @param x      x position of the piece
     * @param y      y position of the piece
     */
    public King(PieceState state, PieceColor color, int x, int y) {
        super(PieceType.KING, state, color, x, y);
    }
}
