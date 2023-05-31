package org.tvscript.ga.general;

import org.tvscript.ga.GeneticAlgorithm;

public interface StopCriterion {

    boolean mustStop(GeneticAlgorithm<?> geneticAlgorithm);
}
