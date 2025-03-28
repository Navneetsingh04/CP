public class test1 {
    public static void func(int n){
        if(n>2){
            func(n-1);
            func(n-2);
            func(n-3);
        }
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        int n = 5;
        func(n);
    }
}
