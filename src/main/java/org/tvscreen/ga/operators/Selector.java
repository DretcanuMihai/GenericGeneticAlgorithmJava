package org.tvscreen.ga.operators;

import org.tvscreen.ga.population.Candidate;

import java.util.List;

public interface Selector<C extends Candidate> {

    List<C> select(List<C> population);
}
