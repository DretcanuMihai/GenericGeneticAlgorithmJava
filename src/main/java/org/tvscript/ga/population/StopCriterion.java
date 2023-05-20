package org.tvscript.ga.population;

import java.util.List;

public interface StopCriterion<C extends Candidate> {

    boolean evaluate(List<C> population);
}
