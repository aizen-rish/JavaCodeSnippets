package rish.scripts.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CreateCombinations {

    public static List<List<Integer>> comb(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        combInternal(1, n, k, ans, new ArrayList<>());
        return ans;
    }

    private static void combInternal(int i, int n, int k, List<List<Integer>> ans, List<Integer> sub) {

        if (sub.size() == k) {
            Collections.sort(sub);
            ans.add(new ArrayList<>(sub));
            return;
        }

        for (int j = i; j <= n; j++) {
            sub.add(j);
            combInternal(j + 1, n, k, ans, sub);
            sub.remove(sub.size() - 1);
        }

    }

    public static void main(String[] args) {

//        System.out.println(comb(4, 1));

        String s = "The quick brown fox The";

        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        Optional<Character> c = chars.stream()
                .filter(c1 -> chars.stream().filter(c2 -> isEqual(c1, c2)).findAny().isPresent()).findFirst();
        System.out.println(c.get());
    }

    private static boolean isEqual(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

}
