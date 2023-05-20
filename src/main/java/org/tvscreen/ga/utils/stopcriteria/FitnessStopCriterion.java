package org.tvscreen.ga.utils.stopcriteria;

import org.tvscreen.ga.ProblemType;
import org.tvscreen.ga.population.Candidate;
import org.tvscreen.ga.population.StopCriterion;

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
