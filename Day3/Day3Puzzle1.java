package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day3Puzzle1 {


    public static String getNum(String str){
        String s="";
        int i=0;
        while(i<3){
            char c= str.charAt(i);
            if(c>='0' && c<='9')s+=c;
            else break;
            i++;
        }
        System.out.println("string is"+s);
        if(s.length()==0)return "-1";
        return s;
    }

    public static void main(String[] args){

        List<String> lines = List.of();

        try {
            Path filePath = Path.of("/Users/sahanapalem/Documents/puz1inp.txt"); 
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long total =0;


        for(String line : lines){
            int i=0;
            int n = line.length();
            
            while(true){
                i = line.indexOf("mul(", i);
                if(i==-1)break;
                System.out.println(i);
                i = i+3;
                String num1Str = getNum(line.substring(i+1));
                System.out.println("num1 is "+num1Str);
                if(num1Str=="-1")continue;

                i += num1Str.length();
                int num1= Integer.parseInt(num1Str);

                if( i+3<n && line.charAt(i+1)==','){
                    i++;
                    String num2Str = getNum(line.substring(i+1));
                    System.out.println("num2 is "+num2Str);
                    if(num2Str=="-1")continue;

                    i += num2Str.length();
                    int num2= Integer.parseInt(num2Str);

                    if(i+1<n && line.charAt(i+1)==')')total += num1*num2;
                }
                else continue;
                
            }
            System.out.println("pop");
        }

        System.out.println(total);
    }

}
