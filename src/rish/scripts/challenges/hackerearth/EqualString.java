package rish.scripts.challenges.hackerearth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Contest link: https://www.hackerearth.com/challenges/competitive/june-circuits-23/problems/
 * Problem link: https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/equal-strings-79789662-4dbd707c/
 * 
 * @Author: Rishabh Soni
 * Date attempted: 20th June 2023
 * 
 */
public class EqualString {

    public static int canManipulate(String a, String b, int length, int cost) {

        char[] refArray = a.toCharArray();
        char[] diffArray = b.toCharArray();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (refArray[i] != diffArray[i]) {
                indexes.add(i);
            }
        }

        if (indexes.size() % 2 != 0) {
            return -1;
        }

        int totalCost = 0;
        for (int i = 0; i < indexes.size(); i = i + 2) {
            int indexDiff = indexes.get(i + 1) - indexes.get(i);
            totalCost += indexDiff < cost ? indexDiff : cost;
        }

        return totalCost;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        /*
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
         * testCaseCount = Integer.parseInt(br.readLine());
         * 
         * while (testCaseCount > 0) {
         * 
         * String sizes = br.readLine(); String[] strs = sizes.trim().split(" "); int
         * length = Integer.parseInt(strs[0]); int cost = Integer.parseInt(strs[1]);
         * 
         * String nextLine = br.readLine(); String[] inputStrings =
         * nextLine.trim().split(" ");
         * 
         * System.out.println(canManipulate(inputStrings[0], inputStrings[1], length,
         * cost));
         * 
         * testCaseCount--; }
         */

        System.out.println(canManipulate("1010", "0001", 4, 3));
        System.out.println(canManipulate("101011", "010010", 6, 2));
        System.out.println(canManipulate("001111011011", "010101101111", 12, 2));
    }

}
