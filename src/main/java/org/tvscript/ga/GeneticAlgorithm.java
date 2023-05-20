package org.tvscript.ga;

import org.tvscript.ga.operators.CrossoverOperator;
import org.tvscript.ga.operators.Evaluator;
import org.tvscript.ga.operators.Mutator;
import org.tvscript.ga.operators.Selector;
import org.tvscript.ga.population.Candidate;
import org.tvscript.ga.population.Generator;
import org.tvscript.ga.population.Replacer;
import org.tvscript.ga.population.StopCriterion;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm<C extends Candidate> {

    private final ProblemType problemType;

    private List<C> population;

    private final int populationSize;

    private final int reproductionsPerGeneration;

    private final Generator<C> generator;

    private final Evaluator<C> evaluator;

    private final StopCriterion<C> stopCriterion;

    private final Selector<C> selector;

    private final CrossoverOperator<C> crossoverOperator;

    private final Mutator<C> mutator;

    private final Replacer<C> replacer;

    public GeneticAlgorithm(ProblemType problemType, int populationSize, int reproductionsPerGeneration, Generator<C> generator,
                            Evaluator<C> evaluator, StopCriterion<C> stopCriterion, Selector<C> selector,
                            CrossoverOperator<C> crossoverOperator, Mutator<C> mutator,
                            Replacer<C> replacer) {
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

    public void run() {
        generateInitialPopulation();
        while (!stopCriterion.evaluate(population)) {
            advanceToNextGeneration();
        }
    }

    public List<C> getPopulation() {
        return population;
    }

    public void generateInitialPopulation() {
        population = generator.generate(populationSize);
        evaluateAndSortCandidates(population);
    }

    public void advanceToNextGeneration() {
        List<C> generationOffsprings = new ArrayList<>();
        for (int i = 0; i < reproductionsPerGeneration; i++) {
            List<C> candidates = selector.select(population);
            List<C> offsprings = crossoverOperator.cross(candidates);
            offsprings.forEach(mutator::mutate);
            generationOffsprings.addAll(offsprings);
        }
        evaluateAndSortCandidates(generationOffsprings);
        population = replacer.replace(population, generationOffsprings);
        population.sort(problemType.getCandidateComparator().reversed());
    }

    private void evaluateAndSortCandidates(List<C> candidates){
        candidates.forEach(this::setCandidateFitness);
        candidates.sort(problemType.getCandidateComparator().reversed());
    }

    private void setCandidateFitness(C candidate) {
        double fitness = evaluator.evaluate(candidate);
        candidate.setFitness(fitness);
    }
}
