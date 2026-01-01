package com.example.motorbike_be.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.motorbike_be.services.CloudinaryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    @SuppressWarnings("unchecked")
    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        Map<String, Object> result =
                cloudinary.uploader().upload(
                        file.getBytes(),
                        ObjectUtils.asMap(
                                "folder", "avatars",
                                "resource_type", "image"
                        )
                );
        return String.valueOf(result.get("secure_url"));
    }
}
