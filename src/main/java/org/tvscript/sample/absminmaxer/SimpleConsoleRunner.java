package org.tvscript.sample.absminmaxer;

import org.tvscript.ga.GeneticAlgorithm;
import org.tvscript.ga.general.Representation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleConsoleRunner<C extends Representation> {
    GeneticAlgorithm<C> geneticAlgorithm;

    public SimpleConsoleRunner(GeneticAlgorithm<C> geneticAlgorithm) {
        this.geneticAlgorithm = geneticAlgorithm;
    }

    public void run(){
        geneticAlgorithm.generateInitialPopulation();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int gens;
        while (true) {
            System.out.println("Number of generations to advance:");
            try {
                gens = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println("Invalid input - value should be integer; if negative or 0, the program stops");
                continue;
            }
            if (gens <= 0) {
                break;
            }
            for (int i = 0; i < gens; i++) {
                geneticAlgorithm.advanceToNextGeneration();
            }
            System.out.println("Best 5 solutions:");
            geneticAlgorithm.getPopulation().stream()
                    .limit(5).forEach(System.out::println);
        }
    }
}
