package net.quintoimpacto.ubuntuapi.controller;
import net.quintoimpacto.ubuntuapi.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile; // Importación faltante
import java.util.Map;

@RestController
@RequestMapping("/files")
public class ImageController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Map result = cloudinaryService.uploadFile(file);
            System.out.println("Archivo subido exitosamente: " + result.get("url")); // Asumiendo que 'result' contiene una clave 'url'
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/uploadBase64")
    public ResponseEntity<?> uploadBase64File(@RequestParam("fileBase64") String fileBase64) {
        try {
            Map result = cloudinaryService.uploadBase64File(fileBase64);
            System.out.println("Archivo Base64 subido exitosamente: " + result.get("url")); // Asumiendo que 'result' contiene una clave 'url'
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo subir el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/deleteByPublicId")
    public ResponseEntity<?> deleteImageByPublicId(@RequestParam("publicId") String publicId) {
        try {
            Map result = cloudinaryService.deleteImageByPublicId(publicId);
            System.out.println("Imagen eliminada con publicId '" + publicId + "'.");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo borrar la imagen: " + e.getMessage());
        }
    }



}