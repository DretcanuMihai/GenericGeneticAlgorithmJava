package org.tvscript.ga.population;

import java.util.ArrayList;
import java.util.List;

public interface Generator<C extends Candidate> {

    C generate();

    default List<C> generate(int amount) {
        List<C> candidates = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            C candidate = generate();
            candidates.add(candidate);
        }
        return candidates;
    }
}