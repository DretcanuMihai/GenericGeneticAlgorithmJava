package org.tvscript.ga.utils.stopcriterion;

import org.tvscript.ga.GeneticAlgorithm;
import org.tvscript.ga.general.StopCriterion;

public class TimedStopCriterion implements StopCriterion {

    private final long timeLimitInMillis;

    public TimedStopCriterion(long timeLimitInMillis) {
        this.timeLimitInMillis = timeLimitInMillis;
    }

    @Override
    public boolean evaluate(GeneticAlgorithm<?> geneticAlgorithm) {
        return geneticAlgorithm.getElapsedTime() >= timeLimitInMillis;
    }
}
