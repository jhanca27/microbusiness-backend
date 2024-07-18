package net.quintoimpacto.ubuntuapi.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String publicId;

    @Column(nullable = false)
    private String url;

    @Column(nullable = true)
    private String title;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private String contentType;

    @Column(nullable = true)
    private Integer width;

    @Column(nullable = true)
    private Integer height;

    @Column(nullable = true)
    private String tags;

    public Image() {
    }

    public Image(String publicId, String url, String title, LocalDateTime createdAt, String contentType, Integer width, Integer height, String tags) {
        this.publicId = publicId;
        this.url = url;
        this.title = title;
        this.createdAt = createdAt;
        this.contentType = contentType;
        this.width = width;
        this.height = height;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Note: The setCreatedAt method is not needed when @CreationTimestamp is used
    // as it automatically sets the creation time.

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}