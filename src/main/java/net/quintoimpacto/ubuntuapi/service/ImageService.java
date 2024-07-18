package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.entity.Image;
import net.quintoimpacto.ubuntuapi.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Optional;
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public Optional<Image> findImageById(Long id) {
        return imageRepository.findById(id);
    }

    public Optional<Image> findImageByPublicId(String publicId) {
        return imageRepository.findByPublicId(publicId);
    }

    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}

