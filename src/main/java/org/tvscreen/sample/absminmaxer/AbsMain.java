package org.tvscreen.sample.absminmaxer;

import org.tvscreen.ga.GeneticAlgorithm;
import org.tvscreen.ga.ProblemType;
import org.tvscreen.ga.utils.SimpleConsoleRunner;
import org.tvscreen.ga.utils.replacers.ElitismReplacer;
import org.tvscreen.ga.utils.selectors.TournamentSelector;

import java.util.Random;

public class AbsMain {

    public static void main(String[] args) {
        int n = 10;
        double[] values = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = i * 10;
        }
        Random random = new Random(5);
        GeneticAlgorithm<AbsCandidate> geneticAlgorithm = new GeneticAlgorithm<>(
                ProblemType.MINIMIZER,
                n,
                n / 4,
                new AbsGenerator(n, random),
                new AbsEvaluator(values),
                null,
                //new GenerationStopCriterion<>(maxGen),
                new TournamentSelector<>(2, n / 2, ProblemType.MINIMIZER, random),
                new AbsCrossoverOperator(random),
                new AbsMutator(random),
                new ElitismReplacer<>(ProblemType.MINIMIZER)
        );
        SimpleConsoleRunner<AbsCandidate> runner = new SimpleConsoleRunner<>(geneticAlgorithm);
        runner.run();
    }
}
