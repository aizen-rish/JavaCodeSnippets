package rish.scripts.challenges;

import java.util.HashSet;

public class FindLongest {

    public static int findLongest(String s) {

        int len = s.length();

        int max = 1;

        int first = 0;
        int second = first + 1;

        HashSet<Character> unique = new HashSet<>();
        unique.add(s.charAt(first));

        while (first < len && second < len) {

            char c = s.charAt(second);

            if (!unique.contains(c)) {
                unique.add(c);
            } else {

                while (first < len && s.charAt(first) != c) {
                    unique.remove(s.charAt(first));
                    first++;
                }

                first++;
                unique.remove(c);
            }

            max = Math.max(max, second - first + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbberf";
        System.out.println(findLongest(s));
    }

}
