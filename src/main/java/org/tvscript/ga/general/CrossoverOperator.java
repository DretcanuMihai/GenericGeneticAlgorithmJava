package org.tvscript.ga.general;

import java.util.List;

public interface CrossoverOperator<R extends Representation> {

    List<R> cross(List<R> parents);
}
