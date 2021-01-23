default: cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/AbsGameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java
	javac cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/AbsGameBoard.java

run: cpsc2150/extendedTicTacToe/BoardPosition.class cpsc2150/extendedTicTacToe/GameBoard.class cpsc2150/extendedTicTacToe/GameScreen.class cpsc2150/extendedTicTacToe/IGameBoard.class cpsc2150/extendedTicTacToe/AbsGameBoard.class cpsc2150/extendedTicTacToe/GameBoardMem.class
	java cpsc2150.extendedTicTacToe.GameScreen

clean: 
	rm -f cpsc2150/extendedTicTacToe/*.class
