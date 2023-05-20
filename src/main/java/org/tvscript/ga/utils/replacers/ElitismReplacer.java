package org.tvscript.ga.utils.replacers;

import org.tvscript.ga.ProblemType;
import org.tvscript.ga.population.Candidate;
import org.tvscript.ga.population.Replacer;

import java.util.List;
import java.util.stream.Collectors;

public class ElitismReplacer<C extends Candidate> implements Replacer<C> {

    private final ProblemType problemType;

    public ElitismReplacer(ProblemType problemType) {
        this.problemType = problemType;
    }

    @Override
    public List<C> replace(List<C> currentPopulation, List<C> offsprings) {
        List<C> result=currentPopulation.stream()
                .sorted(problemType.getCandidateComparator().reversed())
                .limit(currentPopulation.size()-offsprings.size())
                .collect(Collectors.toList());
        result.addAll(offsprings);
        return result;
    }
}
