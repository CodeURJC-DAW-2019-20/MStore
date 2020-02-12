package store.main.dataBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByComponentTag(Integer cTag);

}
