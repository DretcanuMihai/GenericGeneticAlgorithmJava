package org.tvscript.ga.operators;

import org.tvscript.ga.population.Candidate;

import java.util.List;

public interface Selector<C extends Candidate> {

    List<C> select(List<C> population);
}
