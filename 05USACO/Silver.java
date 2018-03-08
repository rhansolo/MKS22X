import java.io.*;
import java.util.*;

public class Silver {
    static char[][] grass; 
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader( new FileReader("input.txt"));
	StringTokenizer st = new StringTokenizer(br.readline());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int t = Integer.parseInt(st.nextToken());
	for (int i = 0; i < n; i++){
	    StringTokenizer st1 = new StringTokenizer(br.readLine());
	    for (int j = 0; j < n; j++){
		grass[i][j] = st1.charAt(j);
	    }
	}
	
    }
}
