package uz.narzullayev.market.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uz.narzullayev.market.MainTest;
import uz.narzullayev.market.entity.Photo;

import static org.junit.jupiter.api.Assertions.*;

class PhotoServiceTest implements MainTest {

    @Autowired
    private PhotoService photoService;
    @Test
    void save() {
        Photo photo=new Photo();
        photo.setId(1);
        photo.setExtension("png");
        photo.setFileSize(10200);
        photoService.save(photo);
    }
}