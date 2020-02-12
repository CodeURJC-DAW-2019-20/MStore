package store.main.dataBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByComponentTag(Integer cTag);

	List<Post> findByComponentTagOrderByPriceAsc(Integer tag);

	List<Post> findByComponentTagOrderByPriceDesc(Integer tag);

	List<Post> findByComponentTagOrderByNameAsc(Integer tag);

	List<Post> findByComponentTagOrderByNameDesc(Integer tag);

    

}
