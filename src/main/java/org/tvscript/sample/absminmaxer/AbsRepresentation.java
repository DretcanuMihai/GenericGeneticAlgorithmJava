package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.general.Representation;

import java.util.Arrays;

public class AbsRepresentation implements Representation {
    int[] permutation;

    public AbsRepresentation(int[] permutation) {
        this.permutation = permutation;
    }

    public int[] getPermutation() {
        return permutation;
    }

    @Override
    public String toString() {
        return "AbsCandidate{" +
                ", permutation=" + Arrays.toString(permutation) +
                '}';
    }
}
