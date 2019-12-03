public class Lab2 {
    public static void main(String[] args) {

    //input a range of values to process

    //find any pairs of amicable numbers in that range

    //output those pairs in ascending order

    //continue until input is out of range

    //METHOD MUSTS:
    //isFactor
    //isAmicable
        int first= 1;
        int last = 40;
        for(int i=last; i>0; i--){
            for(int j=first; j<last; j++) {
                System.out.println(i + "this is i " + j + "this is j");
                //find pd of i
                //find pd of j
                //i=jpd
                //j=ipd
            }
        }


    }

    public static Boolean isFactor(int number, int testNumber) {
        return false;
    }

    public static Boolean isAmicable(int number, int testNumber) {
        return false;
    }

}