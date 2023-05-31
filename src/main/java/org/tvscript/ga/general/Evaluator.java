package org.tvscript.ga.general;

public interface Evaluator<R extends Representation> {

    double evaluate(R individual);
}
