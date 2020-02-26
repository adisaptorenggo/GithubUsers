package com.example.githubusers.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    String login;
    @SerializedName("id")
    int id;
    @SerializedName("node_id")
    String node_id;
    @SerializedName("avatar_url")
    String avatar_url;
    @SerializedName("gravatar_id")
    String gravatar_id;
    @SerializedName("url")
    String url;
    @SerializedName("html_url")
    String html_url;
    @SerializedName("followers_url")
    String followers_url;
    @SerializedName("following_url")
    String following_url;
    @SerializedName("gists_url")
    String gists_url;
    @SerializedName("starred_url")
    String starred_url;
    @SerializedName("subscriptions_url")
    String subscriptions_url;
    @SerializedName("organizations_url")
    String organizations_url;
    @SerializedName("repos_url")
    String repos_url;
    @SerializedName("events_url")
    String events_url;
    @SerializedName("received_events_url")
    String received_events_url;
    @SerializedName("type")
    String type;
    @SerializedName("site_admin")
    boolean site_admin;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String geturl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String gettype() {
        return type;
    }

    public boolean getsite_admin() {
        return site_admin;
    }
}
