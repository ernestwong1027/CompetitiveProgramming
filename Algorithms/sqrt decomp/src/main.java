// Java program to demonstrate working of 
// Square Root Decomposition. 
import java.util.*; 

class GFG 
{ 

static int MAXN = 10000; 
static int SQRSIZE = 100; 

static int []arr = new int[MAXN];			 // original array 
static int []block = new int[SQRSIZE];		 // decomposed array 
static int blk_sz;							 // block size 

// Time Complexity : O(1) 
static void update(int idx, int val) 
{ 
	int blockNumber = idx / blk_sz; 
	block[blockNumber] += val - arr[idx]; 
	arr[idx] = val; 
} 

// Time Complexity : O(sqrt(n)) 
static int query(int l, int r) 
{ 
	int sum = 0;
	int c_l = l / SQRSIZE,   c_r = r / SQRSIZE;
	if (c_l == c_r)
	    for (int i=l; i<=r; ++i)
	        sum += arr[i];
	else {
	    for (int i=l, end=(c_l+1)*SQRSIZE-1; i<=end; ++i)
	        sum += arr[i];
	    for (int i=c_l+1; i<=c_r-1; ++i)
	        sum += block[i];
	    for (int i=c_r*SQRSIZE; i<=r; ++i)
	        sum += arr[i];
	}
	return sum;
} 

// Fills values in input[] 
static void preprocess(int input[], int n) 
{ 
	// initiating block pointer 
	int blk_idx = -1; 

	// calculating size of block 
	blk_sz = (int) Math.sqrt(n); 

	// building the decomposed array 
	for (int i = 0; i < n; i++) 
	{ 
		arr[i] = input[i]; 
		if (i % blk_sz == 0) 
		{ 
			// entering next block 
			// incementing block pointer 
			blk_idx++; 
		} 
		block[blk_idx] += arr[i]; 
	} 
} 

// Driver code 
public static void main(String[] args) 
{ 
	
	// We have used separate array for input because 
	// the purpose of this code is to explain SQRT 
	// decomposition in competitive programming where 
	// we have multiple inputs. 
	int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10}; 
	int n = input.length; 

	preprocess(input, n); 

	System.out.println("query(3, 8) : " + 
						query(3, 8)); 
	System.out.println("query(1, 6) : " + 
						query(1, 6)); 
	update(8, 0); 
	System.out.println("query(8, 8) : " + 
						query(8, 8)); 
} 
} 
