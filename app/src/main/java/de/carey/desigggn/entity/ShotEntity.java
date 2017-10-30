package de.carey.desigggn.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ShotEntity implements Serializable {


    /**
     * id : 3889646
     * title : Infinite machine
     * description : <p>Big motion piece in progress!
     * <br />This is another scene, a ball on its course encountering weird 3D totems and 2D shapes.</p>
     * <p>
     * <p><a href="https://www.instagram.com/crisscross.studio/" rel="nofollow noreferrer">You can check us out on instagram!</a></p>
     * <p>
     * <p>-  <a href="https://dribbble.com/crisscross" rel="nofollow noreferrer">crisscross</a></p>
     * <p>
     * <p><a href="https://dribbble.com/lucasmarinm" rel="nofollow noreferrer">@lu
     * width : 400
     * height : 300
     * images : {"hidpi":"https://cdn.dribbble.com/users/80960/screenshots/3889646/rube-dribbbl-2.gif","normal":"https://cdn.dribbble.com/users/80960/screenshots/3889646/rube-dribbbl-2_1x.gif","teaser":"https://cdn.dribbble.com/users/80960/screenshots/3889646/rube-dribbbl-2_teaser.gif"}
     * views_count : 4770
     * likes_count : 309
     * comments_count : 19
     * attachments_count : 0
     * rebounds_count : 0
     * buckets_count : 29
     * created_at : 2017-10-21T13:36:59Z
     * updated_at : 2017-10-21T17:30:02Z
     * html_url : https://dribbble.com/shots/3889646-Infinite-machine
     * attachments_url : https://api.dribbble.com/v1/shots/3889646/attachments
     * buckets_url : https://api.dribbble.com/v1/shots/3889646/buckets
     * comments_url : https://api.dribbble.com/v1/shots/3889646/comments
     * likes_url : https://api.dribbble.com/v1/shots/3889646/likes
     * projects_url : https://api.dribbble.com/v1/shots/3889646/projects
     * rebounds_url : https://api.dribbble.com/v1/shots/3889646/rebounds
     * rebound_source_url : https://api.dribbble.com/v1/shots/3880693
     * animated : true
     * tags : ["ball","bounce","course","goldberg","infinity","loop","machine","rebound","rube","sine","totem"]
     * user : {"id":80960,"name":"Stéphane Gibert","username":"gibert_s","html_url":"https://dribbble.com/gibert_s","avatar_url":"https://cdn.dribbble.com/users/80960/avatars/normal/64d7643dcbb1d55926541a6651e1b67c.jpg?1506810786","bio":"motion art director - <a href=\"https://dribbble.com/crisscross\">@crisscross<\/a> - available for freelance","location":"Paris","links":{"web":"http://sgibert.me/","twitter":"https://twitter.com/gibert_s"},"buckets_count":19,"comments_received_count":174,"followers_count":736,"followings_count":766,"likes_count":3989,"likes_received_count":4217,"projects_count":0,"rebounds_received_count":14,"shots_count":53,"teams_count":0,"can_upload_shot":true,"type":"Player","pro":true,"buckets_url":"https://api.dribbble.com/v1/users/80960/buckets","followers_url":"https://api.dribbble.com/v1/users/80960/followers","following_url":"https://api.dribbble.com/v1/users/80960/following","likes_url":"https://api.dribbble.com/v1/users/80960/likes","projects_url":"https://api.dribbble.com/v1/users/80960/projects","shots_url":"https://api.dribbble.com/v1/users/80960/shots","teams_url":"https://api.dribbble.com/v1/users/80960/teams","created_at":"2011-12-04T18:34:53Z","updated_at":"2017-10-23T13:10:15Z"}
     * team : {"id":1767552,"name":"crisscross","username":"crisscross","html_url":"https://dribbble.com/crisscross","avatar_url":"https://cdn.dribbble.com/users/1767552/avatars/normal/c4038ba6fc39ee61b57c8b2a67275e7f.jpg?1497288973","bio":"design &amp; motion studio - crisscrossloop@gmail.com","location":"Paris","links":{"web":"https://crisscrossparty.tumblr.com/"},"buckets_count":0,"comments_received_count":7,"followers_count":427,"followings_count":243,"likes_count":492,"likes_received_count":138,"projects_count":0,"rebounds_received_count":1,"shots_count":31,"can_upload_shot":true,"type":"Team","pro":false,"buckets_url":"https://api.dribbble.com/v1/users/1767552/buckets","followers_url":"https://api.dribbble.com/v1/users/1767552/followers","following_url":"https://api.dribbble.com/v1/users/1767552/following","likes_url":"https://api.dribbble.com/v1/users/1767552/likes","projects_url":"https://api.dribbble.com/v1/users/1767552/projects","shots_url":"https://api.dribbble.com/v1/users/1767552/shots","created_at":"2017-06-12T10:50:00Z","updated_at":"2017-10-23T13:08:54Z","members_count":2,"members_url":"https://api.dribbble.com/v1/teams/1767552/members","team_shots_url":"https://api.dribbble.com/v1/teams/1767552/shots"}
     */

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("images")
    private ImageEntity images;
    @SerializedName("views_count")
    private int viewsCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("attachments_count")
    private int attachmentsCount;
    @SerializedName("rebounds_count")
    private int reboundsCount;
    @SerializedName("buckets_count")
    private int bucketsCount;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("attachments_url")
    private String attachmentsUrl;
    @SerializedName("buckets_url")
    private String bucketsUrl;
    @SerializedName("comments_url")
    private String commentsUrl;
    @SerializedName("likes_url")
    private String likesUrl;
    @SerializedName("projects_url")
    private String projectsUrl;
    @SerializedName("rebounds_url")
    private String reboundsUrl;
    @SerializedName("rebound_source_url")
    private String reboundSourceUrl;
    @SerializedName("animated")
    private boolean animated;
    @SerializedName("user")
    private UserEntity user;
    @SerializedName("team")
    private TeamEntity team;
    @SerializedName("tags")
    private List<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImageEntity getImages() {
        return images;
    }

    public void setImages(ImageEntity images) {
        this.images = images;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getAttachmentsCount() {
        return attachmentsCount;
    }

    public void setAttachmentsCount(int attachmentsCount) {
        this.attachmentsCount = attachmentsCount;
    }

    public int getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(int reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    public int getBucketsCount() {
        return bucketsCount;
    }

    public void setBucketsCount(int bucketsCount) {
        this.bucketsCount = bucketsCount;
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

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getAttachmentsUrl() {
        return attachmentsUrl;
    }

    public void setAttachmentsUrl(String attachmentsUrl) {
        this.attachmentsUrl = attachmentsUrl;
    }

    public String getBucketsUrl() {
        return bucketsUrl;
    }

    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
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

    public String getReboundsUrl() {
        return reboundsUrl;
    }

    public void setReboundsUrl(String reboundsUrl) {
        this.reboundsUrl = reboundsUrl;
    }

    public String getReboundSourceUrl() {
        return reboundSourceUrl;
    }

    public void setReboundSourceUrl(String reboundSourceUrl) {
        this.reboundSourceUrl = reboundSourceUrl;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
