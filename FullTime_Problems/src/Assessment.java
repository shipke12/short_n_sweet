import java.util.ArrayList;
import java.util.List;

public class Assessment {

//  public static void main(String[] args) {
//    System.out.println(multiplesOfFourAndSix(20));
//    System.out.println(multiplesOfFourAndSix(500));
//    System.out.println(multiplesOfFourAndSix(826716));
//  }

    public static long multiplesOfFourAndSix(int highestNumber) {
        //for each possible multiple, add to running total
        long runningTotal = 0;
        List<Long> numbersUsed = new ArrayList<Long>();
        for(long i = 4; i<highestNumber; i++) {
            if(i%4 == 0 || i%6 == 0) {
                runningTotal += i;
                numbersUsed.add(i);
            }
        }
        return runningTotal;
    }
}