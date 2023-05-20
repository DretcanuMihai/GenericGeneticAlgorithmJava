package org.tvscript.ga.utils.stopcriteria;

import org.tvscript.ga.ProblemType;
import org.tvscript.ga.population.Candidate;
import org.tvscript.ga.population.StopCriterion;

import java.util.List;

public class FitnessStopCriterion<C extends Candidate> implements StopCriterion<C> {

    private final ProblemType problemType;
    private final double limit;

    public FitnessStopCriterion(ProblemType problemType, double limit) {
        this.problemType = problemType;
        this.limit = limit;
    }

    @Override
    public boolean evaluate(List<C> population) {
        double bestFitness = population.stream().map(Candidate::getFitness)
                .max(problemType.getFitnessComparator()).get();
        return problemType.getFitnessComparator().compare(bestFitness, limit) >= 0;
    }
}
