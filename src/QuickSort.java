import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kjh on 16. 10. 3.
 */
public class QuickSort {

    public void QuickSort_Partition(ArrayList<Integer> arrList, int start, int pivot){
        if(start < pivot){
            int q = partition(arrList, start, pivot);
            QuickSort_Partition(arrList, start, q-1);
            QuickSort_Partition(arrList, q+1, pivot);
        }
    }

    public void QuickSort_Random_Partition(ArrayList<Integer> arrList, int start, int pivot){
        if(start < pivot){
            int q = partition(arrList, start, pivot);
            QuickSort_Random_Partition(arrList, start, q-1);
            QuickSort_Random_Partition(arrList, q+1, pivot);
        }
    }

    private int partition(ArrayList<Integer> arrList, int start, int pivot){
        int pos = arrList.get(pivot);
        int i = start-1;

        for(int j=start ; j<pivot ; j++){
            if(arrList.get(j) <= pos) {
                i++;
                swap(arrList, i, j);
            }
        }
        i++;
        swap(arrList, i, pivot);

        return i;
    }

    private int random_partition(ArrayList<Integer> arrList, int start, int pivot){
        int i = randomRange(start, pivot);
        swap(arrList, pivot, i);
        return partition(arrList, start, pivot);
    }

    private int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2-n1+1)) + n1;
    }


    private void swap(ArrayList<Integer> arrList, int i, int j) {
        int temp = arrList.get(i);
        arrList.set(i, arrList.get(j));
        arrList.set(j, temp);
    }

    public void print(ArrayList arrList){
        for(int i=0 ; i<arrList.size() ; i++)
            System.out.println(arrList.get(i));
    }
}
