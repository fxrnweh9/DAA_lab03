package org.example.obj;

public class Edge {

    private String from;
    private int weight;
    private String to;



    public Edge(String from, int weight, String to){
        this.from = from;
        this.weight = weight;
        this.to = to;
    }


    public String getFrom(){
        return from;
    }

    public int getWeight(){
        return weight;
    }

    public String getTo(){
        return to;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setTo(String to){
        this.to = to;
    }

    @Override
    public String toString(){
        return String.format("(%s - %s, w=%d)", from, to, weight);
    }
}
