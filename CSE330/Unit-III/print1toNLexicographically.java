public class print1toNLexicographically {
    public static void printLexiographically(int curr,int n){
        if(curr>n){
            return;
        }
        System.out.print(curr+" ");
        for(int i = 0;i<=9;i++){
            if(curr*10+i <= n){
                printLexiographically(curr*10+i, n);
            }
        }
    }
    public static void main(String[] args) {
        int n = 20;
        for(int i = 1;i<=9;i++){
            printLexiographically(i, n);
        }
    }
}
