package com.example.android_appv2.Model;

public class ClubPostModel {

    String pClubTitle, pDescription;

    public ClubPostModel() {
    }

    public ClubPostModel(String pClubTitle, String pDescription) {
        this.pClubTitle = pClubTitle;
        this.pDescription = pDescription;
    }

    public String getpClubTitle() {
        return pClubTitle;
    }

    public void setpClubTitle(String pClubTitle) {
        this.pClubTitle = pClubTitle;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }
}
