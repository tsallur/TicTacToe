package cpsc2150.extendedTicTacToe;

/* Thomas Sallurday
   Homework 3
   CPSC 2150
   6/27/2019
 */
public class GameBoard extends AbsGameBoard {
    /**
     * @invariant rowSize >= minSize and rowSize <= maxSize
     * @invarint colSize >= minSize and colSize <= maxSize
     * @invariant board = char[rowSize][colSize]
     * @invariant inARowNumToWin >= GameScreen.minWinNum and inARowNumToWin <= maxWinNum
     * Correspondence rows = rowSize
     * Correspondence cols = colSize
     * Correspondence toWin = inARowNumToWin
     */
    private int rowSize;
    private int colSize;
    private int inARowNumToWin;
    private char[][] board;

    public void placeMarker(BoardPosition marker,char player){
        int row = marker.getRow();
        int col = marker.getCol();

        board[row][col] = player;
    }

    public char whatsAtPos(BoardPosition pos){
        return board[pos.getRow()][pos.getCol()];
    }

    /**
     * @pre rowSize >= minSize and rowSize <= maxSize, colSize >= minSize and colSize <= Maxsize, winNum >= GameScreen.minWinNum and winNum <= GameScreen.maxWinNum
     * @param rowSize the number of rows you want the board to have
     * @param colSize the number of columns you want the board to have
     * @param winNum the number of identical characters that must be in a row in order for a player to win
     * @post this.rowSize(rowSize),this.colSize(colSize),blankSpaceRem(rowSize * colSize),board = char[rowSize][colSize]
     */
    public GameBoard(int rowSize,int colSize,int winNum){
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.inARowNumToWin = winNum;
        int i,j;
        board = new char[rowSize][colSize];
        // for loop initializes all board spaces to a whitespace character
        for(i = 0; i < rowSize; i++){
            for(j = 0; j < colSize; j++){
                board[i][j] = ' ';
            }
        }
    }

    public int getNumRows(){
        return rowSize;
    }

    public int getNumColumns(){
        return colSize;
    }

    public int getNumToWin(){
        return inARowNumToWin;
    }
}

