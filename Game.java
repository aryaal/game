import java.util.Scanner;
import java.util.concurrent.*;

public class Game {

    	public static void main(String[] args) 
	{
	Scanner sc = new Scanner(System.in);
        System.out.println("1.Hidden Game\n2.JumbleGame\n3.Exit");
        System.out.println("Enter the choice: ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:HiddenGame();
                   break;
            case 2:JumbleGame();
                   break;
	    case 3:break;
           default: System.out.println("Enter valid choice: ");
                    break;
        }
    }

    public static void HiddenGame() 
    {
	Scanner sc = new Scanner(System.in);
        String[] a = { "SOFTWARE", "COMPUTER", "PROGRAMMER", "HARDWARE", "ORACLE","PYTHON" };
        int count = 0;
        for (int i = 0; i <a.length; i++)
        {
            int j = ThreadLocalRandom.current().nextInt(a.length);
            String original = a[j];
            String org = shuffle(original);
            System.out.println(org);
            System.out.println("Enter answer: ");
            String ans = sc.next();
            if (original.equalsIgnoreCase(ans)) {
                System.out.println("Correct!\n");
                count++;
            } else {
                System.out.println("Wrong!\n");
            }
	    j++;
        }
        System.out.println("Your score: " + count);
    }

    private static String shuffle(String original) {
        int i = original.length();
        char[] origin = original.toCharArray();
        int j = ThreadLocalRandom.current().nextInt(i);
        int k = ThreadLocalRandom.current().nextInt(i);
        int l = ThreadLocalRandom.current().nextInt(i);
        origin[j] = '*';
        origin[k] = '*';
        origin[l] = '*';
        return new String(origin);
    }

    public static void JumbleGame() 
    {
	Scanner sc = new Scanner(System.in);
        int count = 0;
        String[] a = {"SOFTWARE", "JAVA", "PROGRAMMER", "HARDWARE", "CPU","PYTHON" };
        for(int m = 0;m<a.length;m++)
        {
            int i = ThreadLocalRandom.current().nextInt(a.length);
            String original = a[i];
            String org = shuffleLetters(original);
            System.out.println(org);
            System.out.println("Enter your answer: ");
            String ans = sc.next();
            if (original.equalsIgnoreCase(ans)) 
	    {
                System.out.println("Correct!");
                count = count++;
            } 
	    else
                System.out.println("Wrong!");
        }
	System.out.println("total score: "+count);
    }

    private static String shuffleLetters(String original)
    {
            char[] origi = null;
            for (int k = 0; k < 10; k++) 
	    {
            int j = ThreadLocalRandom.current().nextInt(original.length());
            int l = ThreadLocalRandom.current().nextInt(original.length());
            origi = original.toCharArray();
            char temp = origi[j];
            origi[j] = origi[l];
            origi[l] = temp;
             }
             return new String(origi);
    }

}