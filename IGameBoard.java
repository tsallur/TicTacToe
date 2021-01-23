package cpsc2150.extendedTicTacToe;

/* Thomas Sallurday
   Homework 3
   CPSC 2150
   6/27/2019
 */
/**
 * GameBoard represents a 2D char array of characters where the indexing starts at 0,0 for tic tac toe
 * Initialization ensures: Grid contains whitespace characters
 * Defines:     rows = numberOfRows,
 *              cols = numberOfColumns
 *              toWin = InaRowToWin
 * Constraints: rows minSize and rows maxSize
 *              cols >= minSize and rows <= maxSize
 *              toWin <= colSize and rowSize
 */
public interface IGameBoard {
    int maxSize = 100; // make sure to implement this throughout the program **************
    int minSize = 3;
    /**
     * @pre checkSpace(pos) == true and player == X || player == O
     * @param marker BoardPosition object that holds row and col number
     * @param player the player symbol (X or O)
     * @post grid[row][col = symbol
     */
    void placeMarker(BoardPosition marker,char player);

    /**
     * @pre grid[pos.row][pos.col] == O || == X || == " "
     * @param pos BoardPosition object that stores the rowNum and ColNum of a marker
     * @return an X, O, or " " to show what is at that position
     * @post returnedChar = O || X || " "
     */
    char whatsAtPos(BoardPosition pos);

    /**
     * @pre rowSize >= minSize and rowSize <= maxSize
     * @return the number of rows the board has
     * @post GameBoard = #GameBoard
     */
    int getNumRows();

    /**
     * @pre colSize >= minSize and colSize <= maxSize
     * @return the number of columns the board has
     * @post GameBoard = #GameBoard
     */
    int getNumColumns();

    /**
     * @pre inARowNumToWin >= GameScreen.minWinNum and inARowNumToWin <= GameScreen.maxNumToWin
     * @return the number of symbols that must be in a row in order to win the game
     * @post GameBoard = #GameBoard
     */
    int getNumToWin();

    /**
     * @pre totalMoves >= numInARowToWin * 2
     * @param lastPos BoardPosition object that holds the rowNum and colNum of last marker
     * @param player the character that the player is using (X or O)
     * @return returns true if player has getWinNum in a row horizontally otherwise, returns false
     * @post GameBoard = #GameBoard
     */
    default boolean checkForHorizontalWin(BoardPosition lastPos,char player){
        int row = lastPos.getRow(),symbolCount = 0,size = 0,col = lastPos.getCol(),counter,spacesRem;
        BoardPosition Pos;
        col = col - (getNumToWin() - 1);
        counter = (getNumToWin() * 2) - 1;
        if(col < 0){
            col = 0;
            counter = getNumToWin();
        }
        spacesRem = counter;
        // while loop checks to see if wins diagonally going up. size is here so you don't go checking
        // starts from the top and then goes to the bottom. Only checks (numofwins * 2) - 1 for efficiency
        while(col <= (getNumRows() - 1) && size < counter){
            if(symbolCount + spacesRem < getNumToWin()){
                // if you need more spaces to win than there are available, you cannot win, so returns false
                // when this happens for efficiency.
                return false;
            }
            Pos = new BoardPosition(row,col);
            if (isPlayerAtPos(Pos,player)){
                symbolCount++;
            }
            else{
                symbolCount = 0; // resets symbolCount to zero if not equal to player
            }
            if (symbolCount == getNumToWin()){
                return true; // returns true if player character has winNumber in a row
            }
            col++;
            size++; // you only need to check numInARowToWin - 1 spaces to see if you win diagonally
            spacesRem--;
        }
        return false; // if while loop, breaks then there must be no winner
    }

    /**
     * @pre totalMoves >= numInARowToWin * 2
     * @param lastPos BoardPosition object that holds the rowNum and colNum of last marker
     * @param player the character that the player is using (X or O)
     * @return returns true if player has getWinNum in a row vertically otherwise, returns false
     * @post GameBoard = #GameBoard
     */
    default boolean checkVerticalWin(BoardPosition lastPos,char player) {
        int row = lastPos.getRow(),symbolCount = 0,size = 0,col = lastPos.getCol(),counter,spacesRem;
        BoardPosition Pos;
        row = row - (getNumToWin() - 1);
        counter = (getNumToWin() * 2) - 1;

        if(row < 0){
            row = 0; // prevents row from being negative
            counter = getNumToWin();
        }
        spacesRem = counter;
        // while loop checks to see if wins diagonally going up. size is here so you don't go checking
        // spaces that you don't have to. We only check (winNumber * 2) - 1 spaces for efficiency
        while(row <= (getNumRows() - 1) && size < counter){
            if(symbolCount + spacesRem < getNumToWin()){
                // if you need more spaces to win than there are available, you cannot win, so returns false
                // when this happens for efficiency.
                return false;
            }
            Pos = new BoardPosition(row,col);
            if (isPlayerAtPos(Pos,player)){
                symbolCount++;
            }
            else{
                symbolCount = 0; // resets symbol count if it does not equal to player
            }
            if (symbolCount == getNumToWin()){
                return true; // has the winNumber symbols in a row, so return true
            }
            row++;
            size++;
            spacesRem--;
        }
        return false; // while look is broken, so it must be false
    }

    /**
     * @pre totalMoves >= numInARowToWin * 2
     * @param lastPos BoardPosition object that holds the rowNum and colNum of last marker
     * @param player the character that the player is using (X or O)
     * @return returns true if player has getWinNum in a row diagonally otherwise, returns false
     * @post GameBoard = #GameBoard
     */
    default boolean checkDiagonalWin(BoardPosition lastPos,char player){
        int row = lastPos.getRow(),symbolCount = 0,size = 0,col = lastPos.getCol(),counter,spacesRem;
        BoardPosition Pos;
        row = row - (getNumToWin() - 1);
        col = col - (getNumToWin() - 1);
        counter = (getNumToWin() * 2) - 1;
        if(row < 0){
            row = 0;
        }
        if(col < 0){
            col = 0;
        }
        spacesRem = counter;
        // while loop checks to see if wins diagonally going up. size is here so you don't go checking
        // spaces that you don't have to. Is for efficiency
        while(col <= (getNumColumns() - 1 ) && row <= (getNumRows() - 1) && size < counter){
            if(symbolCount + spacesRem < getNumToWin()){
                return false;
            }
            Pos = new BoardPosition(row,col);
            if (isPlayerAtPos(Pos,player)){
                symbolCount++;
            }
            else{
                symbolCount = 0; // resets counter for number in a row
            }
            if (symbolCount == getNumToWin()){
                return true; // returns true if the number in a row is equal to NumToWin
            }
            row++;
            col++;
            size++; // you only need to check numInARowToWin - 1 spaces to see if you win diagonally
            spacesRem--;
        }
        return false; // while loop is broken, so it must be false.
    }

    /**
     * @pre totalMoves >= (numInARowToWin * 2) - 1
     * @return true if there are no more available spaces on grid, otherwise return false
     * @post GameBoard = #GameBoard
     */
    default boolean checkForDraw(){
        // if just one space is equal to a blank space, it must mean that the game is not a draw yet
        // call checkSpace for every space, and if it is true once, draw is false
        int i,j;

        for(i = 0; i < getNumRows(); i++){
            for(j = 0; j < getNumColumns(); j++){
                BoardPosition BP = new BoardPosition(i,j);
                if(checkSpace(BP)){
                    return false;
                }
            }
        }
        return true; // broke nested for loop, so draw must be true
    }

    /**
     * @pre totalMoves >= (numInARowToWin * 2) - 1
     * @param lastPos the last location where a marker was placed
     * @return true if player has 5 in a row/diagonally otherwise, false
     * @post GameBoard = #GameBoard
     */
    default boolean checkForWinner(BoardPosition lastPos){
        char player = whatsAtPos(lastPos);
        // checks for a diagonal win, a vertical win, and a horizontal win. If one of them is true, return true
        // otherwise, return false.
        if(checkDiagonalWin(lastPos,player) || checkVerticalWin(lastPos,player) || checkForHorizontalWin(lastPos,player)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @pre pos.row and pos.col >= 0 and pos.row and pos.col < maxSie and player == O || player == X
     * @param pos a BoardPosition Object that contains the row and column position of a space
     * @param player the symbol that a player is playing as. Can be an X or an O only
     * @return true if player is the character at that position, false if otherwise
     * @post GameBoard = #GameBoard
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player){
        // returns true or false if the space at pos is equal to player
        if(whatsAtPos(pos) == player){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @pre BoardPosition object must be constructed and have a valid location
     * @param pos is a BoardPosition object that represents a space on the grid
     * @return returns true if space is empty and false if the space is taken
     * @post GameBoard = #GameBoard
     */
    default boolean checkSpace(BoardPosition pos){
        // returns true if the space is equal to a whitespace character, false otherwise
        int row = pos.getRow();
        int col = pos.getCol();

        if(row <= (getNumRows() - 1) && col <= (getNumColumns() - 1) && row >= 0 && col >= 0){
            if(whatsAtPos(pos) == ' '){
                return true;
            }
        }
        return false;
    }
}
