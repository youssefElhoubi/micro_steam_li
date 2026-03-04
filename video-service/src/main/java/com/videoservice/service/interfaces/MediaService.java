package com.videoservice.service.interfaces;
import com.videoservice.dto.MediaRequestDTO;
import com.videoservice.dto.MediaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MediaService {
    MediaResponseDTO createMedia(MediaRequestDTO requestDTO);
    Page<MediaResponseDTO> getAllMedia(Pageable pageable);
    MediaResponseDTO getMediaById(String id);
    MediaResponseDTO updateMedia(String id, MediaRequestDTO requestDTO);
    void deleteMedia(String id);
}