package de.carey.desigggn.entity;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CommentEntity {

    /**
     * id : 6663653
     * body : <p>This is great.</p>
     * likes_count : 0
     * likes_url : https://api.dribbble.com/v1/shots/3904002/comments/6663653/likes
     * created_at : 2017-10-27T16:08:19Z
     * updated_at : 2017-10-27T16:08:19Z
     * user : {"id":465897,"name":"Jesse Rogers","username":"jesserogers","html_url":"https://dribbble.com/jesserogers","avatar_url":"https://cdn.dribbble.com/users/465897/avatars/normal/0f6eb3e461d9b7a63d524816328b7067.jpg?1503419558","bio":"Creative Director at Adaptiva","location":"Seattle, WA","links":{"web":"https://jesserogers.co","twitter":"https://twitter.com/jesserogers"},"buckets_count":0,"comments_received_count":57,"followers_count":87,"followings_count":56,"likes_count":252,"likes_received_count":1315,"projects_count":0,"rebounds_received_count":5,"shots_count":76,"teams_count":0,"can_upload_shot":true,"type":"Player","pro":false,"buckets_url":"https://api.dribbble.com/v1/users/465897/buckets","followers_url":"https://api.dribbble.com/v1/users/465897/followers","following_url":"https://api.dribbble.com/v1/users/465897/following","likes_url":"https://api.dribbble.com/v1/users/465897/likes","projects_url":"https://api.dribbble.com/v1/users/465897/projects","shots_url":"https://api.dribbble.com/v1/users/465897/shots","teams_url":"https://api.dribbble.com/v1/users/465897/teams","created_at":"2013-12-23T01:27:18Z","updated_at":"2017-10-25T23:36:44Z"}
     */

    private int id;
    private String body;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("likes_url")
    private String likesUrl;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public String getLikesUrl() {
        return likesUrl;
    }

    public void setLikesUrl(String likesUrl) {
        this.likesUrl = likesUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
