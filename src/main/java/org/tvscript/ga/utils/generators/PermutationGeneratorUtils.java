package org.tvscript.ga.utils.generators;

import java.util.*;

public class PermutationGeneratorUtils {

    public static int[] generatePermutation(int n, Random random) {
        int[] result = new int[n];
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            permutation.add(i);
        }
        Collections.shuffle(permutation, random);
        for (int i = 0; i < n; i++) {
            result[i] = permutation.get(i);
        }
        return result;
    }
}
