package cpsc2150.extendedTicTacToe;


/* Thomas Sallurday
   Homework 3
   CPSC 2150
   6/27/2019
 */
public abstract class AbsGameBoard implements IGameBoard {
    /**
     * @return a nicely formatted string that shows the gameboard
     * @post String != memory location string == grid
     */
    @Override
    public String toString(){
        int i,j;
        char symbol;
        BoardPosition BP;
        String output = "    0|";
        // for loop that puts all the column numbers at the top of the board
        for(i = 1; i < getNumColumns(); i++){
            if(i < 10) {
                output = output + " " + i + "|"; // extra space required if i is less than 10
            }
            else{
                output = output + i + "|";
            }
        }
        for(i = 0; i < getNumRows(); i++){ // for loop that sets up the row numbers
            if(i < 10){
                output = output + "\n" + " " + i + "|"; // extra space required if i < 10
            }
            else{
                output = output + "\n" + i + "|";
            }
            for(j = 0; j < getNumColumns(); j++){ // for loop puts the contents of board in the right space
                BP = new BoardPosition(i,j);
                symbol = whatsAtPos(BP);
                output = output + symbol + " " + "|";
            }
        }
        return output + "\n";
    }
}
