package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.general.Mutator;
import org.tvscript.ga.utils.mutator.PermutationMutationUtils;

import java.util.Random;

public class AbsMutator implements Mutator<AbsRepresentation> {
    Random random;

    public AbsMutator(Random random) {
        this.random = random;
    }

    @Override
    public AbsRepresentation mutate(AbsRepresentation individual) {
        if (random.nextDouble() < 0.05) {
            return individual;
        }
        return new AbsRepresentation(PermutationMutationUtils
                .twoPositionsChangeRandom(individual.getPermutation(), random));
    }
}
