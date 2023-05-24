package sampletest;

import utils.MergeSort;

public class KhuongDoraemonCake {
    Topic[] T;
    double A; // surface area of the cake

    public KhuongDoraemonCake(Topic[] t, double a) {
        T = t;
        A = a;
    }

    static class Topic{
        double W; // weight
        double S; // surface area this topic takes

        public Topic(double w, double s) {
            W = w;
            S = s;
        }
    }

    public double unlimitedCake(){
        double res = 0;
        for (Topic topic: T){
            res += topic.W;
        }
        return res;
    }

    private double[] getWeightsFromTopics(){

        for ()
    }

    public double weightByNumber(int X){
        MergeSort sort;
        sort.mergeSort();
    }

    public static void main(String[] args) {
//        KhuongDoraemonCake doraemonCake = new KhuongDoraemonCake(10);
    }
}
