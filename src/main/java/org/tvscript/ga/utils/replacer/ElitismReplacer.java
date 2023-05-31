package org.tvscript.ga.utils.replacer;

import org.tvscript.ga.general.Candidate;
import org.tvscript.ga.general.Replacer;
import org.tvscript.ga.general.Representation;

import java.util.List;
import java.util.stream.Collectors;

public class ElitismReplacer implements Replacer {

    @Override
    public <R extends Representation> List<Candidate<R>> replace(List<Candidate<R>> currentCandidates,
                                                                 List<Candidate<R>> offspringCandidates) {
        List<Candidate<R>> result = currentCandidates.stream()
                .limit(currentCandidates.size() - offspringCandidates.size())
                .collect(Collectors.toList());
        result.addAll(offspringCandidates);
        return result;
    }
}
