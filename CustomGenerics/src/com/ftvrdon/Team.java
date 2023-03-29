package com.ftvrdon;

import java.util.ArrayList;

public class Team<Type extends Player> implements Comparable<Team<Type>> {
    private final String name;

    int played;
    int won;
    int lost;
    int tied;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    private ArrayList<Type> members = new ArrayList<>();

    public boolean addPlayer(Type player){
        if (members.contains(player)){
            System.out.println("Player " + player.getName() + " is already on this team.");
            return false;
        } else {
            members.add(player);
            System.out.println("Player " + player.getName() + " joined team " + this.name);
            return true;
        }
    }

    public int getNumberOfPlayers(){
        return this.members.size();
    }

    public void matchResult (Team<Type> opponent, int ourScore, int theirScore){
        if (ourScore > theirScore){
            won++;
        } else if (ourScore < theirScore) {
            lost++;
        } else {
            tied++;
        }
        played++;
        if (opponent != null){
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", played=" + played +
                ", won=" + won +
                ", lost=" + lost +
                ", tied=" + tied +
                ", members=" + members +
                '}';
    }

    @Override
    public int compareTo(Team<Type> team) {
//        if (this.ranking() > team.ranking()){
//            return -1;
//        } else if (this.ranking() < team.ranking()){
//            return 1;
//        } else {
//            return 0;
//        }
        return Integer.compare(team.ranking(), this.ranking());
    }
}
