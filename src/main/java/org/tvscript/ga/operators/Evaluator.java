package org.tvscript.ga.operators;

import org.tvscript.ga.population.Candidate;

public interface Evaluator<C extends Candidate> {

    double evaluate(C candidate);
}
