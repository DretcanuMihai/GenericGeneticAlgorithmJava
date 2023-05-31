package org.tvscript.ga.utils.stopcriterion;

import org.tvscript.ga.GeneticAlgorithm;
import org.tvscript.ga.general.StopCriterion;

public class GenerationStopCriterion implements StopCriterion {
    private final int maxGeneration;

    public GenerationStopCriterion(int maxGeneration) {
        this.maxGeneration = maxGeneration;
    }

    @Override
    public boolean evaluate(GeneticAlgorithm<?> geneticAlgorithm) {
        return geneticAlgorithm.getNrGenerations() >= maxGeneration;
    }
}
