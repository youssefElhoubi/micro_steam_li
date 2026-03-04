package com.videoservice.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MediaRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String description;

    @Pattern(regexp = "^(http|https)://.*", message = "Invalid URL format")
    private String thumbnailUrl;

    @Pattern(regexp = "^(http|https)://.*", message = "Invalid URL format")
    private String trailerUrl;

    @Positive(message = "Duration must be positive")
    private Integer duration;

    @Min(value = 1888, message = "Release year is invalid")
    private Integer releaseYear;

    @NotBlank(message = "Type (Movie/Series) is required")
    private String type;

    private String category;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double rating;

    private String director;
    private String cast;
}