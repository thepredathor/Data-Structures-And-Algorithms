
package blind75.matrix;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j] && search(i, j, board, 0, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean search(int i, int j, char[][] board, int wordIndex, String word, boolean[][] visited) {
        if(wordIndex == word.length()) {
            return true;
        }
        if ((i < 0) || (i >= board.length) || (j < 0) || (j >= board[0].length) ||  word.charAt(wordIndex) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (search(i + 1, j, board, wordIndex + 1, word, visited) || search(i - 1, j, board, wordIndex + 1, word, visited) || search(i, j + 1, board, wordIndex + 1, word, visited) ||
                search(i, j - 1, board, wordIndex + 1, word, visited)) {
            return true;
        }

        visited[i][j] = false;

        return false;
    }
}
