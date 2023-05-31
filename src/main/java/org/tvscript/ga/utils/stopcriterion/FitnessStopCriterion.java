package org.tvscript.ga.utils.stopcriterion;

import org.tvscript.ga.GeneticAlgorithm;
import org.tvscript.ga.general.StopCriterion;

public class FitnessStopCriterion implements StopCriterion {

    private final double limit;

    public FitnessStopCriterion(double limit) {
        this.limit = limit;
    }

    @Override
    public boolean mustStop(GeneticAlgorithm<?> geneticAlgorithm) {
        double bestFitness = geneticAlgorithm.getPopulation().get(0).getFitness();
        return geneticAlgorithm.getProblemType().getFitnessComparator().compare(bestFitness, limit) >= 0;
    }
}
