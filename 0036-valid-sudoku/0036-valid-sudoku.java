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
}