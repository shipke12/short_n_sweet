class MyCode2 {
	public static void main (String[] args) {
		System.out.println("expected: 4200 actual: " + travel(500, 60, 45, 14));
    System.out.println("expected: 840 actual: " + travel(60, 60, 45, 14));
    System.out.println("expected: 840 actual: " + travel(105, 60, 45, 14));
    System.out.println("expected: 910 actual: " + travel(110, 60, 45, 14));
  }
  public static int travel(int totalTime, int runTime, int restTime, int speed){
    int total = 0;
    int totalMeters = 0;
    int math = 0;
    while(total<totalTime){
      if(total+60>totalTime){
        math = totalTime-total;
        math = (math*speed);
        totalMeters = math+totalMeters;
        break;
      }
      total = runTime+total;
      totalMeters = (runTime*speed)+totalMeters;
      if(total<totalTime){
      total = restTime+total;
      }
    }
    return totalMeters;
  }
}