package com.pod32g.GA_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by pod32g on 05/07/2016.
 */
public class GA {

    Map<String, String> hashes = new HashMap<String, String>();
    public GA() {
        this.hashes.put("+", "0001");
        this.hashes.put("-","0010");
        this.hashes.put("*","0011");
        this.hashes.put("/","0100");
        this.hashes.put("=","0101");
    }

    private String convert(String non){
        String aux = new String();
        for(int i = 0; i < non.length(); i++){
            aux += this.hashes.get(""+non.toCharArray()[i]);
        }
        return aux;
    }

    private String generate(){
        String[] chars = {"+","-","*","/","="};
        String _final = new String();
        for (int i = 0; i < 32; i++) {
            _final += chars[new Random().nextInt(chars.length)];
        }
        return _final;
    }

    public static void print(Object aux) {
        System.out.println(aux);
    }

    public static void main(String[] args) {
        GA g = new GA();
        String solution = g.generate();
        print("Problem: "+solution);
        print("Problem in bytes: "+g.convert(solution));
        FitnessCalc.setSolution(g.convert(solution));
        Population myPop = new Population(50, true);

        int generationCount = 0;

        while(myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
            generationCount++;
            print("Generation: " + generationCount + " Fitness: " + myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        print("Solution Found!");
        print("Generation: " + generationCount);
        print("Genes:");
        print(myPop.getFittest());
    }
}