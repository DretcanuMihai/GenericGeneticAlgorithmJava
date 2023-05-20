package org.tvscript.ga.utils.replacers;

import org.tvscript.ga.population.Candidate;
import org.tvscript.ga.population.Replacer;

import java.util.List;

public class GenerationalReplacer<C extends Candidate> implements Replacer<C> {


    @Override
    public List<C> replace(List<C> currentPopulation, List<C> offsprings) {
        return offsprings;
    }
}
