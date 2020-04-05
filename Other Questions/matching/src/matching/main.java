package matching;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		String[] arr = new String[n];
		List<Integer> adj[] = new ArrayList[n];
		List<Integer> adj1[] = new ArrayList[m];
		boolean[] acarr = new boolean[n];
		int numBad = 0;
		for(int i =0; i <n; i++) adj[i] = new ArrayList();
		for(int i =0; i <m; i++) adj1[i] = new ArrayList();
		for(int i =0; i <n; i++)
		{
			Boolean ac = true;
			arr[i] = br.readLine();
			for(int j =0; j <m; j++)
			{
				if(arr[i].charAt(j) == 'X')
				{
					ac = false;
					adj[i].add(j);
					adj1[j].add(i);
					
				}
			}
			acarr[i] = ac;
			if(!ac)
			{
				numBad++;
			}
		}
		int pro = 0;
		ArrayList<Integer> fi = new ArrayList<Integer>();
		while(pro<numBad) {
			int[] rank = new int[m];
			for(int i =0; i<m; i++)
			{
				rank[i]+=adj1[i].size();
			}
			int best = 0;
			for(int i =0; i<m;i++)
			{
				if(rank[i]>rank[best])
				{
					best = i;
				}
			}
			fi.add(best);
			pro+=rank[best];
			for(int i =0; i <adj1[best].size(); i++)
			{
				adj[adj1[best].get(i)].clear();
			}
			adj1[best].clear();
			
		}
		System.out.println(fi.size());
		for(int i =0; i < fi.size(); i++) System.out.print(fi.get(i)+1 + " ");
	}

}
