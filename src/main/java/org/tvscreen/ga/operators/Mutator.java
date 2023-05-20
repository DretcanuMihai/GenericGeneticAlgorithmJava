package org.tvscreen.ga.operators;

import org.tvscreen.ga.population.Candidate;

public interface Mutator<C extends Candidate> {

    void mutate(C candidate);
}
