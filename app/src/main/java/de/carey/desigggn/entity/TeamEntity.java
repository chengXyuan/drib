package de.carey.desigggn.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TeamEntity implements Serializable {

    /**
     * id : 1767552
     * name : crisscross
     * username : crisscross
     * html_url : https://dribbble.com/crisscross
     * avatar_url : https://cdn.dribbble.com/users/1767552/avatars/normal/c4038ba6fc39ee61b57c8b2a67275e7f.jpg?1497288973
     * bio : design &amp; motion studio - crisscrossloop@gmail.com
     * location : Paris
     * links : {"web":"https://crisscrossparty.tumblr.com/"}
     * buckets_count : 0
     * comments_received_count : 7
     * followers_count : 427
     * followings_count : 243
     * likes_count : 492
     * likes_received_count : 138
     * projects_count : 0
     * rebounds_received_count : 1
     * shots_count : 31
     * can_upload_shot : true
     * type : Team
     * pro : false
     * buckets_url : https://api.dribbble.com/v1/users/1767552/buckets
     * followers_url : https://api.dribbble.com/v1/users/1767552/followers
     * following_url : https://api.dribbble.com/v1/users/1767552/following
     * likes_url : https://api.dribbble.com/v1/users/1767552/likes
     * projects_url : https://api.dribbble.com/v1/users/1767552/projects
     * shots_url : https://api.dribbble.com/v1/users/1767552/shots
     * created_at : 2017-06-12T10:50:00Z
     * updated_at : 2017-10-23T13:08:54Z
     * members_count : 2
     * members_url : https://api.dribbble.com/v1/teams/1767552/members
     * team_shots_url : https://api.dribbble.com/v1/teams/1767552/shots
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("bio")
    private String bio;
    @SerializedName("location")
    private String location;
    @SerializedName("links")
    private LinksEntity links;
    @SerializedName("buckets_count")
    private int bucketsCount;
    @SerializedName("comments_received_count")
    private int commentsReceivedCount;
    @SerializedName("followers_count")
    private int followersCount;
    @SerializedName("followings_count")
    private int followingsCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("likes_received_count")
    private int likesReceivedCount;
    @SerializedName("projects_count")
    private int projectsCount;
    @SerializedName("rebounds_received_count")
    private int reboundsReceivedCount;
    @SerializedName("shots_count")
    private int shotsCount;
    @SerializedName("can_upload_shot")
    private boolean canUploadShot;
    @SerializedName("type")
    private String type;
    @SerializedName("pro")
    private boolean pro;
    @SerializedName("buckets_url")
    private String bucketsUrl;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("likes_url")
    private String likesUrl;
    @SerializedName("projects_url")
    private String projectsUrl;
    @SerializedName("shots_url")
    private String shotsUrl;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("members_count")
    private int membersCount;
    @SerializedName("members_url")
    private String membersUrl;
    @SerializedName("team_shots_url")
    private String teamShotsUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LinksEntity getLinks() {
        return links;
    }

    public void setLinks(LinksEntity links) {
        this.links = links;
    }

    public int getBucketsCount() {
        return bucketsCount;
    }

    public void setBucketsCount(int bucketsCount) {
        this.bucketsCount = bucketsCount;
    }

    public int getCommentsReceivedCount() {
        return commentsReceivedCount;
    }

    public void setCommentsReceivedCount(int commentsReceivedCount) {
        this.commentsReceivedCount = commentsReceivedCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFollowingsCount() {
        return followingsCount;
    }

    public void setFollowingsCount(int followingsCount) {
        this.followingsCount = followingsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getLikesReceivedCount() {
        return likesReceivedCount;
    }

    public void setLikesReceivedCount(int likesReceivedCount) {
        this.likesReceivedCount = likesReceivedCount;
    }

    public int getProjectsCount() {
        return projectsCount;
    }

    public void setProjectsCount(int projectsCount) {
        this.projectsCount = projectsCount;
    }

    public int getReboundsReceivedCount() {
        return reboundsReceivedCount;
    }

    public void setReboundsReceivedCount(int reboundsReceivedCount) {
        this.reboundsReceivedCount = reboundsReceivedCount;
    }

    public int getShotsCount() {
        return shotsCount;
    }

    public void setShotsCount(int shotsCount) {
        this.shotsCount = shotsCount;
    }

    public boolean isCanUploadShot() {
        return canUploadShot;
    }

    public void setCanUploadShot(boolean canUploadShot) {
        this.canUploadShot = canUploadShot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPro() {
        return pro;
    }

    public void setPro(boolean pro) {
        this.pro = pro;
    }

    public String getBucketsUrl() {
        return bucketsUrl;
    }

    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getLikesUrl() {
        return likesUrl;
    }

    public void setLikesUrl(String likesUrl) {
        this.likesUrl = likesUrl;
    }

    public String getProjectsUrl() {
        return projectsUrl;
    }

    public void setProjectsUrl(String projectsUrl) {
        this.projectsUrl = projectsUrl;
    }

    public String getShotsUrl() {
        return shotsUrl;
    }

    public void setShotsUrl(String shotsUrl) {
        this.shotsUrl = shotsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public String getMembersUrl() {
        return membersUrl;
    }

    public void setMembersUrl(String membersUrl) {
        this.membersUrl = membersUrl;
    }

    public String getTeamShotsUrl() {
        return teamShotsUrl;
    }

    public void setTeamShotsUrl(String teamShotsUrl) {
        this.teamShotsUrl = teamShotsUrl;
    }
}
