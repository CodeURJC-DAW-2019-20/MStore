package store.main.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

	public Brand findFirstByNameIgnoreCase(String name);
	
	public Brand findByName(String name);
	
}
