package wk2.bj3954;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class failed {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			int T = Integer.parseInt(br.readLine());
			for(int tc = 0; tc < T; tc++) {
				String[] tmpinp = br.readLine().split(" ");
				int memsz = Integer.parseInt(tmpinp[0]); // memory size = mem*sizeof(int)
				int[] mem = new int[memsz]; // total memory.
				int ptr = 0; // current pointer

				int psz = Integer.parseInt(tmpinp[1]); // program length
				String prog = br.readLine(); // program code
				int progptr = 0; // program pointer
				Stack<Integer> brackettmp = new Stack<>();
				HashMap<Integer, Integer> bpairs = new HashMap<>();
				for(int i = 0; i < psz; i++) {
					if(prog.charAt(i)=='[') brackettmp.push(i);
					else if(prog.charAt(i)==']') {
						int ob = brackettmp.pop();
						int cb = i;
						bpairs.put(ob,cb);
						bpairs.put(cb,ob);
					}
				}
				brackettmp.clear();
				brackettmp = null;
				int answer = Integer.MAX_VALUE;
				int inpsz = Integer.parseInt(tmpinp[2]); // length of input
				String inp = br.readLine(); // input string
				int iptr = 0; // input cycle
				int cycle = 0; // total cycle
				
				Stack<Integer> openb = new Stack<>(); // addresses of open bracket
//				Stack<Integer> closeb = new Stack<>(); // addresses of closed bracket								
				boolean infloop = false;
				while(true) {
					if (cycle == 50000000+50000000) {
//						infloop = true;
						break;
					}
					if (progptr == psz) break;
					
					switch (prog.charAt(progptr)) {
					case '+':
						mem[ptr] = (mem[ptr]+1)%256;
						progptr++;
						break;
					case '-':
						mem[ptr] = (mem[ptr]-1) == -1 ? 255 : mem[ptr]-1;
						progptr++;
						break;
					case '<':
						ptr = (ptr-1)==-1 ? memsz-1 : ptr-1;
						progptr++;
						break;
					case '>':
						ptr = (ptr+1)==memsz? 1 : ptr+1;
						progptr++;
						break;
					case '[':
						if(openb.size() ==0 || openb.peek() != progptr) {
							openb.add(progptr);
//							closeb.add(Math.abs(bpairs.get(progptr)));
						}
						if(mem[ptr] == 0) {
							int x = openb.peek();
							int y = bpairs.get(x);
							//jump to close bracket
							//pop both stack.
							if(y > 0) bpairs.replace(x, -Math.abs(y));
							openb.pop();
							progptr = Math.abs(y) + 1;
						}
						else {
							progptr++;
						}
						break;
					case ']':
//						if(closeb.size() == 0 || closeb.peek() != progptr) closeb.add(progptr);
						if(mem[ptr] != 0) {
							//jump to previous open bracket
							progptr = openb.peek()+1;
						}
						else {
							int x = openb.peek();
							int y = bpairs.get(x);
							//pop both stack
							if(y > 0) bpairs.replace(x, -Math.abs(y));
							openb.pop();
							progptr++;
						}
						break;
					case '.': // do nothing
						progptr++;
						break;
					case ',':
						if(iptr == inpsz) mem[ptr] = 255; 
						else mem[ptr] = (int) inp.charAt(iptr++);
						progptr++;
						break;
					}
					cycle++;
					if(cycle >= 50000000) {
						answer = Math.min(answer, progptr-1);
						infloop = true;
					}
				}
				while (true) {
					if(openb.size() == 0 || bpairs.get(openb.peek()) > 0) {
						break;
					}
					openb.pop();
				}
				if(infloop == true) {
					int x = openb.pop();
					int y = bpairs.get(x);
					answer = Math.min(answer, x);
					System.out.println("Loops "+answer+" "+Math.abs(bpairs.get(answer)));
				}
				else System.out.println("Terminates");
				openb.clear();
				bpairs.clear();
				mem = null;
			}
		} catch (IOException e) {}
	}
}


/*
Input :
2
65359 16 3
+[>+],...[[-],+]
999
65359 16 3
+[>+],[[-],+]+[]
999

Answer :
Terminates
Loops 14 15

Input:
1
3 209 1
+[>+[>----------------------------------[+++]<+]++++++++++++++++++++++++++[+]<+],[-].+[-[[>+[>----------------------------------[+++]<+]++++++++++++++++++++++++++[+]<+]----------------------------------[+]]++]
1

Output
Loops 86 208

Input:
2
3 124 1
+[-[[>+[>----------------------------------[+++]<+]++++++++++++++++++++++++++[+]<+]----------------------------------[+]]++]
.
1 8 1
+[-[]++]
.

Output
Loops 1 123 ☆☆☆
Loops 3 4

===== 입력 =====
2
10 5 1
+[[]]
a
1 9 1
++[[++]+]
a

===== 출력 =====
Loops 2 3
Loops 3 6

input:
1
10 9 3
+[-[><]-]
qwe

output:
Loops 3 6

input:
1
1000 10 1
+[,[+-]-].
a

output:
Loops 3 6
 */
