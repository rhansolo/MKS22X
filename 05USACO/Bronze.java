import java.io.*;
import java.util.*;

public class Bronze {
	static int[][] lake;
	public static void main(String[] args) throws IOException{
		int r,c,e,n,rs,cs,ds;
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
	        
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		lake = new int[r+1][c+1];
		for (int i = 1; i <= r; i++){
		    
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= c; j++){
				lake[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		for (int i = 0; i < n; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			rs = Integer.parseInt(st2.nextToken());
			cs = Integer.parseInt(st2.nextToken());
			ds = Integer.parseInt(st2.nextToken());
			stomp(rs,cs,ds);
		}
		int depth = 0;
		for (int i = 1; i <= r; i++){
			for (int j = 1; j <= c; j++){
				if (lake[i][j] <= e)
					depth += e-lake[i][j];
			}
		}
		pw.println(depth*72*72);
		pw.close();
	}
	
	public static void stomp (int row, int col, int depth) {
	    int highestCow;
	    for (int i = 0; i < depth; i++) {
	        highestCow = lake[row][col];
	        for (int j = 0; j < 3; j++)
	            for (int k = 0; k < 3; k++)
	                if (lake[row+i][col+j] > highest){ 
	                	highestCow=lake[j+ row][k + col];
			}
	        for (i = 0; i < 3; i++)
	            for (j = 0; j < 3; j++)
	                if (lake[row+i][col+j] == highest){ 
	                	lake[row+i][col+j]--;
			}
	    }
	} 

}
