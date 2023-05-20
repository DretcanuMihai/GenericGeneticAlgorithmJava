package org.tvscript.ga.operators;

import org.tvscript.ga.population.Candidate;

public interface Mutator<C extends Candidate> {

    void mutate(C candidate);
}
