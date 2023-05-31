package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.general.Evaluator;

public class AbsEvaluator implements Evaluator<AbsRepresentation> {

    double[] values;

    public AbsEvaluator(double[] values) {
        this.values = values;
    }

    @Override
    public double evaluate(AbsRepresentation individual) {
        int n = values.length;
        int[] permutation = individual.getPermutation();
        double result = Math.abs(values[permutation[0]]-values[permutation[n-1]]);
        for (int i = 0; i < n - 1; i++){
            result+=Math.abs(values[permutation[i]]-values[permutation[i+1]]);
        }
        return result;
    }
}
