package pets.cats.data.petscatsdatapersisrence.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pets.cats.data.petscatsdatapersisrence.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
    List<Cat> getCatByBreed(String breed);

    List<Cat> getCatsByColor(String color);
}