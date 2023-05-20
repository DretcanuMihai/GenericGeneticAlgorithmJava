package org.tvscreen.ga;

import org.tvscreen.ga.population.Candidate;

import java.util.Comparator;

public enum ProblemType {
    MINIMIZER(((Comparator<Double>) Double::compare).reversed()),
    MAXIMIZER(Double::compareTo);

    private final Comparator<Candidate> candidateComparator;
    private final Comparator<Double> fitnessComparator;

    ProblemType(Comparator<Double> fitnessComparator) {
        this.fitnessComparator = fitnessComparator;
        this.candidateComparator = (o1, o2) -> fitnessComparator.compare(o1.getFitness(), o2.getFitness());
    }

    public Comparator<Double> getFitnessComparator() {
        return fitnessComparator;
    }

    public Comparator<Candidate> getCandidateComparator() {
        return candidateComparator;
    }
}
