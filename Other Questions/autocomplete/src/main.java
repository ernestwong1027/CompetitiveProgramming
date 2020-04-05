import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine());
		for(int i = 0; i <n; i++)
		{
			int N = Integer.parseInt(br.readLine()), trie[][] = new int[1000001][26];
			int rt = 0, cnt = 0, ans = 0;
			for(int j = 1; j<=N; j++)
			{
				String s = br.readLine(); rt = 0; int prefix = 0; boolean flag = false;
				for(int k = 0; k<s.length(); k++)
				{
					if(!flag) prefix++;
					if(trie[rt][s.charAt(k)-'a'] == 0)
					{
						trie[rt][s.charAt(k)-'a'] = ++cnt;
						flag = true;
					}
					rt = trie[rt][s.charAt(k)-'a'];
				}
				ans += prefix;
			}
			System.out.printf("Case #%d: %d\n",  i+1, ans);
		}
		
	}
}