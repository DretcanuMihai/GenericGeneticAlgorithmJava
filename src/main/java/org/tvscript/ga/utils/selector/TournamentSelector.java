package org.tvscript.ga.utils.selector;

import org.tvscript.ga.general.Candidate;
import org.tvscript.ga.general.Selector;
import org.tvscript.ga.general.Representation;

import java.util.*;

public class TournamentSelector implements Selector {

    private final int amountToSelect;

    private final int tournamentSize;

    private final double probability;

    private final Random random;


    public TournamentSelector(int amountToSelect, int tournamentSize, double probability, Random random) {
        this.random = random;
        this.amountToSelect = amountToSelect;
        this.tournamentSize = tournamentSize;
        this.probability = probability;
    }

    public TournamentSelector(int amountToSelect, int tournamentSize, Random random) {
        this(amountToSelect, tournamentSize, 1, random);
    }

    @Override
    public <R extends Representation> List<Candidate<R>> select(List<Candidate<R>> candidates) {
        Set<Integer> selectedIndices = new HashSet<>();
        for (int i = 0; i < amountToSelect; i++) {
            Set<Integer> tournamentIndices = new HashSet<>();
            while (tournamentIndices.size() != tournamentSize) {
                Integer generatedIndex = random.nextInt(0, candidates.size());
                if (!selectedIndices.contains(generatedIndex)) {
                    tournamentIndices.add(generatedIndex);
                }
            }

            int winnerIndex = 0;
            while (winnerIndex != tournamentSize - 1) {
                if (random.nextDouble(0, 1) < probability) {
                    break;
                }
                winnerIndex++;
            }
            selectedIndices.add(tournamentIndices.stream().sorted().toList().get(winnerIndex));
        }

        return selectedIndices.stream().map(candidates::get).toList();
    }
}
