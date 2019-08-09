package com.kraken.pantheon19.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trivia_table")
public class Trivia {

    @PrimaryKey
    @ColumnInfo(name = "trivia_id")
    private int triviaId;

    private String title;
    private String description;

    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @ColumnInfo(name = "read_more_url")
    private String readMoreUrl;

    public Trivia(int triviaId, String title, String description, String imageUrl, String readMoreUrl) {
        this.triviaId = triviaId;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
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
