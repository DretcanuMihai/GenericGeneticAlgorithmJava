package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.operators.Evaluator;

public class AbsEvaluator implements Evaluator<AbsCandidate> {

    double[] values;

    public AbsEvaluator(double[] values) {
        this.values = values;
    }

    @Override
    public double evaluate(AbsCandidate candidate) {
        int n = values.length;
        int[] permutation = candidate.getPermutation();
        double result = Math.abs(values[permutation[0]]-values[permutation[n-1]]);
        for (int i = 0; i < n - 1; i++){
            result+=Math.abs(values[permutation[i]]-values[permutation[i+1]]);
        }
        return result;
    }
}
