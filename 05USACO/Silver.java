import java.io.*;
import java.util.*;

public class Silver {
    static char[][] grass; 
    static int[][][] dp;
    static int[] xChange = new int[] {1,-1,0,0};
    static int[] yChange = new int[] {0,0,1,-1};
    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader( new FileReader("input.txt"));
	StringTokenizer st = new StringTokenizer(br.readline());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int t = Integer.parseInt(st.nextToken());
	for (int i = 0; i < n; i++){
	    String st1 = br.readLine();
	    for (int j = 0; j < n; j++){
		grass[i][j] = st1.charAt(j);
	    }
	}
	StringTokenizer st2 = new StringTokenizer(br.readLine());
	int r1 = Integer.parseInt(st2.nextToken());
	int c1 = Integer.parseInt(st2.nextToken());
	int r2 = Integer.parseInt(st2.nextToken());
	int c2 = Integer.parseInt(st2.nextToken());
	r1--;
	c1--;
	r2--;
	c2--;
	dp = new int[m][n][t];
	for (int i = 0; i < m; i++){
	    for (int j = 0; j < m; j++){
		dp[i][j][0] = 0;
	    }
	}
	dp[r1][c1][0]= 1;
	for (int i = 1; i <= t; i++){
	    for (int j = 0; j < m; j++){
		for (int k = 0; k < n; k++){
		    for (int l = 0; l < 4; l++){
			if ( j + xChange[l] >= 0 && j + xChange[l] < m &&
			     k + yChange[l] >= 0 && k + yChange[l] < m){
			    if (grass[j+xChange[l]][k+yChange[l]] != '.'){
				dp[j][k][i] += grass[j+xChange[l]][k+yChange[l]];
			    }
			}
		    }
		}
	    }
	}
	System.out.println(dp[r1][c1][t]);
	
    }
}
