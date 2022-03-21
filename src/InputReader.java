import java.util.Scanner;
public class InputReader {
    public void start(Network ajiraNetwork){
        Scanner scanner=new Scanner(System.in);
        String s;
        String[] arr;
        while(true){
            s=scanner.nextLine();
            arr=s.split(" ");
            InputDecisionTaker.perform(arr,ajiraNetwork);
        }
    }
}
