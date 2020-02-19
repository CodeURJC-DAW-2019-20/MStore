package store.main.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	public interface BasicInfo {
	};

	public interface PostsInfo {
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicInfo.class)
	private Long id;

	@JsonView(BasicInfo.class)
	private String firstName;

	@JsonView(BasicInfo.class)
	private String lastName;

	@JsonView(BasicInfo.class)
	private String email;

	@JsonView(BasicInfo.class)
	private String phone;

	@JsonView(BasicInfo.class)
	private String password;

	@JsonView(BasicInfo.class)
	private String userAddress;
	
	@JsonView(BasicInfo.class)
	@ElementCollection
	private List<String> tags;

	@JsonView(BasicInfo.class)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonView(PostsInfo.class)
	private List<Post> posts;

	public User() {
		roles = new LinkedList<String>();
		posts = new LinkedList<Post>();
		tags= new LinkedList<String>();
	}

	public User(String firstName, String lastName, String email, String phone, String password, String userAddress,
			String... roles) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
		this.userAddress = userAddress;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =password;
	}
	
	public void setBCryptPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", userAddress=" + userAddress + ", roles=" + roles
				+ ", posts=" + posts + "]";
	}

}