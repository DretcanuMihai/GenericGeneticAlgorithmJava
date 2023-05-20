package org.tvscript.ga.utils.stopcriteria;

import org.tvscript.ga.population.Candidate;
import org.tvscript.ga.population.StopCriterion;

import java.util.List;

public class GenerationStopCriterion<C extends Candidate> implements StopCriterion<C> {
    private int currentGeneration = 0;
    private final int maxGeneration;

    public GenerationStopCriterion(int maxGeneration) {
        this.maxGeneration = maxGeneration;
    }

    @Override
    public boolean evaluate(List<C> population) {
        currentGeneration++;
        return currentGeneration == maxGeneration;
    }
}
