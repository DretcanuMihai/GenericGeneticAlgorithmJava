package org.tvscript.ga.general;

import org.tvscript.ga.ProblemType;

import java.util.List;

public interface Replacer {

    <R extends Representation> List<Candidate<R>> replace(List<Candidate<R>> currentPopulation,
                                                          List<Candidate<R>> offsprings,
                                                          ProblemType problemType);
}
