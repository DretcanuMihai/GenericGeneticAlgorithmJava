package org.tvscript.ga.utils.crossover;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PermutationCrossoverUtils {

    public static int[][] onePointCrossoverRandom(int[] permutation1, int[] permutation2, Random random) {
        int n = permutation1.length;
        int k = random.nextInt(1, n);
        int[][] results = new int[2][];
        results[0] = onePointCrossover(permutation1, permutation2, k);
        results[1] = onePointCrossover(permutation2, permutation1, k);
        return results;
    }

    private static int[] onePointCrossover(int[] permutation1, int[] permutation2, int k) {
        int n = permutation1.length;
        int[] result = new int[n];

        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < k; i++) {
            result[i] = permutation1[i];
            used.add(permutation1[i]);
        }
        int idx = 0;
        for (int i = k; i < n; i++) {
            while (used.contains(permutation2[idx])){
                idx++;
            }
            result[i]=permutation2[idx];
            idx++;
        }
        return result;
    }
}
