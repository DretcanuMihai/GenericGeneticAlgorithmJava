package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.general.CrossoverOperator;
import org.tvscript.ga.utils.crossover.PermutationCrossoverUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbsCrossoverOperator implements CrossoverOperator<AbsRepresentation> {
    Random random;

    public AbsCrossoverOperator(Random random) {
        this.random = random;
    }

    @Override
    public List<AbsRepresentation> cross(List<AbsRepresentation> parents) {
        List<AbsRepresentation> results = new ArrayList<>();
        AbsRepresentation c1 = parents.get(0);
        AbsRepresentation c2 = parents.get(1);

        int[][] p = PermutationCrossoverUtils.onePointCrossoverRandom(c1.getPermutation(), c2.getPermutation(), random);

        AbsRepresentation o1, o2;
        o1 = new AbsRepresentation(p[0]);
        o2 = new AbsRepresentation(p[1]);
        results.add(o1);
        results.add(o2);

        return results;
    }
}
