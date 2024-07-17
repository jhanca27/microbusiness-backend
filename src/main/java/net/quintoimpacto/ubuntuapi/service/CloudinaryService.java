package net.quintoimpacto.ubuntuapi.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public Map uploadFile(MultipartFile file) throws IOException {
        return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
    }

    public Map uploadBase64File(String base64File) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(base64File.split(",")[1]);
        return cloudinary.uploader().upload(decodedBytes, ObjectUtils.emptyMap());
    }

    public Map deleteImageByPublicId(String publicId) throws Exception {
        Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        return result;
    }

}