package com.videoservice.service;

import com.videoservice.dto.MediaRequestDTO;
import com.videoservice.dto.MediaResponseDTO;
import com.videoservice.entity.MediaEntity;
import com.videoservice.exception.ResourceNotFoundException;
import com.videoservice.mapper.MediaMapper;
import com.videoservice.repository.MediaRepository;
import com.videoservice.service.interfaces.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final MediaMapper mediaMapper;

    @Override
    @Transactional
    public MediaResponseDTO createMedia(MediaRequestDTO requestDTO) {
        MediaEntity entity = mediaMapper.toEntity(requestDTO);
        MediaEntity savedEntity = mediaRepository.save(entity);
        return mediaMapper.toResponseDto(savedEntity);
    }

    @Override
    public Page<MediaResponseDTO> getAllMedia(Pageable pageable) {
        return mediaRepository.findAll(pageable)
                .map(mediaMapper::toResponseDto);
    }

    @Override
    public MediaResponseDTO getMediaById(String id) {
        MediaEntity entity = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id: " + id));
        return mediaMapper.toResponseDto(entity);
    }

    @Override
    @Transactional
    public MediaResponseDTO updateMedia(String id, MediaRequestDTO requestDTO) {
        MediaEntity existingEntity = mediaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id: " + id));

        mediaMapper.updateEntityFromDto(requestDTO, existingEntity);

        MediaEntity updatedEntity = mediaRepository.save(existingEntity);
        return mediaMapper.toResponseDto(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteMedia(String id) {
        if (!mediaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete: Media not found with id: " + id);
        }
        mediaRepository.deleteById(id);
    }
}
