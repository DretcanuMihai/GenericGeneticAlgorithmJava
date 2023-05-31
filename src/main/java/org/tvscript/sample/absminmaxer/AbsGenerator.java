package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.general.Generator;
import org.tvscript.ga.utils.generator.PermutationGeneratorUtils;

import java.util.Random;

public class AbsGenerator implements Generator<AbsRepresentation> {
    int n;
    Random random;

    public AbsGenerator(int n, Random random) {
        this.n = n;
        this.random = random;
    }

    @Override
    public AbsRepresentation generate() {
        return new AbsRepresentation(PermutationGeneratorUtils.generatePermutation(n,random));
    }
}
