package com.challenge.shortener.application.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="url")
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue
    private UUID id;

    private String originalUrl;
    private String shortUrl;
    private LocalDateTime inspirateData;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getInspirateData() {
        return inspirateData;
    }

    public void setInspirateData(LocalDateTime inspirateData) {
        this.inspirateData = inspirateData;
    }
}
