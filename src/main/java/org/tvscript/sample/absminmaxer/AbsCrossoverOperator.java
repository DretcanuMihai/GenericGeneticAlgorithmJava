package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.operators.CrossoverOperator;
import org.tvscript.ga.utils.crossoveroperators.PermutationCrossoverUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbsCrossoverOperator implements CrossoverOperator<AbsCandidate> {
    Random random;

    public AbsCrossoverOperator(Random random) {
        this.random = random;
    }

    @Override
    public List<AbsCandidate> cross(List<AbsCandidate> candidates) {
        List<AbsCandidate> results = new ArrayList<>();
        AbsCandidate c1 = candidates.get(0);
        AbsCandidate c2 = candidates.get(1);

        int[][] p = PermutationCrossoverUtils.onePointCrossoverRandom(c1.getPermutation(), c2.getPermutation(), random);

        AbsCandidate o1, o2;
        o1 = new AbsCandidate(p[0]);
        o2 = new AbsCandidate(p[1]);
        results.add(o1);
        results.add(o2);

        return results;
    }
}
