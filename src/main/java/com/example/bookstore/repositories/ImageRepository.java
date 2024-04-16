package com.example.bookstore.repositories;

import com.example.bookstore.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Long>{
    @Query("SELECT i FROM images i WHERE i.usedInId = ?1")
    Image findByUsedInId(Long id);

    @Query("SELECT i FROM images i WHERE i.path LIKE ?1")
    Image findByPath(String path);
}
