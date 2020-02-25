package store.main.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

	Post findByName(String name);

	List<Post> findByComponentTag(Integer cTag);

	List<Post> findByComponentTagOrderByPriceAsc(Integer tag);

	List<Post> findByComponentTagOrderByPriceDesc(Integer tag);

	List<Post> findByComponentTagOrderByNameAsc(Integer tag);

	List<Post> findByComponentTagOrderByNameDesc(Integer tag);

	List<Post> findByBrandOrderByPriceAsc(Brand brand);

	List<Post> findByBrandOrderByPriceDesc(Brand brand);

	List<Post> findByBrandOrderByNameAsc(Brand brand);

	List<Post> findByBrandOrderByNameDesc(Brand brand);

	List<Post> OrderByIdDesc();

	List<Post> OrderByPriceDesc();

	List<Post> OrderByPriceAsc();

	List<Post> findFirst8ByUserEmail(String email);
}
