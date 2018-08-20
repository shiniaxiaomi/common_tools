package 算法.回溯算法;

public class 单词搜索 {
    public static void main(String[] args) {
		char[][] a = new char[][] {
			{'A','B','C','E'},
			{'S','F','E','S'},
			{'A','D','E','E'}
		};
		String word = "ABCESEEEFS";
		System.out.println(exist(a, word));
	}
	public static boolean exist(char[][] board, String word) {
        String str = "";
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					char[][] boardcopy = new char[board.length][board[0].length];
					arraycopy(board,boardcopy);
					if (digui(boardcopy,word,0,i,j,str)) {
						return true;
					}
				}
			}
		}
        
        return false;
    }

    //拷贝数组//
	private static void arraycopy(char[][] board, char[][] boardcopy) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boardcopy[i][j] = board[i][j];
			}
		}
		
	}
	private static boolean digui(char[][] board, String word, int n, int x, int y, String str) {
		if (str.equals(word)) {
			return true;
		}
		char[][] boardcopy = new char[board.length][board[0].length];
		arraycopy(board, boardcopy);
		//越界则返回
		if (x<0 || x > board.length-1 || y < 0 || y > board[0].length - 1) {
			return false;
		}
		
		if (boardcopy[x][y] != word.charAt(n)) {
			return false;
		}else {
			str += boardcopy[x][y];
			boardcopy[x][y] = '.';//因为不能重复之前的单词,所以进行替换掉,并传入到下一次递归中进行上下左右的检查
		}


		if (digui(boardcopy, word, n+1, x-1, y, str) ||//往上
				digui(boardcopy, word, n+1, x+1, y, str) ||//往下
				digui(boardcopy, word, n+1, x, y-1, str) ||//往左
				digui(boardcopy, word, n+1, x, y+1, str)) {//往右
			return true;
		}//判断上下左右是否存在
		return false;
	}
}
