package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.GeneticAlgorithm;
import org.tvscript.ga.ProblemType;
import org.tvscript.ga.utils.replacer.ElitismReplacer;
import org.tvscript.ga.utils.selector.TournamentSelector;

import java.util.Random;

public class AbsMain {

    public static void main(String[] args) {
        int n = 10;
        double[] values = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = i * 10;
        }
        Random random = new Random(5);
        GeneticAlgorithm<AbsRepresentation> geneticAlgorithm = new GeneticAlgorithm<>(
                ProblemType.MINIMIZER,
                n,
                n / 4,
                new AbsGenerator(n, random),
                new AbsEvaluator(values),
                null,
                //new GenerationStopCriterion<>(maxGen),
                new TournamentSelector(2, n / 2, random),
                new AbsCrossoverOperator(random),
                new AbsMutator(random),
                new ElitismReplacer()
        );
        SimpleConsoleRunner<AbsRepresentation> runner = new SimpleConsoleRunner<>(geneticAlgorithm);
        runner.run();
    }
}
