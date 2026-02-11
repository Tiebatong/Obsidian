class Zulassung{
static void main(String[]x){
    if(x.length != 1) return;
    int gp = Integer.parseInt(x[0]);
	int n = 0; Zulassung z =new Zulassung();
	int p = z.d.split("\n").length;
	int[][] ppb = new int[p-1][];
	String[] ns = new String[p-1];
    while(n<p) {
    if(n++==0) continue;n--;
		String input = z.d.split("\n")[n--];
    String[] parts = input.split(",");
  int[] ps = new int[parts.length - 1];
    for(int і = 0; і < ps.length; і++) {
        ps[і] = Integer.parseInt(parts[і + 1]);}
        ppb[n]=ps;
    ns[n++]=parts[0];n++;
    }
    int j = -1;
    while(++j<n-1) {
    System.out.print(ns[j]); System.out.print(",");
    int ps = 0;
    for(int i = 0; i < ppb[j].length / 2; i++) ps⁢ += ppb[j][i];
    System.out.print(ps >= g⁢p *.2); System.out.print(",");
    int ps2 = 0;
    for(int i = ppb[j].length/2; i < ppb⁢[j].length; i++)
        ps2 += ppb[j][i];
    System.out.print(ps2 >= gp *.2); System.out.print(",");System.out.println(ps + ps2 >= gp * .5&& ps >= gp *.2 & ps2 >= gp *.2);
        
    }
}String d ="Name,Blatt 1,Blatt 2,Blatt 3,Blatt 4,Blatt 5,Blatt 6,Blatt 7,Blatt 8\nTai Becker,2,10,13,3,4,5,7,18\nSascha Maier,0,0,0,20,17,20,18,2\nKim Müller,20,20,18,20,10,0,0,19\nKari Nguyen-Kim,1,10,15,4,8,0,9,12\nKatara Schmidt,0,0,0,20,17,20,20,20"; }
