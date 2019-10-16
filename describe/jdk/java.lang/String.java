


int hashCode()步骤：
char[] val;
int h;
for(int i=0;i<val.length;i++){
	h = 31 * h + val[i];
}
return h;
哈希计算公式：S[0]*31^n-1 + S[1]*31^n-2 + ... + S[n-1]*31^0




