package com.videoservice.dto;
import lombok.Data;

@Data
public class MediaResponseDTO {
    private String id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private String trailerUrl;
    private Integer duration;
    private Integer releaseYear;
    private String type;
    private String category;
    private Double rating;
    private String director;
    private String cast;
}