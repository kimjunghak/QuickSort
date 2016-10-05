import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by kjh on 16. 10. 3.
 */
public class Test {
    public static void main(String[] args) throws IOException{

        QuickSort qSort = new QuickSort();

        ArrayList<Integer> arrList = new ArrayList();
        ArrayList<Integer> random_arrList;

        BufferedReader br = new BufferedReader(new FileReader("/home/kjh/Documents/git/QuickSort/src/data04.txt"));
        StringTokenizer token;
        while(true){
            String line = br.readLine();
            if(line == null) break;
            token = new StringTokenizer(line, ",");
            while(token.hasMoreTokens())
                arrList.add(convertToInt(token));
        }


        random_arrList = (ArrayList<Integer>) arrList.clone();

        long startTime = System.currentTimeMillis();
        qSort.QuickSort_Partition(arrList, 0, arrList.size() - 1);
        long endTime = System.currentTimeMillis();

        System.out.printf("Normal QuickSort : %2d ms   ", (endTime - startTime));
        System.out.println();


        long random_startTime = System.currentTimeMillis();
        qSort.QuickSort_Random_Partition(random_arrList, 0, random_arrList.size() - 1);
        long random_endTime = System.currentTimeMillis();

        System.out.println();
        System.out.printf("Random QuickSort : %2d ms   ", (random_endTime - random_startTime));
        System.out.println();


        FileOutputStream output_quickSort = new FileOutputStream("/home/kjh/Documents/git/QuickSort/src/output_QuickSort.txt");
        output_List(arrList, output_quickSort);

        FileOutputStream output_random = new FileOutputStream("/home/kjh/Documents/git/QuickSort/src/output_QuickSort_random.txt");
        output_List(random_arrList, output_random);

        br.close();
        output_random.close();

    }

    private static void output_List(ArrayList arrayList, FileOutputStream output_quickSort) throws IOException {
        for (int i = 0; i < arrayList.size(); i++) {
            String data = arrayList.get(i).toString() + "\r\n";
            output_quickSort.write(data.getBytes());
        }

    }

    private static int convertToInt(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }


}
