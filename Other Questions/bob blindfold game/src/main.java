import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(str.nextToken());
		int c = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		BitSet t = new BitSet(r*c);
		BitSet w = new BitSet(r*c);
		BitSet e = new BitSet(r*c);
		for(int i = 0; i <r; i++)
		{
			String s = br.readLine();
			for(int j = 0; j<c; j++) {
				if(s.charAt(j)=='.') t.set((i)*c+j);
				if((j^0)>0) e.set((i)*c+j);
				if((j^(c-1))>0) w.set((i)*c+j);
				
			}
		}
		BitSet f = t;
		String op = br.readLine();
		for(int i =0; i<m; i++)
		{
			char a = op.charAt(i);
			if(a=='N') {
				f=f.get(c, f.length());
				f.and(t);
			}
			if(a=='N') {
				f=f.get(0, f.length()-c);
				f.and(t);
			}
			if(a=='N') {
				f=f.get(c, f.length());
				f.and(t);
			}
			if(a=='N') {
				f=f.get(c, f.length());
				f.and(t);
			}
			if(a=='?') f=((f>>c)|(f<<c)|((f<<1)&e)|((f>>1)&w))&t;
		}
	
	}

}
