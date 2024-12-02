
package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Puzzle2 {
    public static int check(int a, int b, int c, int d, boolean asc){
        
        //when the pattern failes at a point, we can remove either of the 2 nodes involved.
        //we must check the neighbouring nodes, to decide which one to remove.

        boolean part1=false, part2=false;
        if(a==-1) part1= true;
        if(d==-1) part2= true;
        int d1=0,d2=0;
        if(asc){
            //remove b
            if(a!=-1)d1 = c-a;
            if(d!=-1)d2 = d-c;
            if((part1 || (d1>=1 && d1<=3)) && (part2 || (d2>=1 && d2<=3)))return 1;
            //remove c
            if(a!=-1)d1 = b-a;
            if(d!=-1)d2 = d-b;
            if((part1 || (d1>=1 && d1<=3)) && (part2 || (d2>=1 && d2<=3)))return 2;
        }
        else{
           //remove b
           if(a!=-1)d1 = a-c;
           if(d!=-1)d2 = c-d;
           if((part1 || (d1>=1 && d1<=3)) && (part2 || (d2>=1 && d2<=3)))return 1;
           //remove c
           if(a!=-1)d1 = a-b;
           if(d!=-1)d2 = b-d;
           if((part1 || (d1>=1 && d1<=3)) && (part2 || (d2>=1 && d2<=3)))return 2;
       }
       //if removing neither works, it would mean that the no of failures exceed 1, no matter what. Hence move to the next row.
       return 3;
    }

     public static void main(String[] args) throws FileNotFoundException{
        int count= 0;
        List<List<Integer>> rows = new ArrayList<>();


        File file = new File("puzInput.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                break;
            }

            String[] numbers = line.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String num : numbers) {
                row.add(Integer.parseInt(num));
            }


            rows.add(row);
        }
        


        for(List<Integer> list : rows){
            boolean asc = false;
            boolean desc = false;
            int size = list.size();
            int i=0;
            boolean flag1= false;

            boolean flag= true;

            int pos=0;
            int neg =0;
            int d1 = list.get(1)-list.get(0);
            int d2 = list.get(2)-list.get(1);
            int d3 = list.get(3)-list.get(2);
            if(d1>0)pos++;
            else if(d1<0)neg++;
            if(d2>0)pos++;
            else if(d2<0) neg++;
            if(d3>0)pos++;
            else if(d3<0)neg++;
            if(neg==pos){
                continue;
            }
            if(neg>pos)desc = true;
            else asc = true;
            
            while(i<size-1){
                if((asc && ((list.get(i+1) - list.get(i))<1 || (list.get(i+1) - list.get(i))>3)) || 
                            (desc && ((list.get(i) - list.get(i+1))<1 || (list.get(i) - list.get(i+1))>3))){
                    
                    //already failed once
                    if(flag1){
                        flag = false;
                        break;
                    }
                    //if not, check which node to remove
                    int a=-1, d=-1;
                    if(i-1>=0)a= list.get(i-1);
                    if(i+2<size)d= list.get(i+2);
                    boolean order = asc ? true : false;
                    int result = check(a, list.get(i).intValue(), list.get(i+1).intValue(), d, order);
                    if(result==1){
                        flag1= true;
                        i++;
                        continue;
                    }
                    if(result==2){
                        flag1= true;
                        i= i+2;
                        continue;
                    }
                    else{
                        flag = false;
                        break;
                    }                    

                }

                i++;
            }
            if(flag){
                count++;
            } 
        }
        System.out.println(count);

    }

}
