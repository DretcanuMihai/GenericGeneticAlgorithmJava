package org.tvscript.ga.utils.replacer;

import org.tvscript.ga.general.Candidate;
import org.tvscript.ga.general.Replacer;
import org.tvscript.ga.general.Representation;

import java.util.List;

public class GenerationalReplacer implements Replacer {


    @Override
    public <R extends Representation> List<Candidate<R>> replace(List<Candidate<R>> currentCandidates,
                                                                 List<Candidate<R>> offspringCandidates) {
        return offspringCandidates;
    }
}
