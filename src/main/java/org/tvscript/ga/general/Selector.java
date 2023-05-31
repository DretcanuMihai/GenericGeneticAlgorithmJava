package org.tvscript.ga.general;

import java.util.List;

public interface Selector {

    <R extends Representation> List<Candidate<R>> select(List<Candidate<R>> population);
}
