package net.quintoimpacto.ubuntuapi.controller;

import net.quintoimpacto.ubuntuapi.entity.Image;
import net.quintoimpacto.ubuntuapi.service.CloudinaryService;
import net.quintoimpacto.ubuntuapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Map result = cloudinaryService.uploadFile(file);

            // Crear una nueva instancia de Image con los datos relevantes
            Image image = new Image();
            image.setPublicId((String) result.get("public_id"));
            image.setUrl((String) result.get("url"));
            // Asegúrate de establecer cualquier otro campo necesario de Image aquí

            // Guardar la instancia de Image en la base de datos
            Image savedImage = imageService.saveImage(image);

            // Imprimir un mensaje en la terminal
            System.out.println("Imagen subida y guardada en la base de datos con ID: " + savedImage.getId());

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/uploadBase64")
    public ResponseEntity<?> uploadBase64File(@RequestParam("fileBase64") String fileBase64) {
        try {
            Map result = cloudinaryService.uploadBase64File(fileBase64);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/deleteByPublicId")
    public ResponseEntity<?> deleteImageByPublicId(@RequestParam("publicId") String publicId) {
        try {
            Map result = cloudinaryService.deleteImageByPublicId(publicId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
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
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }
}