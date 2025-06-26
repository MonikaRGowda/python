public class nqueen
{
	static int n=4;
	static void display(int[][] board)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j]==1)
					System.out.print("Q ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}
	static boolean issafe(int row,int col,int[][] board)
	{
		int i,j;
		for(i=0;i<n;i++)
			if(board[row][i]==1)
				return false;
		for(i=row,j=col;i>=0&&j>=0;i--,j--)
			if(board[i][j]==1)
				return false;
		for(i=row,j=col;i<n&&j>=0;i++,j--)
			if(board[i][j]==1)
				return false;
		return true;
	}
	static boolean nqutil(int[][] board,int col)
	{
		if(col>=n)
			return true;
		for(int i=0;i<n;i++)
		{
			if(issafe(i,col,board))
			{
				board[i][col]=1;
				if(nqutil(board,col+1))
					return true;
				board[i][col]=0;
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		int board[][]= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(nqutil(board,0))
			display(board);
		else
			System.out.println("No solution");
	}
}