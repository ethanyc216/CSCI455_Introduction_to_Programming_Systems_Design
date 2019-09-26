import java.util.*;

public class ReadTester {

    public static void main(String[] args) {
        while (true) {
            ArrayList<Integer> array = new ArrayList<>();
            String string = "";

            Scanner inputNum = new Scanner(System.in);
            System.out.print("Enter a space separated list of numbers: ");
            if (inputNum.hasNextLine()) {
                string = inputNum.nextLine();
            }

            Scanner numString = new Scanner(string).useDelimiter(" ");
            while (numString.hasNextInt()) {
                int num = numString.nextInt();
                array.add(num);
            }
            System.out.println("The numbers were: " + array);
        }
    }

}

