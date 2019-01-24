class MyCode1 {
	public static void main (String[] args) {
		System.out.println(noBoringZeros(1450));
    System.out.println(noBoringZeros(960000)); 
    System.out.println(noBoringZeros(1050)); 
    System.out.println(noBoringZeros(-1050)); 
    System.out.println(noBoringZeros(0));
	}
  public static int noBoringZeros(int n){
    while(n%10 == 0){
      if(n == 0){
        return n;
      }
      if(n%10 == 0){
        n = n/10;
    }
  }
    return n;
  }
}