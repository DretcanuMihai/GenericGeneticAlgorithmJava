package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.population.Candidate;

import java.util.Arrays;

public class AbsCandidate implements Candidate {
    double fitness;
    int[] permutation;

    public AbsCandidate(int[] permutation) {
        this.permutation = permutation;
    }

    public int[] getPermutation() {
        return permutation;
    }

    @Override
    public double getFitness() {
        return fitness;
    }

    @Override
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        return "AbsCandidate{" +
                "fitness=" + fitness +
                ", permutation=" + Arrays.toString(permutation) +
                '}';
    }
}
