package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	/** M�todo que converte a posi��o de ChessPosition para Position.
	*	Observa��o: Para achar a linha da posi��o da matriz, � s� pegar 8 e subtrair do valor da linha na posi��o do xadrez.
	*				Para achar a coluna da posi��o da matriz, � s� subtrair a coluna do xadrez do caractere "a". 
	*					Exemplo: o c�digo unicode do caractere "b" e subtrair do c�digo unicode do caractere "a", resulta 1. 
	*/
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//M�todo que converte de Position para ChessPosition.
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;  //O "" no come�o � para for�ar o compilador a entender que � uma concatena��o de strings.
	}
}
