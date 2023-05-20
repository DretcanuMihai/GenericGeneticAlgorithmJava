package org.tvscript.ga.utils.selectors;

import org.tvscript.ga.ProblemType;
import org.tvscript.ga.operators.Selector;
import org.tvscript.ga.population.Candidate;

import java.util.*;

public class TournamentSelector<C extends Candidate> implements Selector<C> {

    private final int amountToSelect;

    private final int tournamentSize;

    private final double probability;

    private final ProblemType problemType;

    private final Random random;


    public TournamentSelector(int amountToSelect, int tournamentSize, double probability, ProblemType problemType, Random random) {
        this.random = random;
        this.problemType = problemType;
        this.amountToSelect = amountToSelect;
        this.tournamentSize = tournamentSize;
        this.probability = probability;
    }

    public TournamentSelector(int amountToSelect, int tournamentSize, ProblemType problemType, Random random) {
        this(amountToSelect, tournamentSize, 1, problemType, random);
    }

    @Override
    public List<C> select(List<C> population) {
        List<C> sortedPopulation = population.stream().sorted(problemType.getCandidateComparator()).toList();

        Set<Integer> selectedIndices = new HashSet<>();
        for (int i = 0; i < amountToSelect; i++) {
            Set<Integer> tournamentIndices = new HashSet<>();
            while (tournamentIndices.size() != tournamentSize) {
                Integer generatedIndex = random.nextInt(0, population.size());
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

        return selectedIndices.stream().map(sortedPopulation::get).toList();
    }
}
