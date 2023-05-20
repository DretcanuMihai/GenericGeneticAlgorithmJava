package org.tvscreen.ga.utils.replacers;

import org.tvscreen.ga.population.Candidate;
import org.tvscreen.ga.population.Replacer;

import java.util.List;

public class GenerationalReplacer<C extends Candidate> implements Replacer<C> {


    @Override
    public List<C> replace(List<C> currentPopulation, List<C> offsprings) {
        return offsprings;
    }
}
