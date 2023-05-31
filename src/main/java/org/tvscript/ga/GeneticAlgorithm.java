package org.tvscript.ga;

import org.tvscript.ga.general.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class encapsulating a genetic algorithm behaviour.
 * A "population" is a List<Candidate> and it is always sorted such that the best solution are at the lower indices.
 * Cases such as this are the getPopulation() method and the methods of the objects of class Selector and Replacer
 */
public class GeneticAlgorithm<R extends Representation> {

    private int nrGenerations;

    private long startTime;

    private final ProblemType problemType;

    private List<Candidate<R>> population;

    private final int populationSize;

    private final int reproductionsPerGeneration;

    private final Generator<R> generator;

    private final Evaluator<R> evaluator;

    private final StopCriterion stopCriterion;

    private final Selector selector;

    private final CrossoverOperator<R> crossoverOperator;

    private final Mutator<R> mutator;

    private final Replacer replacer;

    public GeneticAlgorithm(ProblemType problemType, int populationSize, int reproductionsPerGeneration,
                            Generator<R> generator, Evaluator<R> evaluator, StopCriterion stopCriterion,
                            Selector selector, CrossoverOperator<R> crossoverOperator, Mutator<R> mutator,
                            Replacer replacer) {

        this.problemType = problemType;
        this.populationSize = populationSize;
        this.reproductionsPerGeneration = reproductionsPerGeneration;
        this.generator = generator;
        this.evaluator = evaluator;
        this.stopCriterion = stopCriterion;
        this.selector = selector;
        this.crossoverOperator = crossoverOperator;
        this.mutator = mutator;
        this.replacer = replacer;
    }

    public List<Candidate<R>> getPopulation() {
        return population;
    }

    public int getNrGenerations() {
        return nrGenerations;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void run() {
        generateInitialPopulation();
        while (!stopCriterion.mustStop(this)) {
            advanceToNextGeneration();
        }
    }


    public void generateInitialPopulation() {
        nrGenerations = 0;
        startTime = System.currentTimeMillis();
        List<R> initialRepresentations = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            initialRepresentations.add(generator.generate());
        }
        population = evaluateAndRankIndividuals(initialRepresentations);
    }

    public void advanceToNextGeneration() {
        List<R> currentOffsprings = new ArrayList<>();
        for (int i = 0; i < reproductionsPerGeneration; i++) {
            List<R> selectedIndividuals = selector.select(population).stream()
                    .map(Candidate::getRepresentation)
                    .collect(Collectors.toList());
            List<R> offsprings = crossoverOperator.cross(selectedIndividuals)
                    .stream()
                    .map(mutator::mutate).toList();
            currentOffsprings.addAll(offsprings);
        }
        List<Candidate<R>> offspringCandidates = evaluateAndRankIndividuals(currentOffsprings);
        population = replacer.replace(population, offspringCandidates);
        population.sort(problemType.getCandidateComparator().reversed());
        nrGenerations++;
    }

    private List<Candidate<R>> evaluateAndRankIndividuals(List<R> individuals) {
        return individuals.stream().map(this::evaluateIndividual)
                .sorted(problemType.getCandidateComparator().reversed())
                .collect(Collectors.toList());
    }

    private Candidate<R> evaluateIndividual(R individual) {
        double fitness = evaluator.evaluate(individual);
        return new Candidate<>(fitness, individual);
    }
}
