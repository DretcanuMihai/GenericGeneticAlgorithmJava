package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.operators.Mutator;
import org.tvscript.ga.utils.mutators.PermutationMutationUtils;

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
