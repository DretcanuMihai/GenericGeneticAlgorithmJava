package org.tvscript.ga.operators;

import org.tvscript.ga.population.Candidate;

import java.util.List;

public interface CrossoverOperator<C extends Candidate> {

    List<C> cross(List<C> candidates);
}
