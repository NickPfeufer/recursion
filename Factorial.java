class Factorial{
	
	public static void main(String[] args) {
		System.out.println(factIt(5));
		System.out.println(factRect(5));
		System.out.println(fibonacci(5));
	}

	public static int factIt(int n){
		int answer = n;
		for (int i = n - 1; i>=2; i--) {
			answer *= i;
		}
		return answer;
	}

	public static int factRect(int n) {
    	if(n == 1){
    		return 1;
    	}


		return n * factRect(n-1);
	}

    public static int fibonacci(int n){
    	if (n <= 1) {
    		return 1;
    	}

    	return fibonacci(n-1) + fibonacci(n-2);
    }


}