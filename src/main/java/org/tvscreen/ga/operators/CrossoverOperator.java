package org.tvscreen.ga.operators;

import org.tvscreen.ga.population.Candidate;

import java.util.List;

public interface CrossoverOperator<C extends Candidate> {

    List<C> cross(List<C> candidates);
}
