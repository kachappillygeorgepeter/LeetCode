/*                                    BRUTE FORCE
1. Check columns, rows
2. Check boxes

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> data=new HashSet<>();

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++)
                if(board[i][j]!='.')
                    if(!data.add(board[i][j]))
                    return false;
            data.clear();
            for(int j=0; j<9; j++)
                if(board[j][i]!='.')
                    if(!data.add(board[j][i]))
                    return false;
            data.clear();
        }

        for (int boxRow=0; boxRow<9; boxRow+=3) {
            for (int boxCol=0; boxCol<9; boxCol+=3) {
                data.clear();
                for (int i=boxRow; i<boxRow+3; i++) {
                    for (int j=boxCol; j<boxCol+3; j++) {
                        if (board[i][j] != '.')
                            if (!data.add(board[i][j]))
                                return false;
                    }
                }
            }
        }
        
        return true;
    }
}*/
/*                              OPTIMAL SOLUTION
1. Create three 2D boolean arrays to track digits in each row, column and 3×3 box.
2. Traverse the board and skip empty cells represented by '.'.
3. Convert each digit into an index using `board[i][j] - '1'` and calculate its box index using `(i/3)*3 + (j/3)`.
4. If the digit already exists in its row, column or box, return false. Otherwise, mark it as seen. If no duplicates are found, return true.*/

class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows=new boolean[9][9];
        boolean[][] cols=new boolean[9][9];
        boolean[][] boxes=new boolean[9][9];

        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++) {

                if(board[i][j]=='.')
                    continue;

                int num=board[i][j]-'1';
                int box=(i/3)*3+(j/3);

                if(rows[i][num] || cols[j][num] || boxes[box][num])
                    return false;

                rows[i][num]=true;
                cols[j][num]=true;
                boxes[box][num]=true;
            }

        return true;
    }
}