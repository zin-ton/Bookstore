package com.example.bookstore.controlers;

import com.example.bookstore.models.Image;
import com.example.bookstore.repositories.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class UploadController {
    public static String uploadLocation = System.getProperty("user.dir") + "/uploads/";
    private final ImageRepository imageRepository;
    public UploadController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    @GetMapping("/upload")
    public String displayUpload() {
        return "imageupload/index";
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadImage(Model model, @RequestParam("image") MultipartFile file, @RequestParam String id) throws IOException {
        File uploadDir = new File(uploadLocation);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String fileName = Timestamp.valueOf(LocalDateTime.now()).toString() + file.getOriginalFilename();
        String filePath = uploadLocation + fileName;
        File dest = new File(filePath);
        file.transferTo(dest);
        model.addAttribute("fileName", fileName);
        Image image = new Image();
        image.setPath(filePath);
        image.setUsedInId(Long.parseLong(id));
        imageRepository.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
    }
}
