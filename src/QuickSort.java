import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kjh on 16. 10. 3.
 */
public class QuickSort {

    public void QuickSort_Partition(ArrayList<Integer> arrList, int start, int end){
        if(start < end){
            int q = partition(arrList, start, end);
            QuickSort_Partition(arrList, start, q-1);
            QuickSort_Partition(arrList, q+1, end);
        }
    }

    public void QuickSort_Random_Partition(ArrayList<Integer> arrList, int start, int end){
        if(start < end){
            int q = random_partition(arrList, start, end);
            QuickSort_Random_Partition(arrList, start, q-1);
            QuickSort_Random_Partition(arrList, q+1, end);
        }
    }

    private int partition(ArrayList<Integer> arrList, int start, int end){
        int pivot = arrList.get(end);
        int i = start-1;

        for(int j=start ; j<end ; j++){
            if(arrList.get(j) <= pivot) {
                i++;
                swap(arrList, i, j);
            }
        }
        i++;
        swap(arrList, i, end);

        return i;
    }

    private int random_partition(ArrayList<Integer> arrList, int start, int end){
        int[] random = new int[3];
        for(int i=0 ; i<3 ; i++)
            random[i] = randomRange(start, end);
        int pivot = middleFind(random[0], random[1], random[2]);
        swap(arrList, end, pivot);
        return partition(arrList, start, end);
    }

    private int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2-n1+1)) + n1;
    }

    private int middleFind(int n1, int n2, int n3){
        int middle;
        if(!(n1 < n2 ^ n2 < n3))
            middle = n2;
        else if(!(n2 < n1 ^ n1 < n3))
            middle = n1;
        else
            middle = n3;

        return middle;
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
