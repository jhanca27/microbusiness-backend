package net.quintoimpacto.ubuntuapi.controller;

import net.quintoimpacto.ubuntuapi.dto.ImageDTO;
import net.quintoimpacto.ubuntuapi.service.CloudinaryService;
import net.quintoimpacto.ubuntuapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/uploadBase64")
    public ResponseEntity<?> uploadBase64File(@RequestParam("fileBase64") String fileBase64, @RequestParam("microBusinessId") Long microBusinessId) {
        try {
            Map<String, Object> result = cloudinaryService.uploadBase64File(fileBase64);

            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setPublicId((String) result.get("public_id"));
            imageDTO.setUrl((String) result.get("url"));

            // Asociar la imagen al microemprendimiento antes de guardarla
            ImageDTO savedImage = imageService.saveImageWithMicroBusiness(microBusinessId, imageDTO);

            System.out.println("Imagen Base64 subida y guardada en la base de datos con ID: " + savedImage.getId() + " y asociada al microemprendimiento con ID: " + microBusinessId);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ImageDTO> createImage(@RequestParam String fileBase64,
                                                @RequestParam String url,
                                                @RequestParam String publicId,
                                                @RequestParam Long microBusinessId) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setFileBase64(fileBase64);
        imageDTO.setUrl(url);
        imageDTO.setPublicId(publicId);
        ImageDTO savedImage = imageService.saveImageWithMicroBusiness(microBusinessId, imageDTO);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> getImageById(@PathVariable Long id) {
        Optional<ImageDTO> imageDTO = imageService.findImageById(id);
        return imageDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        List<ImageDTO> images = imageService.findAllImages();
        return ResponseEntity.ok(images);
    }

    @PutMapping("/updateBase64")
    public ResponseEntity<?> updateImageBase64(@RequestParam("id") Long id, @RequestParam("fileBase64") String fileBase64) {
        try {
            Optional<ImageDTO> existingImageOptional = imageService.findImageById(id);
            if (!existingImageOptional.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            ImageDTO existingImage = existingImageOptional.get();

            // Eliminar la imagen anterior de Cloudinary
            cloudinaryService.deleteImageByPublicId(existingImage.getPublicId());

            // Subir la nueva imagen a Cloudinary
            Map<String, Object> result = cloudinaryService.uploadBase64File(fileBase64);

            // Actualizar los detalles de la imagen en la base de datos
            existingImage.setPublicId((String) result.get("public_id"));
            existingImage.setUrl((String) result.get("url"));
            ImageDTO updatedImage = imageService.updateImage(id, existingImage.getUrl(), existingImage.getPublicId());

            System.out.println("Imagen actualizada con ID: " + updatedImage.getId() + " y asociada al microemprendimiento con ID: " + updatedImage.getMicroBusinessId());

            return ResponseEntity.ok(updatedImage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo actualizar la imagen: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        System.out.println("Imagen eliminada con ID: " + id);
        return ResponseEntity.noContent().build();
    }
}