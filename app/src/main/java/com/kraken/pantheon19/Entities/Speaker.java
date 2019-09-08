package com.kraken.pantheon19.Entities;
/*
 * created by RahulKraken on 08-09-2019 at 21:14.
 */

public class Speaker {

    private String name, detail, time, venue, fbLink, linkedinLink, twitterLink;
    private int imageId;

    public Speaker(String name, String detail, String time, String venue, String fbLink, String linkedinLink, String twitterLink, int imageId) {
        this.name = name;
        this.detail = detail;
        this.time = time;
        this.venue = venue;
        this.fbLink = fbLink;
        this.linkedinLink = linkedinLink;
        this.twitterLink = twitterLink;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
