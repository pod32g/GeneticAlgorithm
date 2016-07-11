package com.pod32g.GA_test;

/**
 * Created by DavidIvan on 05/07/2016.
 */
public class Population {
    Individual[] individuals;

    public Population(int popSize, boolean init) {
        individuals = new Individual[popSize];
        if (init) {
            for (int i = 0;i < size() ; i++ ) {
                Individual newInd = new Individual();
                newInd.generateIndividual();
                saveIndividual(i, newInd);
            }
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];

        for (int i = 0;i < size() ;i++ ) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}
