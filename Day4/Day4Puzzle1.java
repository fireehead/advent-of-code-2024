package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4Puzzle1 {
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
        int j=0;

        for(String row : matrix){
            for(int i=0;i<n;i++){
                //check right
                if(i<n-3 && row.substring(i, i+4).equals("XMAS"))count++;

                //check left XMAS
                if(i>2 && row.substring(i-3, i+1).equals("SAMX"))count++;

                //check top
                if(j>2 && matrix.get(j).charAt(i)=='X' && matrix.get(j-1).charAt(i)=='M' && matrix.get(j-2).charAt(i)=='A' && matrix.get(j-3).charAt(i)=='S')count++;

                //check bottom
                if(j<m-3 && matrix.get(j).charAt(i)=='X' && matrix.get(j+1).charAt(i)=='M' && matrix.get(j+2).charAt(i)=='A' && matrix.get(j+3).charAt(i)=='S')count++;

                //check NE
                if(j>2 && i<n-3 && matrix.get(j).charAt(i)=='X' && matrix.get(j-1).charAt(i+1)=='M' && matrix.get(j-2).charAt(i+2)=='A' && matrix.get(j-3).charAt(i+3)=='S')count++;

                //check NW
                if(j>2 && i>2 && matrix.get(j).charAt(i)=='X' && matrix.get(j-1).charAt(i-1)=='M' && matrix.get(j-2).charAt(i-2)=='A' && matrix.get(j-3).charAt(i-3)=='S')count++;

                //check SW
                if(j<m-3 && i>2 && matrix.get(j).charAt(i)=='X' && matrix.get(j+1).charAt(i-1)=='M' && matrix.get(j+2).charAt(i-2)=='A' && matrix.get(j+3).charAt(i-3)=='S')count++;

                //check SE
                if(j<m-3 && i<n-3 && matrix.get(j).charAt(i)=='X' && matrix.get(j+1).charAt(i+1)=='M' && matrix.get(j+2).charAt(i+2)=='A' && matrix.get(j+3).charAt(i+3)=='S')count++;
            }
            j++;
        }
        System.out.println(count);    
    }
}
