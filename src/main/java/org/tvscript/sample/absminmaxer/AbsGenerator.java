package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.population.Generator;
import org.tvscript.ga.utils.generators.PermutationGeneratorUtils;

import java.util.Random;

public class AbsGenerator implements Generator<AbsCandidate> {
    int n;
    Random random;

    public AbsGenerator(int n, Random random) {
        this.n = n;
        this.random = random;
    }

    @Override
    public AbsCandidate generate() {
        return new AbsCandidate(PermutationGeneratorUtils.generatePermutation(n,random));
    }
}
