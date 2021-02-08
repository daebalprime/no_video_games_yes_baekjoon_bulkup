package wk2.bj3954;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class revised {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			int T = Integer.parseInt(br.readLine());
			for(int tc = 0; tc < T; tc++) {
				String[] tmpInput = br.readLine().split(" ");
				int memsz = Integer.parseInt(tmpInput[0]);
				int progsz = Integer.parseInt(tmpInput[1]);
				int inpsz = Integer.parseInt(tmpInput[2]);
				
				String prog = br.readLine(); // code 
				String inp = br.readLine(); // str of prog input
				int[] mem = new int[memsz]; // actual mem array
				
				int cycle = 0;
				
				int mptr = 0; // memory pointer
				int iptr = 0; // input pointer
				int pptr = 0; // program pointer
				
				boolean infloop = false;
				
				int lastBracket = -1;
				
				HashMap<Integer, Integer> loops = new HashMap<>();
				
				Stack<Integer> openBracket = new Stack<>();
				Stack<Integer> closeBracket = new Stack<>();
				
				for(int i = 0; i < progsz; i++) {
					int a = 0;
					if(prog.charAt(i) == '[') openBracket.push(i);
					else if(prog.charAt(i) == ']') {
						a = openBracket.pop();
						loops.put(a, i);
						loops.put(i, a);
					}
				}
				openBracket.clear();
				
				while(true) {
					if (cycle == 50000000) {
						infloop = true;
						break;
					}
					if (pptr >= progsz && cycle <=50000000) {
						infloop = false;
						break;
					}
//					System.out.println(progsz+" "+pptr);
					switch (prog.charAt(pptr)) {
					case '+':
						mem[mptr] = (mem[mptr]+1)%256;
						pptr++;
						break;
					case '-':
						mem[mptr] = (mem[mptr]-1) == -1 ? 255 : mem[mptr]-1;
						pptr++;
						break;
					case '<':
						mptr = (mptr-1)==-1 ? memsz-1 : mptr-1;
						pptr++;
						break;
					case '>':
						mptr = (mptr+1)==memsz? 0 : mptr+1;
						pptr++;
						break;
					case '[':
						if(openBracket.size() == 0 || 
							(openBracket.peek() != pptr)){
							openBracket.push(pptr); 
						}
						if(mem[mptr] == 0) {
							pptr = loops.get(openBracket.pop())+1;
//							pptr = loops.get(pptr)+1;
						}
						else pptr++;
	
					case ']':
						if(mem[mptr] != 0) {
							pptr = openBracket.peek()+1;
						}
						else {
							pptr++;							
						}
					case '.': // do nothing
						pptr++;
						break;
					case ',':
						if(iptr == inpsz) mem[mptr] = 255; 
						else mem[mptr] = (int) inp.charAt(iptr++);
						pptr++;
						break;
					}
					if(cycle > 50000000) lastBracket = Math.max(pptr,lastBracket);
					cycle++;
				}
				// cases
				// terminate -> terminate
				// not terminated -> 50000000 cycle more
				// terminated ? xx : get inf loop.
				// 1. max pptr 
					
				if(infloop == true) {
//					System.out.println("Loops "+ loops.get(lastBracket)+" " +lastBracket);
					int answer =  openBracket.pop();
					System.out.println("Loops " + answer + " " + loops.get(answer) );
				}
				else System.out.println("Terminates");
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
