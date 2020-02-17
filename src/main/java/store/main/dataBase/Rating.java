package store.main.dataBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	private int stars;
	
	@OneToOne
	private User seller;
	
	@OneToOne
	private User buyer;
	
	public Rating() {
		
	}
	
	public Rating(int stars) {
		this.stars = stars;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	
	
}
