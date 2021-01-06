import java.io.*;
import java.util.*;
public class main {
	static int N, M;
	static Node Root;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		Root = new Node(Integer.parseInt(str.nextToken()));
		for(int i =0; i <N-1; i++)
		{
			insert(Integer.parseInt(str.nextToken()));
		}
		int x = 0;
		str = new StringTokenizer(br.readLine());
		String s = str.nextToken();
		if(s.equals("I"))
		{
			insert(x^Integer.parseInt(str.nextToken()));
			x = 0;
		}
		else if(s.equals("R"))
		{
			delete(x^Integer.parseInt(str.nextToken()));
			x = 0;
		}
		else if(s.equals("S")) {
			x = -1*inOrder(Root, x^Integer.parseInt(str.nextToken()), 0);
			System.out.println(x);
		}
		else
		{
			x = -1*search(Root, x^Integer.parseInt(str.nextToken()), 0);
			x = x<1? -1:x;
			System.out.println(x);
		}
		//printAll(Root);
		for(int i = 0; i<M-1; i++)
		{
			str = new StringTokenizer(br.readLine());
			s = str.nextToken();
			if(s.equals("I"))
			{
				insert(x^Integer.parseInt(str.nextToken()));
				x = 0;
			}
			else if(s.equals("R"))
			{
				delete(x^Integer.parseInt(str.nextToken()));
				x = 0;
			}
			else if(s.equals("S")) {
				x = -1*inOrder(Root, x^Integer.parseInt(str.nextToken()), 0);
				System.out.println(x);
			}
			else
			{
				x = -1*search(Root, x^Integer.parseInt(str.nextToken()), 0);
				x = x<1? -1:x;
				System.out.println(x);
			}
			//printAll(Root);
		}
	}
	
	static class Node{
		Node left, right;
		int key;
		public Node(int key)
		{
			this.key = key;
			left = null;
			right = null;
		}
	}
	
	static void insert(int key) {
		Root = insertRec(Root, key);
	}
	
	static Node insertRec(Node root, int key) {
		
		if(root==null)
		{
			root = new Node(key);
			return root;
		}
		
		if(key<root.key)root.left = insertRec(root.left, key);
		else if(key>root.key)root.right = insertRec(root.right, key);
		return root;
		
	}
	static void delete(int key)
	{
		Root = deleteRec(Root, key);
	}
	static Node deleteRec(Node root, int key)
	{
		if(root==null)return root;
		if(key<root.key) {
	
			root.left = deleteRec(root.left, key);
		}
		else if(key>root.key) {
			
			root.right = deleteRec(root.right, key);
		}
		else
		{
			if(root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			Node succP = root;
			Node succ = root.right;
			while(succ.left!=null)
			{
				succP = succ;
				succ = succ.left;
			}
			System.out.println(key + " " + succ.key + " " + succP.key);
			if(succP!=root)
			{
				succP.left = succ.right;
			}
			else
			{
				succP.right = succ.right;
			}
			root.key = succ.key;
			
		}
		return root;
	}
	
	static int inOrder(Node root, int goal, int cnt)
	{
		if(root!=null) {
			cnt = inOrder(root.left, goal, cnt);
			if(cnt>-1) {
				cnt++;
				if(cnt==goal) return -1*(root.key);
				cnt = inOrder(root.right, goal, cnt);
			}
		}
		return cnt;
	}
	
	static int search(Node root, int key, int cnt) {
		if(root!=null) {
			cnt = inOrder(root.left, key, cnt);
			if(cnt>-1) {
				cnt++;
				if(root.key==key) return -1*cnt;
				cnt = inOrder(root.right, key, cnt);
			}
		}
		return cnt;
	}
	
	static void printAll(Node root)
	{
		if(root!=null)
		{
			printAll(root.left);
			System.out.println(root.key);
			printAll(root.right);
		}
	}
	
	
}