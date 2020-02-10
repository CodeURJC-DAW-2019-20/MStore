package dataBase;

import java.awt.Image;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	private int component; //Motherboard, Storage device	
	private List<String> tags;
	private Integer price;
	private String details;
	private String features;
		
	@ManyToOne
	private Brand brand;
		
	@ManyToOne
	private User user;
	
	public Post() {}

	public Post(Long id, int component, List<String> tags, Integer price, String details, String features, Brand brand,
			User user) {
		super();
		this.id = id;
		this.component = component;
		this.tags = tags;
		this.price = price;
		this.details = details;
		this.features = features;
		this.brand = brand;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getComponent() {
		return component;
	}

	public void setComponent(int component) {
		this.component = component;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
