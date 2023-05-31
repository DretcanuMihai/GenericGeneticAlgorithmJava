package org.tvscript.ga.utils.replacer;

import org.tvscript.ga.ProblemType;
import org.tvscript.ga.general.Candidate;
import org.tvscript.ga.general.Replacer;
import org.tvscript.ga.general.Representation;

import java.util.List;
import java.util.stream.Collectors;

public class ElitismReplacer implements Replacer {


    @Override
    public <R extends Representation> List<Candidate<R>> replace(List<Candidate<R>> currentPopulation,
                                                                 List<Candidate<R>> offsprings,
                                                                 ProblemType problemType) {
        List<Candidate<R>> result = currentPopulation.stream()
                .sorted(problemType.getCandidateComparator().reversed())
                .limit(currentPopulation.size() - offsprings.size())
                .collect(Collectors.toList());
        result.addAll(offsprings);
        return result;
    }
}
