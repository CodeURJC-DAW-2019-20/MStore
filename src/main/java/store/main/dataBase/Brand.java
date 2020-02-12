package store.main.dataBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Brand {

	public interface BasicInfo {
	};

	public interface PostsInfo {
	};

	@JsonView(BasicInfo.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@JsonView(BasicInfo.class)
	private String name;

	@JsonView(PostsInfo.class)
	@OneToMany
	private List<Post> posts;

	protected Brand() {
		posts = new LinkedList<Post>();
	}

	public Brand(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}

}
