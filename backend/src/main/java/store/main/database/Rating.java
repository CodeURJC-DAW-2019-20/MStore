package store.main.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import store.main.database.User.BasicInfo;

@Entity
public class Rating {
	public interface BasicInfo {
	};

	public interface BuyerInfo {
	};

	public interface SellerInfo {
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicInfo.class)
	Long id;

	@JsonView(BasicInfo.class)
	private int stars;

	@OneToOne
	@JsonView(SellerInfo.class)
	private User seller;

	@OneToOne
	@JsonView(BuyerInfo.class)
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
