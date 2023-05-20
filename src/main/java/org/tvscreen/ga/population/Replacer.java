package org.tvscreen.ga.population;

import java.util.List;

public interface Replacer<C extends Candidate> {

    List<C> replace(List<C> currentPopulation, List<C> offsprings);
}
