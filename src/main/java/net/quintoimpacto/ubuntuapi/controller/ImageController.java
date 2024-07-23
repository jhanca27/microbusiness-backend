package net.quintoimpacto.ubuntuapi.controller;

import net.quintoimpacto.ubuntuapi.entity.Image;
import net.quintoimpacto.ubuntuapi.service.CloudinaryService;
import net.quintoimpacto.ubuntuapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("microBusinessId") Long microBusinessId) {
        try {
            Map result = cloudinaryService.uploadFile(file);

            Image image = new Image();
            image.setPublicId((String) result.get("public_id"));
            image.setUrl((String) result.get("url"));

            // Asociar la imagen al microemprendimiento antes de guardarla
            image = imageService.saveImageWithMicroBusiness(microBusinessId, image);

            System.out.println("Imagen subida y guardada en la base de datos con ID: " + image.getId() + " y asociada al microemprendimiento con ID: " + microBusinessId);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/uploadBase64")
    public ResponseEntity<?> uploadBase64File(@RequestParam("fileBase64") String fileBase64, @RequestParam("microBusinessId") Long microBusinessId) {
        try {
            Map result = cloudinaryService.uploadBase64File(fileBase64);

            Image image = new Image();
            image.setPublicId((String) result.get("public_id"));
            image.setUrl((String) result.get("url"));

            // Asociar la imagen al microemprendimiento antes de guardarla
            image = imageService.saveImageWithMicroBusiness(microBusinessId, image);

            System.out.println("Imagen Base64 subida y guardada en la base de datos con ID: " + image.getId() + " y asociada al microemprendimiento con ID: " + microBusinessId);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }


    @PutMapping("/updateBase64")
    public ResponseEntity<?> updateImageBase64(@RequestParam("id") Long id, @RequestParam("fileBase64") String fileBase64) {
        try {
            Optional<Image> existingImageOptional = imageService.findImageById(id);
            if (!existingImageOptional.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Image existingImage = existingImageOptional.get();

            // Eliminar la imagen anterior de Cloudinary
            cloudinaryService.deleteImageByPublicId(existingImage.getPublicId());

            // Subir la nueva imagen a Cloudinary
            Map result = cloudinaryService.uploadBase64File(fileBase64);

            // Actualizar los detalles de la imagen en la base de datos
            existingImage.setPublicId((String) result.get("public_id"));
            existingImage.setUrl((String) result.get("url"));
            Image updatedImage = imageService.saveImage(existingImage);

            return ResponseEntity.ok(updatedImage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo actualizar la imagen: " + e.getMessage());
        }
    }

    @PostMapping("/deleteByPublicId")
    public ResponseEntity<?> deleteImageByPublicId(@RequestParam("publicId") String publicId) {
        try {
            // Paso 1: Eliminar imagen de Cloudinary
            Map result = cloudinaryService.deleteImageByPublicId(publicId);

            // Paso 2 y 3: Buscar y eliminar la imagen de la base de datos local
            Optional<Image> imageOptional = imageService.findImageByPublicId(publicId);
            if (imageOptional.isPresent()) {
                imageService.deleteImage(imageOptional.get().getId());
            } else {
                return ResponseEntity.badRequest().body("Imagen no encontrada en la base de datos");
            }

            // Paso 4: Devolver respuesta de éxito
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // Devolver respuesta de error
            return ResponseEntity.badRequest().body("No se pudo borrar la imagen: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.findAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        return imageService.findImageById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImageById(@PathVariable Long id) {
        try {
            // Paso 1: Buscar la imagen en la base de datos local
            Optional<Image> imageOptional = imageService.findImageById(id);
            if (imageOptional.isPresent()) {
                Image image = imageOptional.get();

                // Paso 2: Eliminar imagen de Cloudinary utilizando el publicId
                Map result = cloudinaryService.deleteImageByPublicId(image.getPublicId());

                // Paso 3: Eliminar la imagen de la base de datos local
                imageService.deleteImage(id);

                // Paso 4: Devolver respuesta de éxito
                return ResponseEntity.ok().body("Imagen eliminada con éxito");
            } else {
                return ResponseEntity.badRequest().body("Imagen no encontrada en la base de datos");
            }
        } catch (Exception e) {
            // Devolver respuesta de error
            return ResponseEntity.badRequest().body("No se pudo borrar la imagen: " + e.getMessage());
        }
    }
}