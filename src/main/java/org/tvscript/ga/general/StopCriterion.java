package org.tvscript.ga.general;

import org.tvscript.ga.GeneticAlgorithm;

public interface StopCriterion {

    boolean evaluate(GeneticAlgorithm<?> geneticAlgorithm);
}
