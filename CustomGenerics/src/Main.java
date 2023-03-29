import com.ftvrdon.BaseballPlayer;
import com.ftvrdon.FootballPlayer;
import com.ftvrdon.SoccerPlayer;
import com.ftvrdon.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<> ("Adelaide Crows");
        adelaideCrows.addPlayer(joe);

        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team<>("Soccer Team");
        soccerTeam.addPlayer(beckham);

//        System.out.println(adelaideCrows);
//        System.out.println(baseballTeam);
//        System.out.println(soccerTeam);

        Team<FootballPlayer> freemantle = new Team<> ("Freemantle");
        Team<FootballPlayer> sydneyGators = new Team<> ("Sydney Gators");
        Team<FootballPlayer> southernKoalas = new Team<> ("Southern Koalas");
        Team<FootballPlayer> melbourneSharks = new Team<> ("Melbourne Sharks");
        Team<FootballPlayer> havilandBeasts = new Team<> ("Haviland Beasts");



        adelaideCrows.matchResult(freemantle,2,1);
        adelaideCrows.matchResult(sydneyGators,3,1);
        adelaideCrows.matchResult(southernKoalas,1,3);
        adelaideCrows.matchResult(melbourneSharks,4,3);
        adelaideCrows.matchResult(southernKoalas,1,3);
        adelaideCrows.matchResult(havilandBeasts,1,8);

        sydneyGators.matchResult(freemantle,2,1);
        sydneyGators.matchResult(southernKoalas,2,5);
        sydneyGators.matchResult(sydneyGators,4,1);
        sydneyGators.matchResult(melbourneSharks,2,5);

        havilandBeasts.matchResult(freemantle,9,1);
        havilandBeasts.matchResult(adelaideCrows,4,0);
        havilandBeasts.matchResult(southernKoalas,5,2);
        havilandBeasts.matchResult(melbourneSharks,3,0);
        havilandBeasts.matchResult(sydneyGators,6,1);


//        System.out.println("Rankings");
//        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
//        System.out.println(freemantle.getName() + ": " + freemantle.ranking());

        ArrayList<Team<FootballPlayer>> footballLeague = new ArrayList<>();
        footballLeague.add(adelaideCrows);
        footballLeague.add(freemantle);
        footballLeague.add(southernKoalas);
        footballLeague.add(sydneyGators);
        footballLeague.add(melbourneSharks);
        footballLeague.add(havilandBeasts);

        footballLeague.add(baseballTeam);

        System.out.println(footballLeague);

        Collections.sort(footballLeague);
        for (Team<FootballPlayer> team : footballLeague){
            System.out.println(team.getName() + ": " + team.ranking());
        }
//        static method sort on Collections can be used to sort arrays by utilizing implemented compareTo method //
    }


}