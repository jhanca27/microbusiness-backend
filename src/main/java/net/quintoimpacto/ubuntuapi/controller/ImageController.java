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

            // Crear una nueva instancia de Image con los datos relevantes
            Image image = new Image();
            image.setPublicId((String) result.get("public_id"));
            image.setUrl((String) result.get("url"));
            // Asegúrate de establecer cualquier otro campo necesario de Image aquí

            // Guardar la instancia de Image en la base de datos
            Image savedImage = imageService.saveImage(image);

            // Imprimir un mensaje en la terminal
            System.out.println("Imagen Base64 subida y guardada en la base de datos con ID: " + savedImage.getId());

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
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