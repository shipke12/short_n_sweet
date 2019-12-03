public class Palindrome {

    private static long largestPalindromeinSet;

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        largestPalindrome();
        System.out.println("The largest palindrome is: " +largestPalindromeinSet );
        millis = System.currentTimeMillis()-millis;
        System.out.println("time in milliseconds: " + millis);
    }

    private static void largestPalindrome() {
        long tempAnswer;

        //only need to check the 7 digit possibilities,
        //and don't repeat calculations with j being i
        for (Long i = 9999999L; i >= 1000000L; i--) {
            for (Long j = i; j >= 1000000; j--) {
                tempAnswer = i * j;

                //no point in checking if its smaller
                if(tempAnswer<largestPalindromeinSet) {
                    break;
                }
                flipCompare(tempAnswer);
            }
        }
    }

    private static void flipCompare(long number) {

        long placeHolderForMath = number;
        long switchedNumber = 0;

        //now reverse it
        //while it isn't shifted down to 0
        while(placeHolderForMath>0) {

            //get the onesplace from placeholder for comparing
            long onesPlaceRemainder = placeHolderForMath%10;

            //1st time will just set the one's place (which right now is farthest left side)
            //After that, whatever is in the one's place gets bumped up to the ten's/hundred's/etc.
            //remainders keep going into one's place of switchedNumber
            switchedNumber = (switchedNumber*10) + onesPlaceRemainder;

            //since we shift switchedNumber left, we have to switch placeHolder to the right
            placeHolderForMath/=10;
        }

        //check if same
        if((number==switchedNumber) && number > largestPalindromeinSet) {
            largestPalindromeinSet = number;
        }
    }



}