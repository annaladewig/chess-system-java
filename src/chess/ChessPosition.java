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

	/** Método que converte a posição de ChessPosition para Position.
	*	Observação: Para achar a linha da posição da matriz, é só pegar 8 e subtrair do valor da linha na posição do xadrez.
	*				Para achar a coluna da posição da matriz, é só subtrair a coluna do xadrez do caractere "a". 
	*					Exemplo: o código unicode do caractere "b" e subtrair do código unicode do caractere "a", resulta 1. 
	*/
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//Método que converte de Position para ChessPosition.
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;  //O "" no começo é para forçar o compilador a entender que é uma concatenação de strings.
	}
}
