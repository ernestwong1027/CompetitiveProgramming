

import java.util.*;

class Query{ 
	int L; 
	int R; 
	Query(int L, int R){
		this.L = L;
		this.R = R;
	}
} 

class MO{

	
	static void queryResults(int a[], int n, ArrayList<Query> q, int m){
		
		int block = (int) Math.sqrt(n); 
	.
		Collections.sort(q, new Comparator<Query>(){
		
			public int compare(Query x, Query y){ 

				// Different blocks, sort by block. 
				if (x.L/block != y.L/block) 
					return (x.L < y.L ? -1 : 1); 

				// Same block, sort by R value 
				return (x.R < y.R ? -1 : 1);
			}
		});

		// Initialize current L, current R and current sum 
		int currL = 0, currR = 0; 
		int currSum = 0; 
	
		// Traverse through all queries 
		for (int i=0; i<m; i++) 
		{ 
			// L and R values of current range
			int L = q.get(i).L, R = q.get(i).R; 

			// Remove extra elements of previous range. For 
			// example if previous range is [0, 3] and current 
			// range is [2, 5], then a[0] and a[1] are subtracted 
			while (currL < L) 
			{ 
				currSum -= a[currL]; 
				currL++; 
			} 

			// Add Elements of current Range 
			while (currL > L) 
			{ 
				currSum += a[currL-1]; 
				currL--; 
			} 
			while (currR <= R) 
			{ 
				currSum += a[currR]; 
				currR++; 
			} 

			// Remove elements of previous range. For example 
			// when previous range is [0, 10] and current range 
			// is [3, 8], then a[9] and a[10] are subtracted 
			while (currR > R+1) 
			{ 
				currSum -= a[currR-1]; 
				currR--; 
			} 

			// Print sum of current range 
			System.out.println("Sum of [" + L +
						", " + R + "] is " + currSum); 
		} 
	}

	// Driver program 
	public static void main(String argv[]){
		ArrayList<Query> q = new ArrayList<Query>();
		q.add(new Query(0,4));
		q.add(new Query(1,3));
		q.add(new Query(2,4));

		int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8}; 
		queryResults(a, a.length, q, q.size()); 
	}
}

