package cpsc2150.extendedTicTacToe;


import java.util.Scanner;

public class GameScreen{
    /**
     * @invariant colNum >= 0 and colNum < maxSize
     * @invariant rowNum >= 0 and colNum < maxSize
     */
    private int colNum;
    private int rowNum;
    private int maxWinNum;
    private int minWinNum;

    /**
     * @pre checkForWinner(player) == true
     * @param player is the symbol the the player. will be an X or a O
     * @post System.out.print(victoryScreen)
     */
    public void victoryScreen(char player){
        System.out.println("Player " + player + " wins!");
    }

    /**
     * @post scanner(System.out),colNum(0),rowNum(0),noWinner(true),playingGame(true)
     */
    GameScreen(){
        colNum = 0;
        rowNum = 0;
        maxWinNum = 25;
        minWinNum = 3;
    }

    /**
     * @pre APlayerHasWon == true
     * @return true or false depending on if the player wants to play the game again
     */
    public boolean playAgain(Scanner scanner){
        // finds out if the user wants to play again
        char answer;

        System.out.println("Would you like to play again? Y/N");
        answer = scanner.next().charAt(0);

        if(answer != 'y' && answer != 'n'){
            System.out.println("input must be a lowercase y or n");
            System.out.println("Would you like to play again? Y/N");
            answer = scanner.next().charAt(0);
        }

        if(answer == 'y'){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @pre APlayerhasWon == false, and PlayerXTurn == true, numberEntered >= 0 and < maxSize, scanner(System.out)
     * @param scanner Scanner object that takes in input (int)
     * @return an int between 1 and 7 inclusive corresponding to the row to put a marker
     * @post intReturned >= 0 and intReturned < maxSize
     */
    public int askColX(Scanner scanner){
        System.out.println("Player X Please enter your COLUMN");
        colNum = scanner.nextInt();

        return colNum;

    }
    /**
     * @pre APlayerhasWon == false, and PlayerXTurn == true, numberEntered >= 0 and <= 7, scanner(System.out)
     * @param scanner Scanner object that takes in input (int)
     * @return an int between 0 and maxSize - 1 inclusive corresponding to the row to put a marker
     * @post intReturned >= 0 and intReturned < maxSize
     */
    public int askCOlO(Scanner scanner){
        System.out.println("Player O Please enter your COLUMN");
        colNum = scanner.nextInt();

        return colNum;
    }
    /**
     * @pre APlayerhasWon == false, and PlayerXTurn == true, numberEntered >= 0 and <= 7, scanner(System.out)
     * @param scanner Scanner object that takes in input (int)
     * @return an int between 0 and maxSize - 1 inclusive corresponding to the row to put a marker
     * @post intReturned >= 0 and intReturned < maxSize
     */
    public int askRowX(Scanner scanner){
        System.out.println("Player X Please enter your ROW");
        rowNum = scanner.nextInt();

        return rowNum;
    }
    /**
     * @pre APlayerhasWon == false, and PlayerXTurn == true, numberEntered >= 0 and <= 7, scanner(System.out)
     * @param scanner Scanner object that takes in input (int)
     * @return an int between 0 and maxSize - 1 inclusive corresponding to the row to put a marker
     * @post intReturned >= 0 and intReturned < maxsize
     */
    public int askRowO(Scanner scanner){
        System.out.println("Player O Please enter your ROW");
        rowNum = scanner.nextInt();

        return rowNum;
    }
    /**
     * @pre isDraw == true
     * @post System.out.print(drawScreen)
     */
    public void drawScreen(){
        System.out.println("Match ended in a tie!");
    }

    /**
     * @pre scanner = scanner(System.out)
     * @param scanner = Scanner object initialized to take input from terminal
     * @return an int equal to the number of rows the board is going to have
     * @post rows <= maxSize and rows >= minSize
     */
    public int askRowSize(Scanner scanner){
        int rowNum;
        System.out.println("How many rows?");
        rowNum = scanner.nextInt();

        while(rowNum > IGameBoard.maxSize || rowNum < IGameBoard.minSize){
            System.out.println("Rows must be between " + IGameBoard.minSize + " and " + IGameBoard.maxSize);
            rowNum = scanner.nextInt();
        }
        return rowNum;
    }
    /**
     * @pre scanner = scanner(System.out)
     * @param scanner = Scanner object initialized to take input from terminal
     * @return an int equal to the number of columns the board is going to have
     * @post cols <= maxSize and cols >= minSize
     */
    public int askColSize(Scanner scanner){
        int colNum;
        System.out.println("How many columns?");
        colNum = scanner.nextInt();

        while(colNum > IGameBoard.maxSize || colNum < IGameBoard.minSize){
            System.out.println("Columns must be between " + IGameBoard.minSize + " and " + IGameBoard.maxSize);
            colNum = scanner.nextInt();
        }
        return colNum;
    }

    /**
     * @pre scanner(System.out),rowNum and colNum >= minSize && rowNum and colNum <= maxSize
     * @param scanner Scanner object initialized to take input from the terminal
     * @param rowNum the number of rows the board has
     * @param colNum the number of columns the board has
     * @return the number of symbols that must be in a row in order to win the game
     * @post wiNum >= minWinNum and winNum <= maxWinNum
     */
    public int askWinNum(Scanner scanner,int rowNum,int colNum){
        int winNum;
        System.out.println("How many in a row to win?");
        winNum = scanner.nextInt();

        while(winNum > maxWinNum || winNum < minWinNum ){
            System.out.println("Number in a row to win must be between " + minWinNum + " and " + maxWinNum);
            winNum = scanner.nextInt();
        }
        return winNum;
    }

    public static void main(String[] args){
        /**
         * @invariant colNum < maxSize and colNum >= 0
         * @invraint rowNum < maxSize and rowNum >= 0
         * @invariant player == 'X || player == 'O'
         * @invariant endAction == Winner || endAction == tie || nothing
         * @invariant scanner(System.in)
         * @invariant GS->GameScreen
         * @invariant gameBoard->GameBoard
         * @invariant minMovesToWin = (getNumToWin * 2) - 1
         * @invariant moves >= 0 and moves <= rowSize * colSize
         * @invariant inARowNum >= minWinNum and <= maxWinNum
         * @invariant rowSize >= minSize and rowSize <= maxSize
         * @invariant colSize >= minSize and colSize <= maxSize
         */
        boolean noWinner = true;
        boolean playingGame = true;
        int rowNum,colNum,rowsize,colSize,inARowNum,moves = 0,minMovesToWin;
        char player = 'X';
        String endAction = "nothing";
        Scanner scanner = new Scanner(System.in);
        GameScreen GS = new GameScreen();
        rowsize = GS.askRowSize(scanner);
        colSize = GS.askColSize(scanner);
        inARowNum = GS.askWinNum(scanner,rowsize,colSize);
        GameBoard gameBoard = new GameBoard(rowsize,colSize,inARowNum);
        minMovesToWin = (gameBoard.getNumToWin() * 2) - 1;

        while(playingGame){
            while (noWinner){
                player = 'X';
                System.out.println(gameBoard);
                rowNum = GS.askRowX(scanner);
                colNum = GS.askColX(scanner);
                BoardPosition lastPosX = new BoardPosition(rowNum,colNum);
                while(!gameBoard.checkSpace(lastPosX)){
                    System.out.println(gameBoard);
                    System.out.println("That space is unavailable,please pick again");
                    rowNum = GS.askRowX(scanner);
                    colNum = GS.askColX(scanner);
                    lastPosX = new BoardPosition(rowNum,colNum);
                }
                gameBoard.placeMarker(lastPosX,player);
                moves++;
                if(moves >= minMovesToWin) {
                    if (gameBoard.checkForWinner(lastPosX)) {
                        endAction = "Winner";
                        break;
                    } else if (gameBoard.checkForDraw()) {
                        endAction = "tie";
                        break;
                    }
                }
                player = 'O';
                System.out.println(gameBoard);
                rowNum = GS.askRowO(scanner);
                colNum = GS.askCOlO(scanner);
                BoardPosition lastPosO = new BoardPosition(rowNum,colNum);
                while(!gameBoard.checkSpace(lastPosO)){
                    System.out.println(gameBoard);
                    System.out.println("That space is unavailable, please pick again");
                    rowNum = GS.askRowO(scanner);
                    colNum = GS.askCOlO(scanner);
                    lastPosO = new BoardPosition(rowNum,colNum);
                }
                gameBoard.placeMarker(lastPosO,player);
                moves++;
                if(moves >= minMovesToWin) {
                    if (gameBoard.checkForWinner(lastPosO)) {
                        endAction = "Winner";
                        break;
                    } else if (gameBoard.checkForDraw()) {
                        endAction = "tie";
                        break; // breaks while loop
                    }
                }
            }
            if(endAction.equals("Winner")){
                GS.victoryScreen(player);
                System.out.println(gameBoard);
                playingGame = GS.playAgain(scanner);
                if(playingGame) {
                    rowsize = GS.askRowSize(scanner);
                    colSize = GS.askColSize(scanner);
                    inARowNum = GS.askWinNum(scanner,rowsize,colSize);
                    gameBoard = new GameBoard(rowsize,colSize,inARowNum);
                }
            }
            else{
                System.out.println(gameBoard);
                GS.drawScreen();
                playingGame = GS.playAgain(scanner);
                if(playingGame){
                    rowsize = GS.askRowSize(scanner);
                    colSize = GS.askColSize(scanner);
                    inARowNum = GS.askWinNum(scanner,rowsize,colSize);
                    gameBoard = new GameBoard(rowsize,colSize,inARowNum);
                }
            }
        }
    }
}



