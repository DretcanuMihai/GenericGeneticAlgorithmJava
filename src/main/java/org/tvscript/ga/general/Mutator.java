package org.tvscript.ga.general;

public interface Mutator<R extends Representation> {

    R mutate(R individual);
}
