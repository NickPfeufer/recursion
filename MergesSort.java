import java.util.ArrayList;
import java.util.Random;

class MergesSort {
	
	public static ArrayList<Integer> split(ArrayList<Integer> a){
        Integer half = a.size()/2;
        ArrayList<Integer> b = new ArrayList<Integer>();
		for (Integer i = 0; i<half; i++) {
			b.add(a.get(a.size()-1));
			a.remove(a.size()-1);
		}
		return b;
	}

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
    	ArrayList<Integer> merged = new ArrayList<Integer>();
    	while(a.size() > 0 || b.size() > 0){
    		if (a.size() == 0) {
    			for (Integer ged : b) {
    				merged.add(ged);
    			}
    			b.clear();
    		}else if(b.size() == 0){
    			for (Integer ged : a) {
    				merged.add(ged);
    			}
    			a.clear();    			
    		}else if (a.get(0) < b.get(0)) {
    			merged.add(a.get(0));
    			a.remove(0);
    		}else{
    			merged.add(b.get(0));
    			b.remove(0);
    		}

    	}
    	return merged;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a){
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i : a) {
            b.add(i);
        }
        return mergeSortList(b);
    }
    public static ArrayList<Integer> mergeSortList(ArrayList<Integer> a){
        if (a.size() == 1) {
            return a;
        }
        ArrayList<Integer> b = split(a);
        return merge(mergeSortList(a), mergeSortList(b));        
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = randomArrayList(1000);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);
        a.add(3);
        a.add(4);
        System.out.println("Short unsorted list:");
        prIntegerList(a);
        System.out.println();
        System.out.println("Sorted: ");
        watch.start();
        prIntegerList(mergeSort(a));
        watch.stop();
        System.out.println("Sorted in : " + watch.time());
        System.out.println();
        System.out.println("Long random unsorted list:");
        prIntegerList(b);
        System.out.println();
        System.out.println("Sorted");
        watch.start();
        ArrayList<Integer> d = mergeSort(b);
        watch.stop();
        prIntegerList(d);
        System.out.println("Sorted in : " + watch.time());
    }
    public static void prIntegerList(ArrayList<Integer> a){
        for (Integer i : a) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> randomArrayList(int lim){
         Random r = new Random();
         ArrayList<Integer> a = new ArrayList<Integer>();
         for (int i = 0; i<lim; i++) {
             a.add(r.nextInt(90));
         }
         return a;
    }



}