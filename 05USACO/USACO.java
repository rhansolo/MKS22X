import java.io.*;
import java.util.*;

public class USACO{
    public static  int bronze(String filename){
	int[][] lake;
	int depth = 0;
	try{
	    BufferedReader br = new BufferedReader(new FileReader(filename));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int r = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    int e = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    lake = new int[r+1][c+1];
	    for (int i = 1; i <= r; i++){
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int j = 1; j <= c; j++){
		    lake[i][j] = Integer.parseInt(st1.nextToken());
		}
	    }
	    for (int i = 0; i < n; i++){
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st2.nextToken());
		int col = Integer.parseInt(st2.nextToken());
		int tmpDepth = Integer.parseInt(st2.nextToken());
	        int highestCow;
		for (int q = 0; q < tmpDepth; q++) {
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
	    for (int i = 1; i <= r; i++){
		for (int j = 1; j <= c; j++){
		    if (lake[i][j] <= e){
			depth += e-lake[i][j];
		    }
		}
	    }
	}
	catch(IOException  e){
	    System.out.println("no found file! :(");
	}
	return (depth*72*72);
    }
    

    public static int silver(String filename){
        char[][] grass; 
        int[][][] dp;
	int ans = 0;
        int[] xChange = new int[] {1,-1,0,0};
	int[] yChange = new int[] {0,0,1,-1};
	int r1,r2,c1,c2,t;
	try{
	    BufferedReader br = new BufferedReader(new FileReader(filename));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int m = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    t = Integer.parseInt(st.nextToken());
	    grass = new char[m+1][n+1];
	    for (int i = 0; i < m; i++){
		String st1 = br.readLine();
		// System.out.println(st1);
		for (int j = 0; j < n; j++){
		    grass[i][j] = st1.charAt(j);
		}
	    }
	    StringTokenizer st2 = new StringTokenizer(br.readLine());
	    r1 = Integer.parseInt(st2.nextToken());
	    c1 = Integer.parseInt(st2.nextToken());
	    r2 = Integer.parseInt(st2.nextToken());
	    c2 = Integer.parseInt(st2.nextToken());
	    r1--;
	    c1--;
	    r2--;
	    c2--;
	    dp = new int[m][n][t+1];
	    for (int i = 0; i < m; i++){
		for (int j = 0; j < n; j++){
		    dp[i][j][0] = 0;
		}
	    }
	    dp[r1][c1][0]= 1;
	    for (int i = 1; i <= t; i++){
		for (int j = 0; j < m; j++){
		    for (int k = 0; k < n; k++){
			for (int l = 0; l < 4; l++){
			    if ( j + xChange[l] >= 0 && j + xChange[l] < m &&
				 k + yChange[l] >= 0 && k + yChange[l] < n){
				if (grass[j+xChange[l]][k+yChange[l]] != '*'){
				    dp[j][k][i] += dp[j+xChange[l]][k+yChange[l]][i-1];
				}
				
			    }
			}
			
		    }
		}
	    }
	    ans = dp[r2][c2][t];
	}
	catch(IOException  e){
	    System.out.println("no found file! :(");
	}
	return ans;
        
	
    }

}
