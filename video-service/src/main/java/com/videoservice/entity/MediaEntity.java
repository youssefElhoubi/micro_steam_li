package com.videoservice.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaEntity {

    @Id
    private String id; // MongoDB IDs are usually Strings (ObjectIds)

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