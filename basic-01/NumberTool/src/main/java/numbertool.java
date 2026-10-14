import java.util.Scanner;

public class numbertool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,flag;
        flag=0;
        while (true) {
            printMenu();
            n=sc.nextInt();
            switch (n) {
                case 0:
                    flag=1;
                    System.out.println("已退出");
                    break;
                case 1:
                    System.out.println("请输入一个整数");
                    m=sc.nextInt();
                   if(isEven(m))
                       System.out.println("Even");
                   else
                       System.out.println("Odd");
                   break;
                case 2:
                    System.out.println("请输入一个整数");
                    m=sc.nextInt();
                    System.out.println(sum(m));
                    break;
                case 3:
                    System.out.println("请输入一个整数");
                    m=sc.nextInt();
                    if(is_leapyears(m))
                        System.out.println("Leap Years");
                    else
                        System.out.println("Not Leap Years");
                    break;
            }
            if(flag==1)
                break;
        }
    }
    //判断是否为偶数
    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        return false;
    }
    //求和
    public static int sum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    //判断是否为闰年
    public static boolean is_leapyears(int n) {
        if ((n%400==0) || (n%4==0 && n%100!=0)) {
            return true;
        }
        return false;
    }
    //打印菜单
    static void printMenu() {
        System.out.println("1. 判断奇偶");
        System.out.println("2. 计算 1 到 n 的和");
        System.out.println("3. 判断闰年");
        System.out.println("0. 退出");
        System.out.print("请选择：");
    }
}
