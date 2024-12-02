import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day1Puzzle{
    public static void main(String args[])throws FileNotFoundException{

        File file = new File("puzzle_input.txt");
        Scanner scanner = new Scanner(file);
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2  = new ArrayList<>();
        while(scanner.hasNextLine() && scanner.hasNext()){
            list1.add(Integer.parseInt(scanner.next()));
            list2.add(Integer.parseInt(scanner.next()));
        }

        scanner.close();

        Collections.sort(list1);
        Collections.sort(list2);
        int n= list1.size();
        int totalDistance=0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(list2.get(i)))map.put(list2.get(i), map.get(list2.get(i))+1);
            else map.put(list2.get(i), 1);
            totalDistance += Math.abs(list2.get(i) - list1.get(i));
        }
        System.out.println("Total distance is "+ totalDistance);  // solution for first problem
        int similarityScore =0;
        for(int i=0;i<n;i++){
            int score = map.containsKey(list1.get(i)) ? map.get(list1.get(i)) : 0;
            similarityScore += list1.get(i) * score;
        }
        System.out.println("Similarity score is "+ similarityScore);  // solution for second problem
    }
}
