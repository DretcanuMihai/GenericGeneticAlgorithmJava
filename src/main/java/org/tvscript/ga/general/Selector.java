package org.tvscript.ga.general;

import org.tvscript.ga.ProblemType;

import java.util.List;

public interface Selector {

    <R extends Representation> List<Candidate<R>> select(List<Candidate<R>> population, ProblemType problemType);
}
