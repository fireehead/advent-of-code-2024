package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4Puzzle2 {
    
    public static void main(String[] args){
        List<String> matrix = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("puzzleInput.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                matrix.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        

        int m = matrix.size();
        int n = matrix.get(0).length();
        int count = 0;

        for(int j=1;j<m-1;j++){
            for(int i=1;i<n-1;i++){
                if(matrix.get(j).charAt(i)=='A'){
                    if(((matrix.get(j-1).charAt(i+1)=='M' && matrix.get(j+1).charAt(i-1)=='S') ||
                    (matrix.get(j-1).charAt(i+1)=='S' && matrix.get(j+1).charAt(i-1)=='M')) &&
                    ((matrix.get(j-1).charAt(i-1)=='M' && matrix.get(j+1).charAt(i+1)=='S') ||
                    (matrix.get(j-1).charAt(i-1)=='S' && matrix.get(j+1).charAt(i+1)=='M')))count++;
                }
            }
        }

        System.out.println(count);
        
    }

}
