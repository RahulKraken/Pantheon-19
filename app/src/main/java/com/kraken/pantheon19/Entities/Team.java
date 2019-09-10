package com.kraken.pantheon19.Entities;
/*
 * created by RahulKraken on 08-09-2019 at 20:00.
 */

public class Team {
    private int teamId;
    private String teamName;
    private int teamPos;
    private int teamScore;

    public Team(int teamId, String teamName, int teamPos, int teamScore) {
        this.teamId=teamId;
        this.teamName=teamName;
        this.teamPos=teamPos;
        this.teamScore=teamScore;
    }

    public int getTeamId() { return teamId; }

    public String getTeamName() { return teamName; }

    public int getTeamPos() { return teamPos; }

    public int getTeamScore() { return teamScore; }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamPos=" + teamPos +
                ", teamScore=" + teamScore +
                '}';
    }
}
