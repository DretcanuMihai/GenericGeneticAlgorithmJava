package org.tvscreen.ga.operators;

import org.tvscreen.ga.population.Candidate;

public interface Evaluator<C extends Candidate> {

    double evaluate(C candidate);
}
