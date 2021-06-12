package uz.narzullayev.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.narzullayev.market.entity.Photo;
import uz.narzullayev.market.repository.PhotoRepository;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;
    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo save(Photo photo) {
       return photoRepository.save(photo);

    }
}
