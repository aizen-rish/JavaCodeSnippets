package rish.scripts.challenges.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *
 * Contest link: https://www.hackerearth.com/challenges/competitive/june-circuits-23/problems/
 * Problem link: https://www.hackerearth.com/problem/algorithm/2-swap-49fcc417/
 * 
 * Date attempted: 19th June 2023
 * 
 * @author Rishabh Soni
 *
 */
public class TwoSwap {

    public static boolean isSwappable(String t, String s) {

        if (t.equals(s)) {
            return true;
        }

        int size = t.length();

        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();

        List<Character> evenCharsForFirst = new ArrayList<>();
        List<Character> oddCharsForFirst = new ArrayList<>();
        List<Character> evenCharsForSecond = new ArrayList<>();
        List<Character> oddCharsForSecond = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            if (i % 2 == 0) {
                evenCharsForFirst.add(tChars[i]);
                evenCharsForSecond.add(sChars[i]);
                continue;
            }

            oddCharsForFirst.add(tChars[i]);
            oddCharsForSecond.add(sChars[i]);
        }

        Collections.sort(evenCharsForFirst);
        Collections.sort(evenCharsForSecond);

        if (!evenCharsForFirst.equals(evenCharsForSecond)) {
            return false;
        }

        Collections.sort(oddCharsForFirst);
        Collections.sort(oddCharsForSecond);

        if (!oddCharsForFirst.equals(oddCharsForSecond)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        List<String> paramA = new ArrayList<>();
        List<String> paramB = new ArrayList<>();

        while (testCaseCount > 0) {

            String first = br.readLine();
            String second = br.readLine();

            paramA.add(first);
            paramB.add(second);

            testCaseCount--;
        }

        for (int i = 0; i < paramA.size(); i++) {
            boolean isSwappable = isSwappable(paramA.get(i), paramB.get(i));
            String output = isSwappable ? "Yes" : "No";
            System.out.println(output);
        }
    }

}
