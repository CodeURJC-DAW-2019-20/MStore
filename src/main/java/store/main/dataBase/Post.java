package store.main.dataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Post {

	public interface BasicInfo {
	};

	public interface UserInfo {
	};

	public interface BrandInfo {
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicInfo.class)
	private Long id;

	@JsonView(BasicInfo.class)
	private int nImg = 0;
	@JsonView(BasicInfo.class)
	private String name;
	@JsonView(BasicInfo.class)
	private String component;
	@JsonView(BasicInfo.class)
	private int componentTag; // Motherboard, Storage device,..
	@JsonView(BasicInfo.class)
	@ElementCollection
	private List<String> tags;
	@JsonView(BasicInfo.class)
	private int price;
	@JsonView(BasicInfo.class)
	private String details;
	@JsonView(BasicInfo.class)
	private String features;
	@JsonView(BasicInfo.class)
	private String postAddress;

	@JsonView(BrandInfo.class)
	@ManyToOne
	private Brand brand;

	@JsonView(UserInfo.class)
	@ManyToOne
	private User user;

	public Post() {
		tags = new LinkedList<String>();
	}

	public Post(String name, int componentTag, int nImg, int price, String details, String features, Brand brand,
			String postAddress, String... tags) {
		this.name = name;
		this.component = category(componentTag);
		this.componentTag = componentTag;
		this.setnImg(nImg);
		this.tags = new ArrayList<>(Arrays.asList(tags));
		this.price = price;
		this.details = details;
		this.features = features;
		this.brand = brand;
		this.postAddress = postAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setPrice(int price) {
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

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", component=" + component + ", tags=" + tags + ", price=" + price + ", details="
				+ details + ", features=" + features + ", postAddress=" + postAddress + ", brand=" + brand + ", user="
				+ user + "]";
	}

	public int getnImg() {
		return nImg;
	}

	public void setnImg(int nImg) {
		this.nImg = nImg;
	}

	private String category(int i) {

		switch (i) {
		case 0:
			return "Motherboards";
		case 1:
			return "Storage Devices";
		case 2:
			return "CPU / Processors";
		case 3:
			return "Video Cards & Video Devices";
		case 4:
			return "Speakers";
		case 5:
			return "Headphones";
		case 6:
			return "Computer Mice";
		case 7:
			return "Monitors";
		case 8:
			return "Ink Printers";
		case 9:
			return "Laser Priter";
		case 10:
			return "3D Printer";
		case 11:
			return "Printer Supplies";
		default:
			return "No category";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public int getComponentTag() {
		return componentTag;
	}

	public void setComponentTag(int componentTag) {
		this.componentTag = componentTag;
	}

	public void setComponentTag(String s) {
		switch (s) {
		case "Motherboards": {
			this.componentTag = 0;
			break;
		}
		case "Storage Devices": {
			this.componentTag = 1;
			break;
		}
		case "CPU / Processors": {
			this.componentTag = 2;
			break;
		}
		case "Video Cards & Video Devices": {
			this.componentTag = 3;
			break;
		}
		case "Speakers": {
			this.componentTag = 4;
			break;
		}
		case "Headphones": {
			this.componentTag = 5;
			break;
		}
		case "Computer Mice": {
			this.componentTag = 6;
			break;
		}
		case "Monitors": {
			this.componentTag = 7;
			break;
		}
		case "Ink Printers": {
			this.componentTag = 8;
			break;
		}
		case "Laser Priter": {
			this.componentTag = 9;
			break;
		}
		case "3D Printer": {
			this.componentTag = 10;
			break;
		}
		case "Printer Supplies":
			this.componentTag = 11;
		}
	}

	public String getComponent() {
		return component;
	}

}
