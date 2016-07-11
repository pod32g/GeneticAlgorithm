package com.pod32g.GA_test;

/**
 * Created by pod32g on 05/07/2016.
 */
public class GA {

    public static void print(Object aux) {
        System.out.println(aux);
    }

    public static void main(String[] args) {
        FitnessCalc.setSolution("11110000000000000000000000000000000000000000000000000000111111110101101010110110000011100000000000000000000111111111111111111111");
        Population myPop = new Population(50, true);

        int generationCount = 0;

        while(myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
            generationCount++;
            print("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        print("Solution Found!");
        print("Generation: " + generationCount);
        print("Genes:");
        print(myPop.getFittest());
    }
}