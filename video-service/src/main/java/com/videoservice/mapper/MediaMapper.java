package com.videoservice.mapper;
import com.videoservice.dto.MediaDTO;
import com.videoservice.entity.MediaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MediaMapper {

    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

    MediaDTO toDto(MediaEntity entity);

    MediaEntity toEntity(MediaDTO dto);
}