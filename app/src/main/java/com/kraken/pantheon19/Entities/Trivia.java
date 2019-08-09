package com.kraken.pantheon19.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trivia_table")
public class Trivia {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trivia_id")
    private int triviaId;

    private String title;
    private String description;

    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @ColumnInfo(name = "read_more_url")
    private String readMoreUrl;

    public Trivia(String title, String description, String imageUrl, String readMoreUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
    }

    public void setTriviaId(int triviaId) {
        this.triviaId = triviaId;
    }

    public int getTriviaId() {
        return triviaId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReadMoreUrl() {
        return readMoreUrl;
    }
}
