package org.tvscript.ga.utils.stopcriteria;

import org.tvscript.ga.population.Candidate;
import org.tvscript.ga.population.StopCriterion;

import java.util.List;

public class TimedStopCriterion<C extends Candidate> implements StopCriterion<C> {

    private boolean started = false;

    private long startTime;

    private final long timeLimitInMillis;

    public TimedStopCriterion(long timeLimitInMillis) {
        this.timeLimitInMillis = timeLimitInMillis;
    }

    @Override
    public boolean evaluate(List<C> population) {
        if (!started) {
            started = true;
            startTime = System.currentTimeMillis();
        }
        long currentTime = System.currentTimeMillis();
        return currentTime-startTime<timeLimitInMillis;
    }
}
