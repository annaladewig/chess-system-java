package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	// M�todo para retornar a posi��o de uma pe�a no formato do xadrez.
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	// M�todo que verifica se existe uma pe�a advers�ria na dada posi��o.
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}
