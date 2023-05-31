package org.tvscript.ga.general;

import java.util.List;

public interface Replacer {

    <R extends Representation> List<Candidate<R>> replace(List<Candidate<R>> currentCandidates,
                                                          List<Candidate<R>> offspringCandidates);
}
