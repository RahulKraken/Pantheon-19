package com.kraken.pantheon19.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "team_table")
public class Team {
    private int teamId;
    private String teamName;
    private String teamPos;
    private String teamScore;

    public Team(int teamId, String teamName, String teamPos, String teamScore) {
        this.teamId=teamId;
        this.teamName=teamName;
        this.teamPos=teamPos;
        this.teamScore=teamScore;
    }

    public int getTeamId() { return teamId; }

    public String getTeamName() { return teamName; }

    public String getTeamPos() { return teamPos; }

    public String getTeamScore() { return teamScore; }
}