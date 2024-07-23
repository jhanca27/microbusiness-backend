package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.entity.Image;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.repository.ImageRepository;
import net.quintoimpacto.ubuntuapi.repository.IMicroBusinessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private IMicroBusinessRepository microBusinessRepository;

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

    public Image updateImage(Long id, String newUrl, String newPublicId) {
        Optional<Image> existingImageOptional = findImageById(id);
        if (!existingImageOptional.isPresent()) {
            throw new RuntimeException("Image not found with ID: " + id);
        }
        Image existingImage = existingImageOptional.get();
        existingImage.setUrl(newUrl);
        existingImage.setPublicId(newPublicId);
        return saveImage(existingImage);
    }

    public Image saveImageWithMicroBusiness(Long microBusinessId, Image image) {
        Optional<MicroBusiness> microBusinessOptional = microBusinessRepository.findById(microBusinessId);
        if (microBusinessOptional.isPresent()) {
            MicroBusiness microBusiness = microBusinessOptional.get();
            image.setMicroBusiness(microBusiness); // Ensure there's a setter in Image for MicroBusiness
            return imageRepository.save(image);
        } else {
            throw new RuntimeException("MicroBusiness not found with ID: " + microBusinessId);
        }
    }



}