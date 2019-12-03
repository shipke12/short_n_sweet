import java.math.BigInteger;

public class Skyward {

	/*Sarah,

As part of our application process, we would like you to take a programming skills assessment.  The purpose of this assessment is to 
determine your ability to solve a problem and to see your thought process.
 
Please take this assessment within one week of receiving this email.  The assessment is not timed, but should be completed within 
48 hours of starting it.
 
Use the link below to log in.  Once you're logged in, go to Gradebook and select the Take Assignment link.

https://pbroker1.skyward.com:483/scripts10/wsisa.dll/WService=11020web/seplog01.w
Login: HIPKESAR000
Password: 220175
 

***ATTENTION***: After you have completed the assessment, please respond to this email letting us know.  Additionally, to 
*streamline the process we request that you include a variety of dates and times that you would be available, should you be 
*selected for a first interview.  If selected, the interview process may take up to 2 hours at our Stevens Point office and we 
*would contact you via the FastTrack portal for scheduling. 

Thank you,

Application Development Department
Skyward, Inc*/
	
	
	
	
	//***********************************************************************************************************************************
/*If we list all numbers below 20 that are multiples of 4 or 6, we get: 4, 6, 8, 12, 16, 18. The sum of these numbers is 64 
(4+6+8+12+16+18).  
Note: If a number is a multiple of both 4 and 6 (ex: 12), only count it once in the sum (total).
 
Write a function which accepts an integer to calculate the multiples of 4 or 6 below the specified number and return the sum of 
those multiples.
Example:
Input: 20, Output: 64
 
Also, what is the total when 826,716 is passed in?
*/
/*	public static void main(String[] args) {
		System.out.println(multiples(826716));
	}
	
	public static long multiples(long input) {
		//sum is a counter, have to use long because with giant numbers, 
		//it gets too big for int
		long sum = 0;
		//for each number up to input,without including input
		for(long i = 0; i < input; i++) {
			//if the next number (i) is divisible by 4 AND 6, count once
			if(i%4==0 && i%6==0) {
				sum = sum + i;
				i++;
			//if next number (i) is divisible by (4 OR 6)AND(not 4 AND 6), count once
			}else if((i%4==0||i%6==0)&&(!(i%4==0 && i%6==0))) {
				sum = sum + i;
				i++;
			//if neither, move on
			} else {
				i++;
			}
		}
		return sum;
	}
	*/
	
	
	
	
	
//***********************************************************************************************************************************
/*Write a SQL query that lists the first and last name of each employee for the companies located in Florida 
 (State.Abbreviation is �FL�) and where either the employee is a Developer (Job.JobCode is �dev�) or their job code isn�t found 
 in the Job table.  Order this query by last name, then first name.
Company
�   CompanyID, int
�   Name, varchar(50)
�   StateID, int
�   StreetAddress, varchar(max)
Employee
�   EmployeeID, int
�   CompanyID, int
�   JobID, int
�   FirstName, varchar(30)
�   LastName, varchar(50)
�   PhoneNumber, char(12)
State
�   StateID, int
�   Name, varchar(30)
�   Abbreviation, char(2)
Job
�   JobID, int
�   JobCode, char(3)
�   JobDesc, varchar(60)*/
/*SELECT Employee.LastName, Employee.FirstName
FROM Company, Employee, State, Job
WHERE Company.CompanyID = Employee.CompanyID and Company.StateID = State.StateID
	and Job.JobID = Employee.JobID and State.Abbreviation='FL' and 
	Job.JobCode='dev'
UNION
SELECT Employee.LastName, Employee.FirstName
FROM Company, Employee, State, Job
WHERE Company.CompanyID = Employee.CompanyID and Company.StateID = State.StateID
	 and Job.JobID = Employee.JobID and State.Abbreviation='FL' and Job.JobCode=null;*/
	
	
	
	
	
	
	
	//******************************************************************************************************************************
	/*A palindromic number reads the same both ways (left-to-right and right-to-left).
	The largest palindrome made from the product of two 2-digit numbers is 9,009 = 91 � 99.
	The largest palindrome made from the product of two 3-digit numbers is 906,609 = 913 � 993.
	The largest palindrome made from the product of two 4-digit numbers is 99,000,099 = 9,901 � 9,999.
	 
	1. Write a function to find the largest palindrome made from the product of two 7-digit numbers.  
	2. What is that product?
	3. How long (execution time) does it take your solution to calculate this answer?*/
	
	
	
	//9999999 (7) x 9999999 (7) = 99999999999999 (14)
	//start with 9999999 as one number, check if any of the numbers in the first 100 numbers multiplied
	//by it.... check if index 0 and index 13 match, yes? check 1 and 12, yes? 2, 11? 3, 10? 4, 9? 5, 8?
	//6,7? then output
	
	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		System.out.println("Largest FullTime_Problems.Palindrome: " + palindrome(7));
		System.out.println("Runtime in milliseconds: " + (System.currentTimeMillis() - starttime));
	}
	
	public static BigInteger palindrome(int length) {
		BigInteger oneAsBig = new BigInteger("1");
		BigInteger zeroAsBig = new BigInteger("0");
		BigInteger tenAsBig = new BigInteger("10");
		BigInteger nineAsBig = new BigInteger("9");
		BigInteger largestP = zeroAsBig;
		BigInteger product = zeroAsBig;
		BigInteger upperbound = zeroAsBig;
		BigInteger lowerbound = zeroAsBig;
		int counter = 0;
		
		//to calculate the upperbound, its always going to need 9
		while(counter<length) {
			//upperbound = (upperbound*10) + 9;
			upperbound = upperbound.multiply(tenAsBig);
			upperbound = upperbound.add(nineAsBig);
			counter++;
		}
		
		//to calculate lower, use upper and add 1 to get to 10, 100, 1000 etc.
		//lowerbound = (upperbound/10) + 1;
		lowerbound = upperbound.divide(tenAsBig);
		lowerbound = lowerbound.add(oneAsBig);
		//don't want to check duplicates, very very inefficient
		for(BigInteger i = upperbound; i.compareTo(lowerbound)>=0; i=i.subtract(oneAsBig)) {
		//for(long i = upperbound; i<=lowerbound; i--){
			for(BigInteger j = i; j.compareTo(lowerbound) >=0; j=j.subtract(oneAsBig)) {
			//for(long j = i; j<=lowerbound; j--){
				product = i.multiply(j);
				//product = i*j;
				
				//if statement to skip flipping of palindrome
				//if the product is smaller than a palindrome we have already found don't
				//waste time flipping thats inefficient
				
				if(product.compareTo(largestP)<0) {
				//if(product<largestP){
					break;
				}
				//local variable set to product so we don't modify the product
				BigInteger number = product;
				BigInteger onesPlace = zeroAsBig;
				BigInteger reverse = zeroAsBig;
				//while condition to stop modding
				while(number.compareTo(zeroAsBig)!=0) {
				//while(number!=0){
					onesPlace = number.mod(tenAsBig);
					//onesPlace = number%10;
					reverse = reverse.multiply(tenAsBig);
					reverse = reverse.add(onesPlace);
					//reverse = reverse*10+onesPlace;
					number = number.divide(tenAsBig);
					//number = number/10;
				}
				//local variable to keep track of the flip of the number
				//math to get ones place of product
				//math to put the ones place of the product next in line in the flip of the number
				//if product == flip
				//set answer = product
				if(product.compareTo(reverse)==0) {
					largestP = product;
				}
			}
		}
		return largestP;
	}
	
	
	
	
	
}
