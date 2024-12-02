package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Puzzle1 {
     public static void main(String[] args) throws FileNotFoundException{
        int count= 0;
        List<List<Integer>> rows = new ArrayList<>();


        File file = new File("puzInput.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // If the line is empty, break (optional, depends on how input ends)
            if (line.trim().isEmpty()) {
                break;
            }

            // Split the line into numbers and parse them
            String[] numbers = line.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String num : numbers) {
                row.add(Integer.parseInt(num));
            }
            rows.add(row);
        }

        for(List<Integer> list : rows){
            int size = list.size();
            if(size==1 || (size == 2 && list.get(0)!=list.get(1))){
                count++;
                continue;
            }
            boolean asc = true;
            boolean flag = true;

            if(list.get(0).equals(list.get(1)))continue;
            if(list.get(0)<list.get(1))asc= true;
            else asc = false;
            int i=0;
            while(i<size-1){
                if(asc){
                    if(list.get(i+1)<=list.get(i) || (list.get(i+1) - list.get(i))<1 || (list.get(i+1) - list.get(i))>3){
                        flag = false;
                        break;
                    }
                }
                else if(!asc){
                    if(list.get(i)<=list.get(i+1) || (list.get(i) - list.get(i+1))<1 || (list.get(i) - list.get(i+1))>3){
                        flag = false;
                        break;
                    }
                }
                i++;
            }
            if(flag)count++;
        }
        System.out.println(count);

     }
}
