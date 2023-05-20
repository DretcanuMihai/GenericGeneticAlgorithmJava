package org.tvscreen.sample.absminmaxer;

import org.tvscreen.ga.operators.Mutator;
import org.tvscreen.ga.utils.mutators.PermutationMutationUtils;

import java.util.Random;

public class AbsMutator implements Mutator<AbsCandidate> {
    Random random;

    public AbsMutator(Random random) {
        this.random = random;
    }

    @Override
    public void mutate(AbsCandidate candidate) {
        PermutationMutationUtils.twoPositionsChangeRandom(candidate.getPermutation(), random);
    }
}
