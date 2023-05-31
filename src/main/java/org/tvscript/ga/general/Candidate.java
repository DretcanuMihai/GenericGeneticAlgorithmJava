package org.tvscript.ga.general;

public class Candidate<R extends Representation> {
    private double fitness;

    private R representation;

    public Candidate(double fitness, R representation) {
        this.fitness = fitness;
        this.representation = representation;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public R getRepresentation() {
        return representation;
    }

    public void setRepresentation(R representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return "{\n" +
                "Representation: " + representation.toString() + " \n" +
                "Fitness: " + fitness + " \n" +
                "}";
    }
}
