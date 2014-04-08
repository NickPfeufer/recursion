class StopWatch {
    double startTime; 
	double stopTime; 
	public StopWatch(){
        stopTime = 0;
	}
    public void start(){
    	startTime = System.currentTimeMillis();
    	stopTime = 0;
    }
    public void stop(){
        stopTime = System.currentTimeMillis();
    }
    // time retuns the run time, -1 if the watch was not started or stoped.
    public double time(){
   		if (stopTime == 0) {
   			return -1;
   		}
   		return stopTime - startTime;
    }
    // can be run from main
    public static void main(String[] args) {
    	StopWatch watch = new StopWatch();
    	watch.start();
    	//
    	// your program here
    	// 
    	watch.stop();
    	System.out.println("Program ran for " + watch.time() + "miliseconds");
    }

}