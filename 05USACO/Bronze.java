import java.io.*;
import java.util.*;

public class Bronze {
	static int[][] lake;
	public static void main(String[] args) throws IOException{
		int r,c,e,n,rs,cs,ds;
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
		System.out.println(depth*72*72);
	}
	
	public static void stomp (int row, int col, int depth) {
	    int highestCow;
	    for (int i = 0; i < depth; i++) {
	        highestCow = lake[row][col];
	        for (int j = 0; j < 3; j++){
	            for (int k = 0; k < 3; k++){
	                if (lake[row+j][col+k] > highestCow){ 
	                	highestCow=lake[j+ row][k + col];
			}
		    }
		}
	        for (int a = 0; a < 3; a++){
	            for (int b = 0; b < 3; b++){
	                if (lake[row+a][col+b] == highestCow){ 
	                	lake[row+a][col+b]--;
			}
		    }
		}
	    }
	} 

}
