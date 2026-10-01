package vn.hcmute.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Videos")
public class Videos_24110304 {
    @Id
    @Column(name = "VideoId", length = 50)
    private String videoId;

    @Column(name = "Title", length = 200)
    private String title;

    @Column(name = "Poster", length = 50)
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "CategoryId")
    private Integer categoryId;

    // Generate Getters và Setters
    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }
    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}