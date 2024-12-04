package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day3Puzzle2 {
    public static String getNum(String str) {
        String s = "";
        int i = 0;
        while (i < str.length() && i < 3) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') s += c;
            else break;
            i++;
        }
        if (s.length() == 0) return "-1";
        return s;
    }

    public static void main(String[] args) {
        List<String> lines = List.of();

        try {
            Path filePath = Path.of("/Users/sahanapalem/Documents/puz1inp.txt");
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long total = 0;
        boolean flag = true;

        for (String line : lines) {
            int i = 0;
            int n = line.length();

            while (true) {
                int p = line.indexOf("do()", i);
                int q = line.indexOf("don't()", i);
                int m = line.indexOf("mul(", i);

                if (p == -1) p = Integer.MAX_VALUE;
                if (q == -1) q = Integer.MAX_VALUE;
                if (m == -1) break;

                if (p < m && p < q) {
                    flag = true;
                    i = p + 4;
                    continue;
                } else if (q < m && q < p) {
                    flag = false;
                    i = q + 7;
                    continue;
                }

                if (flag && m < p && m < q) {
                    i = m + 4;
                    String num1Str = getNum(line.substring(i));
                    if (num1Str.equals("-1")) continue;

                    i += num1Str.length();
                    int num1 = Integer.parseInt(num1Str);

                    if (i < n && line.charAt(i) == ',') {
                        i++;
                        String num2Str = getNum(line.substring(i));
                        if (num2Str.equals("-1")) continue;

                        i += num2Str.length();
                        int num2 = Integer.parseInt(num2Str);

                        if (i < n && line.charAt(i) == ')') {
                            total += num1 * num2;
                        }
                    }
                } else {
                    i = m + 4;
                }
            }
        }

        System.out.println(total);
    }
}
