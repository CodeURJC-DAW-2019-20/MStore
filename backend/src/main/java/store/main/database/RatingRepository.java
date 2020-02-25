package store.main.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {

	public List<Rating> findBySellerEmailIgnoreCaseAndStars(String sellerEmail, int stars);

}
