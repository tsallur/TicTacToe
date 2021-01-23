package cpsc2150.extendedTicTacToe;

/* Thomas Sallurday
   Homework 3
   CPSC 2150
   6/27/2019
 */
public class BoardPosition {
    /**
     * @invariant colPos and rowPos >= minSize also colPos and rowPos < maxSize
     */
    private int rowPos;
    private int colPos;

    /**
     * @pre rowNum and colNum >= minSize and < maxSize
     * @param rowPos the number corresponding to the row
     * @param colPos the number corresponding to the column
     * @post this.rowPos = rowPos and this.colPos = colPos
     */
    public BoardPosition(int rowPos,int colPos){
        this.rowPos = rowPos;
        this.colPos = colPos;
    }
    /**
     * @return int that is the same number as rowPos
     * @post returned int = this.rowPos
     */

    public int getRow(){
        return rowPos;
    }
    /**
     * @return int that is the same number as ColPos
     * @post returned int = this.rowPos
     */

    public int getCol(){
        return colPos;
    }
    //@Override
    /**
     * @pre bP = constructed
     * @return true if row and col are equal to each other, false otherwise
     */
    public boolean equals(BoardPosition bP){
        if (this.rowPos == bP.rowPos && this.colPos == bP.colPos) {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    /**
     * @return string that is a nicely formatted to show row,col
     * @post string = rowNum,colNum
     */
    public String toString(){
        String text = (rowPos + " " + colPos);

        return text;
    }
}
