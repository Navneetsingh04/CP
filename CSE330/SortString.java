public class SortString {
    public static String solve(String s){
        int n = s.length();
        int[] charCount = new int[26];
        for(int i = 0;i<n;i++){
            charCount[s.charAt(i) -'a']++;
        }
        
        StringBuilder sortedStr = new StringBuilder();
        for(int i = 0;i<26;i++){
            for(int j = 0;j<charCount[i];j++){
                System.out.print((char)('a' + i));
            }
        }
        return sortedStr.toString();
    }
    public static String sort(String s){
        return solve(s);
    }
    public static void main(String[] args) {
        String s = "navneetsingh";
        System.out.println(sort(s));
    }
}
