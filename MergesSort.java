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
        ArrayList<Integer> b = randomArrayList(100000);
        System.out.println("100000 Long random unsorted list");
        System.out.println("");
        watch.start();
        mergeSort(b);
        watch.stop();
        System.out.println("Merge sorted in : " + watch.time());
        int[] a = new int[b.size()];
        for (int i = 0; i<a.length; i++) {
            a[i] = b.get(i);
        }
        watch.start();
        selcectionSort(a);
        watch.stop();
        System.out.println("Selection sorted in : " + watch.time());
    }
    public static int[] selcectionSort(int[] arr){
        int storage;
        int min;
        for (int i = 0; i<arr.length; i++) {
            storage = arr[i];
            min = i;
            for (int k = i; k<arr.length; k++) {
                if(arr[k] < storage){
                    storage = arr[k];
                    min = k;
                }
            }
            arr[min] = arr[i];
            arr[i] = storage;           
        }
        return arr;
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
             a.add(r.nextInt(900));
         }
         return a;
    }



}