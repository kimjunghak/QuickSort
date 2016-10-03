import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by kjh on 16. 10. 3.
 */
public class TestRandomPartition {
    public static void main(String[] args) throws IOException{

        long startTime = System.currentTimeMillis();

        QuickSort qSort = new QuickSort();
        BufferedReader br = new BufferedReader(new FileReader("/home/kjh/Documents/git/QuickSort/src/data04.txt"));
        StringTokenizer token;
        ArrayList<Integer> arrList = new ArrayList();
        while(true){
            String line = br.readLine();
            if(line == null) break;
            token = new StringTokenizer(line, ",");
            while(token.hasMoreTokens())
                arrList.add(convertToInt(token));
        }

        qSort.QuickSort_Random_Partition(arrList, 0, arrList.size()-1);

        qSort.print(arrList);
        br.close();

        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println((endTime - startTime) + "ms");
    }

    private static int convertToInt(StringTokenizer token) {
        return Integer.parseInt(token.nextToken());
    }


}
